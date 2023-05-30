package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import modelo.AccesoBBDD;
import modelo.Alumno;
import modelo.ProyectoIntegrador;
import vista.AddProyect;
import vista.AlumnProyect;
import vista.AreasProyect;
import vista.ConsulProyect;
import vista.DelProyect;
import vista.ModProyect;

/**
 * Clase que implementa la interfaz ActionListener para el menú principal.
 * Escucha los eventos de clic en los elementos del menú y muestra las ventanas correspondientes.
 */
public class MenuListener implements ActionListener {
	
	private JFrame pConsul;
	AccesoBBDD programa = new AccesoBBDD();
	//esto debería recoger la ventana en la que el usuario se encuentre
    private JFrame currentWindow;

    /**
     * CONSTRUCTOR
     * @param ventana La ventana principal
     */
	public MenuListener(JFrame ventana) {
		this.pConsul = ventana;
    }

    /**
     * Método que se ejecuta al recibir un evento de acción, correspondiente a un elemento del menú.
     * Muestra la ventana correspondiente según el elemento seleccionado.
     * @param e El evento de acción generado por el elemento del menú.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<ProyectoIntegrador> proyectos = mostrarProys();
	    ArrayList<Alumno> listaAlumnos = mostrarAlumns();

		
        if (e.getSource() instanceof JMenuItem) {

        JMenuItem menuItem = (JMenuItem) e.getSource();
        	
	        if (menuItem.getText().equals("Consultas")) {
	            ConsulProyect consulWindow = new ConsulProyect(proyectos);
	            consulWindow.showProys(proyectos);
	            consulWindow.setVisible(true);
	            consulWindow.setListener(this);
	            mostrarProys();
	            //currentWindow.dispose();
	        } else if (menuItem.getText().equals("Añadir Proyecto")) {
	        	AddProyect addWindow = new AddProyect();
	        	addWindow.setVisible(true);
	        	addWindow.setListener(this);
	            //currentWindow.dispose();
	        } else if (menuItem.getText().equals("Borrar Proyecto")) {
	        	DelProyect delWindow = new DelProyect();
	        	delWindow.showProys(proyectos);
	        	delWindow.setVisible(true);
	        	delWindow.setListener(this);
	            //currentWindow.dispose();
	        } else if (menuItem.getText().equals("Modificar Proyecto")) {
	        	ModProyect modWindow = new ModProyect(proyectos);
	        	modWindow.showProys(proyectos);
	        	modWindow.setVisible(true);
	        	modWindow.setListener(this);
	            //currentWindow.dispose();
	        } else if (menuItem.getText().equals("Áreas")) {
	        	AreasProyect areasWindow = new AreasProyect();
	        	areasWindow.setVisible(true);
	        	areasWindow.setListener(this);
	            //currentWindow.dispose();
	        } else if (menuItem.getText().equals("Alumnos")) {
	        	AlumnProyect alumnWindow = new AlumnProyect();
	        	alumnWindow.cargarAlumnos(listaAlumnos);
	        	alumnWindow.setVisible(true);
	        	alumnWindow.setListener(this);
	        	mostrarAlumns();
	            //scurrentWindow.dispose();
	        }
        }
	}
	
    /**
     * Método que carga los proyectos desde la base de datos.
     * @return Una lista de objetos ProyectoIntegrador que representa los proyectos cargados desde la base de datos.
     */
    public ArrayList<ProyectoIntegrador> mostrarProys() {
    	programa.getConexion();
        String query = "SELECT * FROM proyectoIntegrador";
		//return programa.obtenerDatosProyectoDesdeBD();
        return programa.cargarProyectos("SELECT * FROM proyectointegrador");
	}
    
    /**
     * Método que carga los alumnos desde la base de datos.
     * @return Una lista de objetos ProyectoIntegrador que representa los proyectos cargados desde la base de datos.
     */
    public ArrayList<Alumno> mostrarAlumns() {
	    String query = "SELECT * FROM alumno";
		return programa.todosAlumnos(query);
	}
}
//hacer un actionListener - accionesProyecto que: if se hace click en abrir proyecto, se abre, si hace falta borrar, se borra


