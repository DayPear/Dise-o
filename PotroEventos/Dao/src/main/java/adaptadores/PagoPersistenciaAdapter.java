/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Pago;
import entidadesmongo.PagoMongoEntidad;
import excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class PagoPersistenciaAdapter {
    
    public static PagoMongoEntidad convertirAMongo(Pago entidad) throws PersistenciaException {
        if(entidad == null){
            return null;
        }
        
        PagoMongoEntidad mongo = new PagoMongoEntidad();
        mongo.setIdTransaccion(entidad.getIdTransaccion());
        mongo.setFechaOperacion(entidad.getFechaOperacion());
        mongo.setImporte(entidad.getImporte());
        mongo.setMetodoPago(entidad.getMetodoPago());
        
        return mongo;
    }
    
    public static Pago convertirADominio(PagoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Pago entidad = new Pago();
        entidad.setIdTransaccion(mongo.getIdTransaccion());
        entidad.setFechaOperacion(mongo.getFechaOperacion());
        entidad.setImporte(mongo.getImporte());
        entidad.setMetodoPago(mongo.getMetodoPago());
        
        return entidad;
    }
}
