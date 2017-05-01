/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniquindio.ingesis.suturno.desktop;

import co.edu.uniquindio.ingesis.suturno.desktop.acceso.Inicio;
import co.edu.uniquindio.ingesis.suturno.desktop.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.desktop.delegados.GeografiaDelegate;
import co.edu.uniquindio.ingesis.suturno.desktop.delegados.PuestoTrabajoDelegate;
import co.edu.uniquindio.ingesis.suturno.desktop.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.desktop.delegados.TipoClienteDelegate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Run {

    /**
     * Variable que representa la instancia de SuTurnoAplicationRun
     */
    private static final Run instancia = new Run();

    /**
     * Instancias de los delegados
     */
    private EmpleadoDelegate empleadoDelegate = EmpleadoDelegate.getInstancia();
    private GeografiaDelegate geografiaDelegate = GeografiaDelegate.getInstancia();
    private PuestoTrabajoDelegate puestoDelegate = PuestoTrabajoDelegate.getInstancia();
    private ServicioDelegate servicioDelegate = ServicioDelegate.getInstancia();
    private TipoClienteDelegate tipoClienteDelegate = TipoClienteDelegate.getInstancia();

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    instancia.inicializar();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });

    }

    public void inicializar() {
        Inicio inicio = new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }

    public static Run getInstancia() {
        return instancia;
    }

    public ServicioDelegate getServicioDelegate() {
        return servicioDelegate;
    }

    public EmpleadoDelegate getEmpleadoDelegate() {
        return empleadoDelegate;
    }

    public GeografiaDelegate getGeografiaDelegate() {
        return geografiaDelegate;
    }

    public PuestoTrabajoDelegate getPuestoDelegate() {
        return puestoDelegate;
    }

    public TipoClienteDelegate getTipoClienteDelegate() {
        return tipoClienteDelegate;
    }

}
