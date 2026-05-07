package objetosNegocio;

import adapters.SeccionAdapter;
import daos.SeccionDAO;
import dtos.SeccionDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.ISeccionBO;
import java.util.List;

/**
 *
 * @author maria
 */
public class SeccionBO implements ISeccionBO {

    private static SeccionBO instancia;

    private SeccionDAO seccionDAO = SeccionDAO.getInstance();

    private SeccionBO() {
    }

    public static SeccionBO getInstance() {
        if (instancia == null) {
            instancia = new SeccionBO();
        }
        return instancia;
    }

    @Override
    public List<SeccionDTO> consultarSeccionesPorEvento(String idEvento) throws NegocioException {
        try {
            return SeccionAdapter.listaEntidadADTO(seccionDAO.buscarPorEvento(idEvento));
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

}
