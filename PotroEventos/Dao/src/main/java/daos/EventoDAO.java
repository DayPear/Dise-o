package daos;

import Entitys.Evento;
import interfaces.IEventoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementación mock de la DAO de Evento.
 *
 * Simula persistencia en memoria utilizando entidades.
 *
 * @author Kaleb
 */
public class EventoDAO implements IEventoDAO {

    private final List<Evento> eventos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Evento guardar(Evento evento) {
        if (evento.getIdEvento() == null) {
            evento.setIdEvento(idGenerator.getAndIncrement());
            eventos.add(evento);
        } else {
            eliminar(evento.getIdEvento());
            eventos.add(evento);
        }
        return evento;
    }

    @Override
    public List<Evento> obtenerTodos() {
        return new ArrayList<>(eventos);
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventos.stream()
                .filter(e -> e.getIdEvento().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean eliminar(Long id) {
        return eventos.removeIf(e -> e.getIdEvento().equals(id));
    }
}
