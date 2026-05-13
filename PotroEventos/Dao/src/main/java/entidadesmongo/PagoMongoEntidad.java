/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import java.time.LocalDateTime;

/**
 *
 * @author maria
 */
public class PagoMongoEntidad {
    
    private String idTransaccion;
    private LocalDateTime fechaOperacion;
    private double importe;
    private String metodoPago;

    public PagoMongoEntidad() {
    }

    public PagoMongoEntidad(String idTransaccion, LocalDateTime fechaOperacion, double importe, String metodoPago) {
        this.idTransaccion = idTransaccion;
        this.fechaOperacion = fechaOperacion;
        this.importe = importe;
        this.metodoPago = metodoPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public LocalDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "CobroMongoEntidad{" 
                + "idTransaccion=" + idTransaccion 
                + ", fechaOperacion=" + fechaOperacion 
                + ", importe=" + importe 
                + ", metodoPago=" + metodoPago 
                + '}';
    }
    
}
