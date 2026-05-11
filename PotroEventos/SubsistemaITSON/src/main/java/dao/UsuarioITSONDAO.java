/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionBD;
import dominio.UsuarioITSON;
import excepciones.ITSONException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author maria
 */
public class UsuarioITSONDAO {
    
    private static UsuarioITSONDAO instance;
    
    private UsuarioITSONDAO(){
    }
    
    
    public static UsuarioITSONDAO getInstance(){
        if(instance == null){
            instance = new UsuarioITSONDAO();
        }
        return instance;
    }
    
    public UsuarioITSON consultarUsuario(UsuarioITSON usuario) throws ITSONException {
        EntityManager em = ConexionBD.crearConexion();
        try{
            String jpql = "select u from UsuarioITSON u where u.identificador = :idITSON and u.contrasenia = :contraITSON";
            TypedQuery<UsuarioITSON> query = em.createQuery(jpql, UsuarioITSON.class);
            query.setParameter("idITSON", usuario.getIdentificador());
            query.setParameter("contraITSON", usuario.getContrasenia());
            UsuarioITSON resultado = query.getSingleResult();
            return resultado;
        } catch(Exception e){
            throw new ITSONException(e.getMessage());
        } finally {
            em.close();
        }
    }
}
