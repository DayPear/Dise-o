package daos;

import Entitys.Usuario;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;

/**
 *
 * @author aaron
 */
public class UsuarioDAO implements IUsuarioDAO {

    private static UsuarioDAO instance;

    private MongoCollection<Usuario> coleccionUsuarios;

    private UsuarioDAO() {
        this.coleccionUsuarios = ConexionMongo.obtenerBaseDatos().getCollection("usuarios", Usuario.class);
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    @Override
    public boolean restarCreditos(Integer cantidad, String idUsuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerUsuario(Usuario usuario) throws PersistenciaException {
        if (usuario == null) {
            throw new PersistenciaException("El usuario no puede ser null.");
        }

        try {
            return this.coleccionUsuarios.find(
                    and(eq("correo", usuario.getCorreo()), eq("contrasenia", usuario.getContrasenia()))
            ).first();
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener al usuario");
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws PersistenciaException {
        if (usuario == null) {
            throw new PersistenciaException("El usuario no puede ser null.");

        }

        try {
            InsertOneResult resultado = this.coleccionUsuarios.insertOne(usuario);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar al usuario");
            }

            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();

            usuario.setIdUsuario(idGenerado);

            return usuario;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible guardar al usuario");
        }
    }

}
