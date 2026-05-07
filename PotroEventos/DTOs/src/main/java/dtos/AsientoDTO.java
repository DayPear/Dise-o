package dtos;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoDTO {

    private String idAsiento;
    private String fila;
    private Integer numero;
    /*
    igual, no le muevo pero es mejor que tenga su objeto completo
     */
    private String idseccion;

    public AsientoDTO() {
    }

    public AsientoDTO(String idAsiento, String fila, Integer numero, String idseccion) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.idseccion = idseccion;
    }

    public AsientoDTO(String fila, Integer numero, String idseccion) {
        this.fila = fila;
        this.numero = numero;
        this.idseccion = idseccion;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getIdSeccion() {
        return idseccion;
    }

    public void setIdSeccion(String idseccion) {
        this.idseccion = idseccion;
    }

    public String getNombreCompleto() {
        return this.fila + "-" + this.numero;
    }

    @Override
    public String toString() {
        return "AsientoDTO{" + "idAsiento=" + idAsiento + ", fila=" + fila + ", numero=" + numero + ", idseccion=" + idseccion + '}';
    }

}
