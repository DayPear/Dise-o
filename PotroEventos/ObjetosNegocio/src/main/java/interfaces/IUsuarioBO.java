/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.LoginDTO;
import dtos.UsuarioDTO;

/**
 *
 * @author aaron
 */
public interface IUsuarioBO {

    public UsuarioDTO obtenerUsuario(LoginDTO sesion);

    public boolean restarCreditos(Integer cantidad, String idUsuario);

    public UsuarioDTO guardarUsuario(UsuarioDTO usuario);
}
