/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adapters.UsuarioAdapter;
import dtos.LoginDTO;
import dtos.UsuarioDTO;
import interfaces.IUsuarioBO;
import daos.UsuarioDAO;
import interfaces.IUsuarioDAO;

/**
 *
 * @author aaron
 */
public class UsuarioBO implements IUsuarioBO {

    private static UsuarioBO instance;

    private IUsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

    private UsuarioBO() {

    }

    public static UsuarioBO getInstance() {
        if (instance == null) {
            instance = new UsuarioBO();
        }
        return instance;
    }

    @Override
    public boolean restarCreditos(Integer cantidad, Long idUsuario) {
        return usuarioDAO.restarCreditos(cantidad, idUsuario);
    }

    @Override
    public UsuarioDTO obtenerUsuario(LoginDTO sesion) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setCorreo(sesion.getCorreo());
        usuario.setContrasenia(sesion.getContrasenia());

        return UsuarioAdapter.entidadADTO(usuarioDAO.obtenerUsuario(UsuarioAdapter.dtoAEntidad(usuario)));
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO dto) {
        return UsuarioAdapter.entidadADTO(usuarioDAO.guardarUsuario(UsuarioAdapter.dtoAEntidad(dto)));
    }

}
