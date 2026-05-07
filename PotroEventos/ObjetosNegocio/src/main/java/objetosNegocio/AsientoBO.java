/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import Entitys.Asiento;
import adapters.AsientoAdapter;
import daos.AsientoDAO;
import dtos.AsientoDTO;
import excepciones.NegocioException;
import interfaces.IAsientoBO;
import java.util.List;

/**
 *
 * @author maria
 */
public class AsientoBO implements IAsientoBO {

    private static AsientoBO instancia;

    private AsientoDAO asientoDAO = new AsientoDAO();

    private AsientoBO() {
    }

    public static AsientoBO getInstance() {
        if (instancia == null) {
            instancia = new AsientoBO();
        }
        return instancia;
    }

    @Override
    public List<AsientoDTO> consultarTodosLosAsientos() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AsientoDTO> consultarPorSeccion(String idSeccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
