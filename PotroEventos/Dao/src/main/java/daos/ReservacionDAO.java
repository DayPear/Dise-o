/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entitys.Reservacion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.IReservacionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class ReservacionDAO implements IReservacionDAO {
    
    private MongoCollection<Reservacion> coleccionReservaciones = ConexionMongo.obtenerBaseDatos().getCollection("reservaciones", Reservacion.class);
    private static ReservacionDAO instance;
    
    private ReservacionDAO() {
    }
    
    public static ReservacionDAO getInstance() {
        if (instance == null) {
            instance = new ReservacionDAO();
        }
        return instance;
    }
    
    @Override
    public Reservacion guardarReservacion(Reservacion reservacion) throws PersistenciaException {
        if (reservacion == null) {
            throw new PersistenciaException("La reservacion no puede ser nula.");
        }
        
        try {
            InsertOneResult resultado = this.coleccionReservaciones.insertOne(reservacion);
            
            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar.");
            }
            
            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();
            
            reservacion.setIdReservacion(idGenerado);
            
            return reservacion;
            
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible guardar la reservación.");
        }
        
    }
    
    @Override
    public List<Reservacion> obtenerReservacionesUsuario(String idUsuario) throws PersistenciaException {
        try {
            return this.coleccionReservaciones.find(eq("idUsuario", new ObjectId(idUsuario))).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible obtener las reservaciones");
        }
    }
    
}
