/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicioSistema;

import Controlador.coordinador.CoordinadorAplicacion;
import Controlador.interfaz.ICoordinadorAplicacion;
import javax.swing.UIManager;

/**
 *&
 * @author maria
 */
public class InicioPotroEventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        ICoordinadorAplicacion inicio = new CoordinadorAplicacion();
        inicio.mostrarInicioSesion();
    }

}
