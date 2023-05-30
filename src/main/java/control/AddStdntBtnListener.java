package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import modelo.AccesoBBDD;
import modelo.ProyectoIntegrador;
import vista.AddAlumn;
import vista.OpenConsulProy;

public class AddStdntBtnListener implements ActionListener {
	private JList<String> projectList;

	AccesoBBDD programa = new AccesoBBDD();
	AddAlumn projectDetailsWindow;

//	public AddStdntBtnListener(JList<String> projectList) {
//		this.projectList = projectList;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String selectedAlumnn = projectList.getSelectedValue();
		if (selectedAlumnn != null) {
			System.out.println("Proyecto seleccionado: " + selectedAlumnn);
			int posicionGuion = selectedAlumnn.indexOf('-');
			String nombreAlumno = selectedAlumnn.substring(0, posicionGuion);
			nombreAlumno = nombreAlumno.trim();
			System.out.println("Nombre de proyecto ->" + nombreAlumno + "<-");

			ProyectoIntegrador proyectoSeleccionado = new ProyectoIntegrador();
			programa.getConexion();
			proyectoSeleccionado = programa.obtenerDatosProyectoDesdeBD(nombreAlumno);

			// Crea una instancia de la ventana de modificación de proyecto
			projectDetailsWindow = new AddAlumn();

			// Establece los valores de los campos de la ventana de detalles del proyecto
			projectDetailsWindow.getNumExpTxtF().setText(proyectoSeleccionado.getIdProyecto());
			projectDetailsWindow.getidTxtF().setText(proyectoSeleccionado.getNombreProyecto());
			projectDetailsWindow.getNombreTxtF().setText(proyectoSeleccionado.getNota());
			projectDetailsWindow.getApellidosTxtF().setText(proyectoSeleccionado.getFecha());
//			projectDetailsWindow.getCursoTxtF().setText(proyectoSeleccionado.getCurso());
//			projectDetailsWindow.getAreaTxtF().setText(proyectoSeleccionado.getAreaCorrespondiente());
//			
			// Hace visible la ventana de modificación de proyecto
			projectDetailsWindow.hacerVisible();

		} else {
			System.out.println("No hay ningún proyecto seleccionado.");
		}

		// Aquí no recogemos el TextField, recogemos los datos de la BBDD

	}
}
