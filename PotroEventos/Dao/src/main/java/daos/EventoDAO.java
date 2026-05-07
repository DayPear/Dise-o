package daos;

import Entitys.Categoria;
import Entitys.Evento;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.IEventoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Implementación mock de la DAO de Evento. Simula persistencia en memoria
 * utilizando una lista.
 *
 * * @author Kaleb
 */
public class EventoDAO implements IEventoDAO {

    private final MongoCollection<Evento> coleccionEventos;

    private static EventoDAO instancia;

    public EventoDAO() {
        this.coleccionEventos = ConexionMongo.obtenerBaseDatos().getCollection("eventos", Evento.class);
    }

    public static EventoDAO getInstance() {
        if (instancia == null) {
            instancia = new EventoDAO();
        }
        return instancia;
    }

    @Override
    public Evento buscarPorId(String idEvento) throws PersistenciaException {
        try {
            Evento evento = this.coleccionEventos.find(eq("_id", new ObjectId(idEvento))).first();

            return evento;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible buscar el evento");
        }
    }

    @Override
    public List<Evento> buscarTodosCategoria(Categoria categoria) throws PersistenciaException {
        try {

            return this.coleccionEventos.find(eq("categoria", categoria.getNombre())).into(new ArrayList<>());

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener los eventos");
        }
    }

    @Override
    public Evento guardar(Evento evento) throws PersistenciaException {
        if (evento == null) {
            throw new PersistenciaException("El evento no puede ser null");
        }

        if (evento.getFechaHora() == null) {
            evento.setFechaHora(LocalDateTime.now());
        }

        try {
            InsertOneResult resultado = this.coleccionEventos.insertOne(evento);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar.");
            }
            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();

            evento.setIdEvento(idGenerado);

            return evento;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible guardar el evento");
        }
    }

    @Override
    public Evento actualizarEvento(Evento evento) throws PersistenciaException {
        if (evento == null) {
            throw new PersistenciaException("El evento no puede ser null");
        }

        if (evento.getIdEvento() == null) {
            throw new PersistenciaException("El id del evento es requerido");
        }

        try {

            UpdateResult resultado = this.coleccionEventos.replaceOne(eq("_id", new ObjectId(evento.getIdEvento())), evento);

            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el evento");
            }

            return evento;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible actualizar el evento");
        }
    }

}
