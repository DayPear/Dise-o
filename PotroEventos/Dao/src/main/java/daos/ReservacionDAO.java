/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entitys.Reservacion;
import interfaces.IReservacionDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class ReservacionDAO implements IReservacionDAO {

    private static List<Reservacion> reservaciones = new ArrayList<>();
    private static ReservacionDAO instance;

    private ReservacionDAO() {
    }

    public static ReservacionDAO getInstance() {
        if (instance == null) {
            instance = new ReservacionDAO();
        }
        return instance;
    }

    @Override
    public boolean guardarReservacion(Reservacion reservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Reservacion> obtenerReservacionesUsuario(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
