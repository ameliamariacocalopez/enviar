package control;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JList;

import modelo.AccesoBBDD;
import modelo.ProyectoIntegrador;
import vista.ModProyect;
import vista.OpenConsulProy;
import vista.V_ModProyect;

public class modBtnListener implements ActionListener {
	private JList<String> projectList;
	AccesoBBDD programa = new AccesoBBDD();
	V_ModProyect projectDetailsWindow;
	
	public modBtnListener(JList<String> modProjList) {
		this.projectList = modProjList;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// recoge el item seleccionado
		String selectedProject = projectList.getSelectedValue();
		if (selectedProject != null) {
			System.out.println("Proyecto seleccionado: " + selectedProject);
			int posicionGuion = selectedProject.indexOf('-');
			String nombreProyecto = selectedProject.substring(0, posicionGuion);
			nombreProyecto = nombreProyecto.trim();
			System.out.println("Nombre de proyecto ->" + nombreProyecto + "<-");

			
			ProyectoIntegrador proyectoSeleccionado = new ProyectoIntegrador();
			programa.getConexion();
			proyectoSeleccionado = programa.obtenerDatosProyectoDesdeBD(nombreProyecto);
			
			// Crea una instancia de la ventana de modificación de proyecto
			projectDetailsWindow = new V_ModProyect();

			// Establece los valores de los campos de la ventana de detalles del proyecto
			projectDetailsWindow.getIdTxtF().setText(proyectoSeleccionado.getIdProyecto());
			projectDetailsWindow.getNombreProyTxtF().setText(proyectoSeleccionado.getNombreProyecto());
			projectDetailsWindow.getUrlTxtF().setText(proyectoSeleccionado.getUrlProyecto());
			projectDetailsWindow.getNotaTxtF().setText(proyectoSeleccionado.getNota());
			projectDetailsWindow.getFechaTxtF().setText(proyectoSeleccionado.getFecha());
			projectDetailsWindow.getCursoTxtF().setText(proyectoSeleccionado.getCurso());
//			projectDetailsWindow.getAreaTxtF().setText(proyectoSeleccionado.getAreaCorrespondiente());
			
			// Hace visible la ventana de modificación de proyecto
			projectDetailsWindow.isVisible();

		} else {
			System.out.println("No hay ningún proyecto seleccionado.");
		}

		// Aquí no recogemos el TextField, recogemos los datos de la BBDD

	}

	}
	
//		V_ModProyect modProyWindow = new V_ModProyect();
//		modProyWindow.setVisible(true);


		
		
//      JTextField nameTxtF = modProyWindow.getNameTxtF();
//      JTextField lastNameTxtF = modProyWindow.getLastNamesTxtF();
        //Termonar de crear y guardar el resto de fields 
//      String editedName = nameTxtF.getText();
//      String editedLastNames = lastNameTxtF.getText();
        
//      Actualizar al estudiante con la base de dato