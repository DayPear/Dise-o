/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase controlador de  inicio de sesion que gestiona el control interno de todo lo que tiene que ver con la
 * gestion de inicio de sesion
 * 
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
import dtos.LoginDTO;
public class ControlInicioSesion {
        
    private List<UsuarioDTO> listaUsuarios = new ArrayList<>();
    
    private static ControlInicioSesion instance;
    
    private ControlInicioSesion(){}
    
    public static ControlInicioSesion getIntance(){
        if(instance == null){
            instance = new ControlInicioSesion();
        }
        return instance;
    }
    
    /**
     * 
     * @param login
     * @return 
     */
    public UsuarioDTO iniciarSesion(LoginDTO login){
        
        for(UsuarioDTO usuario : listaUsuarios){
            if(usuario.getCorreo().equals(login.getCorreo())){
                if(usuario.getContrasenia().equals(login.getContrasenia())){
                    return usuario;
                }
            }
        }
        return null;
    }
    
    public UsuarioDTO verificarUsuario(String correo, String contrasenia){
        if(correo.isEmpty() || contrasenia.isEmpty()){
            return null;
        }
        return this.iniciarSesion(new LoginDTO(correo, contrasenia));
    }
}
