package daos;

import Entitys.AsientoEvento;
import Entitys.ENUMS.EstadoAsiento;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.IAsientoEventoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * DAO mock para la gestión de asientos por evento.
 *
 * Esta implementación utiliza una lista en memoria a nivel de clase para
 * facilitar pruebas unitarias y simulaciones sin necesidad de base de datos
 * real.
 *
 * Permite consultar los asientos de un evento y reservar un asiento únicamente
 * si aún se encuentra disponible.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoEventoDAO implements IAsientoEventoDAO {

    private static AsientoEventoDAO instancia;

    /**
     * Lista mock a nivel de clase para persistencia en memoria. Esto permite
     * que las pruebas mantengan estado entre llamadas.
     */
    private final MongoCollection<AsientoEvento> coleccionAsientosEventos;

    private AsientoEventoDAO() {
        this.coleccionAsientosEventos = ConexionMongo.obtenerBaseDatos().getCollection("asientoEventos", AsientoEvento.class);
    }

    public static AsientoEventoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AsientoEventoDAO();
        }
        return instancia;
    }

    @Override
    public List<AsientoEvento> buscarPorEvento(String idEvento) throws PersistenciaException {
        return this.coleccionAsientosEventos.find(eq("idEvento", new ObjectId(idEvento))).into(new ArrayList<>());

    }

    @Override
    public boolean reservarAsiento(String idAsiento) throws PersistenciaException {
        try {
            AsientoEvento asiento = this.coleccionAsientosEventos.find(eq("_id", new ObjectId(idAsiento))).first();
            if (asiento == null) {
                throw new PersistenciaException("AsientoEvento no encontrado");
            }

            asiento.setEstadoAsiento(EstadoAsiento.RESERVADO);

            UpdateResult resultado = this.coleccionAsientosEventos.replaceOne(eq("_id", new ObjectId(asiento.getIdAsientoEvento())), asiento);
            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el asiento");
            }
            return true;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible reservar el asiento");
        }
    }

    @Override
    public boolean liberarAsiento(String idAsiento) throws PersistenciaException {
        try {
            AsientoEvento asiento = this.coleccionAsientosEventos.find(eq("_id", new ObjectId(idAsiento))).first();
            if (asiento == null) {
                throw new PersistenciaException("AsientoEvento no encontrado");
            }

            asiento.setEstadoAsiento(EstadoAsiento.DISPONIBLE);

            UpdateResult resultado = this.coleccionAsientosEventos.replaceOne(eq("_id", new ObjectId(asiento.getIdAsientoEvento())), asiento);
            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el asiento");
            }
            return true;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible liberar el asiento");
        }
    }

    @Override
    public boolean venderAsiento(String idAsiento) throws PersistenciaException {
        try {
            AsientoEvento asiento = this.coleccionAsientosEventos.find(eq("_id", new ObjectId(idAsiento))).first();
            if (asiento == null) {
                throw new PersistenciaException("AsientoEvento no encontrado");
            }

            asiento.setEstadoAsiento(EstadoAsiento.VENDIDO);

            UpdateResult resultado = this.coleccionAsientosEventos.replaceOne(eq("_id", new ObjectId(asiento.getIdAsientoEvento())), asiento);
            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el asiento");
            }
            return true;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible vender el asiento");
        }
    }

}
