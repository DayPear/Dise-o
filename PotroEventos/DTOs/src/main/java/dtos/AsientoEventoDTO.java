package dtos;

import dtos.ENUMS.EstadoAsientoDTO;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoEventoDTO {

    private String idReservacion;
    private EstadoAsientoDTO estadoAsiento;
    private String idAsiento;
    private String idEvento;

    public AsientoEventoDTO() {
    }

    public AsientoEventoDTO(String idReservacion, EstadoAsientoDTO estadoAsiento, String idAsiento, String idEvento) {
        this.idReservacion = idReservacion;
        this.estadoAsiento = estadoAsiento;
        this.idAsiento = idAsiento;
        this.idEvento = idEvento;
    }

    public AsientoEventoDTO(EstadoAsientoDTO estadoAsiento, String idAsiento, String idEvento) {
        this.estadoAsiento = estadoAsiento;
        this.idAsiento = idAsiento;
        this.idEvento = idEvento;
    }

    public String getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(String idReservacion) {
        this.idReservacion = idReservacion;
    }

    public EstadoAsientoDTO getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsientoDTO estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "AsientoEventoDTO{" + "idReservacion=" + idReservacion + ", estadoAsiento=" + estadoAsiento + ", idAsiento=" + idAsiento + ", idEvento=" + idEvento + '}';
    }

}
