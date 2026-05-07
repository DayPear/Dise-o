package Entitys;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class Asiento {

    private String idAsiento;
    private String fila;
    private Integer numero;
    private Seccion seccion;

    public Asiento() {
    }

    public Asiento(String idAsiento, String fila, Integer numero, Seccion seccion) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.seccion = seccion;
    }

    public Asiento(String fila, Integer numero, Seccion seccion) {
        this.fila = fila;
        this.numero = numero;
        this.seccion = seccion;
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

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", fila=" + fila + ", numero=" + numero + ", seccion=" + seccion + '}';
    }

}
