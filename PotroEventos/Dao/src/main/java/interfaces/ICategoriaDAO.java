package interfaces;

import Entitys.Categoria;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author maria
 */
public interface ICategoriaDAO {

    List<Categoria> consultarCategorias() throws PersistenciaException;

    Categoria registrarCategoria(Categoria categoria) throws PersistenciaException;

}
