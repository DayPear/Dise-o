package daos;

import Entitys.Asiento;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.IAsientoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * @author Kaleb
 */
public class AsientoDAO implements IAsientoDAO {

    private final MongoCollection<Asiento> coleccionAsientos;

    private static AsientoDAO instancia;

    public AsientoDAO() {
        this.coleccionAsientos = ConexionMongo.obtenerBaseDatos().getCollection("asientos", Asiento.class);
    }

    public static AsientoDAO getInstance() {
        if (instancia == null) {
            instancia = new AsientoDAO();
        }
        return instancia;
    }

    @Override
    public List<Asiento> consultarAsientos() throws PersistenciaException {
        try {
            return this.coleccionAsientos.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener los asientos");
        }
    }

}
