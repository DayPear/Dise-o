package Entitys;

import Entitys.ENUMS.CategoriaEvento;
import Entitys.ENUMS.EstadoEvento;
import java.time.LocalDateTime;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class Evento {

    private Long idEvento;
    private Categoria categoriaEvento;
    private String nombreEvento;
    private String informacionEvento;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private EstadoEvento estadoEvento;
    private String urlImagen;

    public Evento() {
    }

    public Evento(Long idEvento, Categoria categoriaEvento, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion, EstadoEvento estadoEvento, String urlImagen) {
        this.idEvento = idEvento;
        this.categoriaEvento = categoriaEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.estadoEvento = estadoEvento;
        this.urlImagen = urlImagen;
    }

    public Evento(Categoria categoriaEvento, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion, EstadoEvento estadoEvento, String urlImagen) {
        this.categoriaEvento = categoriaEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.estadoEvento = estadoEvento;
        this.urlImagen = urlImagen;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Categoria getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(Categoria categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getInformacionEvento() {
        return informacionEvento;
    }

    public void setInformacionEvento(String informacionEvento) {
        this.informacionEvento = informacionEvento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoEvento getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(EstadoEvento estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", categoriaEvento=" + categoriaEvento + ", nombreEvento=" + nombreEvento + ", informacionEvento=" + informacionEvento + ", fechaHora=" + fechaHora + ", ubicacion=" + ubicacion + ", estadoEvento=" + estadoEvento + ", urlImagen=" + urlImagen + '}';
    }

}
