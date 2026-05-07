package daos;

import Entitys.Asiento;
import Entitys.AsientoEvento;
import Entitys.Categoria;
import Entitys.ENUMS.EstadoAsiento;
import Entitys.Seccion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.IAsientoEventoDAO;
import java.util.ArrayList;
import java.util.List;

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
    private final MongoCollection<AsientoEvento> asientosEventos;

    private AsientoEventoDAO() {
        this.asientosEventos = ConexionMongo.obtenerBaseDatos().getCollection("asientoEventos", AsientoEvento.class);
    }

    public static AsientoEventoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AsientoEventoDAO();
        }
        return instancia;
    }

    @Override
    public List<AsientoEvento> buscarPorEvento(String idEvento) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean reservarAsiento(String idAsiento) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean liberarAsiento(String idAsiento) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean venderAsiento(String idAsiento) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
