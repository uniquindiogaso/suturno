package co.edu.uniquindio.ingesis.suturno.desktop.delegados;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.negocio.ServiciosEJB;
import co.edu.uniquindio.ingesis.suturno.negocio.ServiciosEJBRemote;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;

/**
 * Delegado del servicio
 *
 * @author Gustavo Salgado y Laura Julieth Rua
 *
 * @author Ingenier�a de Sistemas y Computacion
 *
 * @author Universidad del Quindio
 *
 * @version 1.0
 *
 * @since 12/04/2017
 */
public class ServicioDelegate {

    /**
     * Variable que representa los ServiciosEJBRemote
     */
    private ServiciosEJBRemote servicioEJB;

    /**
     * Variable que representa la instancia de los ServciosDelegate
     */
    private static final ServicioDelegate instancia = new ServicioDelegate();

    /**
     * Metodo constructor del ServicioDelegate
     */
    private ServicioDelegate() {
        try {

            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

            // glassfish default port value will be 3700,
            // but im using tcpviewer to redirect my 50005 port to 3700
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            InitialContext ctx = new InitialContext(props);

            servicioEJB = (ServiciosEJBRemote) ctx.lookup(ServiciosEJB.JNDI);
        } catch (NamingException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Metodo que permite registrar un servicio
     *
     * @param servicio Servicio a ser registrado
     * @return El servicio registrado, o null en caso de que no se haya podido
     * registrar
     */
    public Servicio registrarServicio(Servicio servicio) {
        return servicioEJB.registrarServicio(servicio);
    }

    /**
     * Metodo que permite buscar un servicio basado en su nombre
     *
     * @param nombre Nombre del servicio que se desea buscar
     * @return El servicio que se corresponde con el nombre dado, en caso de no
     * encontar el servicio se retorna null
     */
    public Servicio buscarServicioPorNombre(String nombre) {
        return servicioEJB.buscarServicioPorNombre(nombre);
    }

    /**
     * Metodo que permite obtener todos los servicios registrados en el sistema
     *
     * @return {@link List} de {@link Servicio} registrados en el sistema
     */
    public List<Servicio> listarServicios() {
        return servicioEJB.listarServicios();
    }

    /**
     * Metodo que permite remover un servicio
     *
     * @param servicio Servicio a ser eliminado
     */
    public void eliminarServicio(Servicio servicio) {
        servicioEJB.eliminarServicio(servicio);
    }

    /**
     * Metodo que permite actualizar un servicio
     *
     * @param servicio Servicio a ser actualizado
     * @return El servicio actualizar, o null en caso de que no se haya podido
     * registrar
     */
    public Servicio actualizarServicio(Servicio servicio) {
        return servicioEJB.actualizarServicio(servicio);
    }

    /**
     * Metodo get de la instancia del ServicioDelegate
     *
     * @return instancia la instancia del ServicioDelegate
     */
    public static ServicioDelegate getInstancia() {
        return instancia;
    }

}
