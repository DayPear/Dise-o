package control;

import dtos.*;
import dtos.ENUMS.EstadoAsientoDTO;
import dtos.ENUMS.EstadoEventoDTO;
import Entitys.*;
import negocio.*;
import excepciones.CompraBoletoException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador de caso de uso para la compra de boletos. Orquesta la
 * comunicación con los BOs y transforma Entidades a DTOs.
 *
 * * @author Kaleb
 */
public class ControlCompraBoleto {

    // Dependencias a la capa de Negocio (BOs)
    private final EventoBO eventoBO;
    private final SeccionBO seccionBO;
    private final AsientoBO asientoBO;
    private final AsientoEventoBO asientoEventoBO;

    public ControlCompraBoleto() {
        this.eventoBO = new EventoBO();
        this.seccionBO = new SeccionBO();
        this.asientoBO = new AsientoBO();
        this.asientoEventoBO = new AsientoEventoBO();
    }

    /**
     * Obtiene el evento desde el BO y lo convierte a EventoDTO.
     */
    public EventoDTO obtenerInformacionEvento(Long idEvento) throws CompraBoletoException {
        try {
            Evento e = eventoBO.consultarEventoPorId(idEvento);
            if (e == null) {
                throw new CompraBoletoException("El evento con ID " + idEvento + " no fue encontrado.");
            }

            // Conversión de Entidad a DTO usando tu constructor
            CategoriaDTO catDTO = new CategoriaDTO(e.getCategoria().getIdCategoria(), e.getCategoria().getNombre());

            return new EventoDTO(
                    e.getIdEvento(),
                    catDTO,
                    e.getNombre(),
                    e.getInformacion(),
                    e.getFechaHora(),
                    e.getUbicacion(),
                    EstadoEventoDTO.valueOf(e.getEstado().name()), // Asumiendo mapeo de Enum
                    e.getUrlImagen()
            );
        } catch (Exception ex) {
            throw new CompraBoletoException("Error al obtener la información del evento: " + ex.getMessage());
        }
    }

    /**
     * Obtiene las secciones de un evento y las convierte a SeccionDTO.
     */
    public List<SeccionDTO> obtenerSeccionesEvento(Long idEvento) throws CompraBoletoException {
        try {
            List<Seccion> secciones = seccionBO.consultarSeccionesPorEvento(idEvento);
            List<SeccionDTO> seccionesDTO = new ArrayList<>();

            for (Seccion s : secciones) {
                seccionesDTO.add(new SeccionDTO(
                        s.getIdSeccion(),
                        s.getNombre(),
                        s.getCapacidad(),
                        s.getPrecioBase()
                ));
            }
            return seccionesDTO;
        } catch (Exception ex) {
            throw new CompraBoletoException("Error al cargar las secciones: " + ex.getMessage());
        }
    }

    /**
     * Obtiene los estados de los asientos (ocupados/disponibles) y los
     * convierte a AsientoEventoDTO.
     */
    public List<AsientoEventoDTO> obtenerOcupacionEvento(Long idEvento) throws CompraBoletoException {
        try {
            List<AsientoEvento> estados = asientoEventoBO.consultarEstadosPorEvento(idEvento);

            return estados.stream().map(ae -> new AsientoEventoDTO(
                    ae.getReservacion() != null ? ae.getReservacion().getIdReservacion() : null,
                    EstadoAsientoDTO.valueOf(ae.getEstado().name()),
                    ae.getAsiento().getIdAsiento(),
                    ae.getEvento().getIdEvento()
            )).collect(Collectors.toList());

        } catch (Exception ex) {
            throw new CompraBoletoException("Error al cargar la ocupación del evento: " + ex.getMessage());
        }
    }

    /**
     * Obtiene el catálogo físico de asientos y lo convierte a AsientoDTO.
     */
    public List<AsientoDTO> obtenerCatalogoAsientos() throws CompraBoletoException {
        try {
            List<Asiento> asientos = asientoBO.consultarTodosLosAsientos();

            return asientos.stream().map(a -> new AsientoDTO(
                    a.getIdAsiento(),
                    a.getFila(),
                    a.getNumero(),
                    a.getSeccion().getIdSeccion()
            )).collect(Collectors.toList());

        } catch (Exception ex) {
            throw new CompraBoletoException("Error al cargar el catálogo de asientos: " + ex.getMessage());
        }
    }
}
