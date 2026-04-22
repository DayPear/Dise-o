package daos;

import Entitys.Evento;
import interfaces.IEventoDAO;
import java.util.List;


/**
 * Implementación mock de la DAO de Evento.
 *
 * Simula persistencia en memoria utilizando entidades.
 *
 * @author Kaleb
 */
public class EventoDAO implements IEventoDAO {

    @Override
    public Evento buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Evento> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evento guardar(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
