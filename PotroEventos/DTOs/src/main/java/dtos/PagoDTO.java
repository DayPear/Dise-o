/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;

/**
 *
 * @author maria
 */
public class PagoDTO {
    
    private String idTransaccion;
    private LocalDateTime fechaOperacion;
    private Double importe;
    private String metodoPago;

    public PagoDTO() {
    }

    public PagoDTO(String idTransaccion, LocalDateTime fechaOperacion, Double importe, String metodoPago) {
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

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
}
