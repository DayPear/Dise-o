package interfaces;

import Entitys.Evento;
import java.util.List;

/**
 * Interfaz de acceso a datos para la entidad Evento.
 *
 * Define operaciones CRUD utilizando entidades del dominio.
 *
 * @author Kaleb
 */
public interface IEventoDAO {

    Evento guardar(Evento evento);

    List<Evento> obtenerTodos();

    Evento buscarPorId(Long id);

    boolean eliminar(Long id);
}
