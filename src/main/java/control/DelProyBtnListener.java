package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import modelo.AccesoBBDD;
import modelo.ProyectoIntegrador;

/**
 * Clase que implementa la interfaz ActionListener para el botón de Eliminar Proyecto.
 * Elimina el proyecto seleccionado de la lista de proyectos.
 */
public class DelProyBtnListener implements ActionListener {
	private JList<String> projectList;
	AccesoBBDD programa = new AccesoBBDD();
	
    /**
     * Constructor de la clase DelProyBtnListener.
     * @param projectList La lista de proyectos
     */
    public DelProyBtnListener(JList<String> projectList) {
        this.projectList = projectList;
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón de Eliminar Proyecto.
     * Elimina el proyecto seleccionado de la lista de proyectos.
     * @param e El evento de acción generado por el botón de Eliminar Proyecto.
     */
	@Override
    public void actionPerformed(ActionEvent e) {
        int selectedProy = projectList.getSelectedIndex();
        //si selectedProy no es = -1, hay una opción seleccionada
        if (selectedProy != -1) {
            int alerta = JOptionPane.showConfirmDialog(null, "¿Quieres borrar este proyecto?", "Alerta", JOptionPane.YES_NO_OPTION);
            if (alerta == JOptionPane.YES_OPTION) {
                DefaultListModel<String> model = (DefaultListModel<String>) projectList.getModel();
                model.remove(selectedProy);
            }
        } else {
        	JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún proyecto,", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	/**
     * Método que obtiene la lista de proyectos a borrar desde la base de datos.
     * @return Una lista de objetos ProyectoIntegrador que representa los proyectos cargados desde la base de datos.
     */
	public ArrayList<ProyectoIntegrador> borrarProys() {
        String query = "SELECT * FROM proyectoIntegrador";
//		return programa.obtenerDatosProyectoDesdeBD();
        return programa.cargarProyectos("SELECT * FROM proyecto");
	}

}
