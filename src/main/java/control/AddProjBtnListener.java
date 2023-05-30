package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.AccesoBBDD;
import modelo.Alumno;
import vista.AddProyect;

/**
 * Clase que implementa ActionListener para el botón de agregar proyecto en la vista AddProyect.
 */
public class AddProjBtnListener implements ActionListener {
	private AddProyect v;
	AccesoBBDD programa = new AccesoBBDD();

	/**
     * Constructor de la clase AddProjBtnListener.
     * @param vista La instancia de AddProyect a la que se asocia este listener.
     */
	public AddProjBtnListener(AddProyect vista) {
		this.v = vista;
    }

	/**
     * Método que se invoca cuando se produce un evento de acción.
     * @param e El evento de acción.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(programa.proyectoRepetido()) {
            // Verifica si el proyecto está repetido
			insertProy();
			//MODIFICAR ESTO O BORRAR
		} else if(programa.getNombre() == null) {
            // Muestra un mensaje si no se han completado todos los campos en la vista
	        JOptionPane.showMessageDialog(v, "Por favor, rellena todos los campos.");
		} else {
            // Muestra un mensaje si el proyecto ya existe en la base de datos
	        JOptionPane.showMessageDialog(v, "Proyecto ya existente.");
		}
	}
	
	 /**
     * Inserta un nuevo proyecto en la base de datos.
     */
	public void insertProy(){
        // Obtiene los valores de los campos de la vista AddProyect
		String t1 = v.getRes1().getText().trim();
        String t2 = v.getRes2().getText().trim();
        String t4 = v.getRes4().getText().trim();
        String t5 = v.getRes5().getText().trim();
        String t6 = v.getRes6().getText().trim();
        String t7 = v.getRes7().getText().trim();
        String t8 = v.getRes8().getText().trim();
        String t9 = (String) v.getRes9().getSelectedItem();
        
        // Establece los valores en el objeto AccesoBBDD
		programa.setId(t1);
		programa.setNombre(t2);
		programa.setUrlP(t4);
		programa.setNota(t5);
		programa.setFecha(t6);
		programa.setCurso(t7);
		programa.setGrupo(t8);
		if(t9.equals("DAM")) {
			programa.setArea(1);
		} else if (t9.equals("DAW")) {
			programa.setArea(2);
		} else if (t9.equals("ASIR")) {
			programa.setArea(3);
		} else {
			System.out.print("Error");
		}
				
		programa.getConexion();
		boolean resultado = programa.proyectoNuevo();

		if(resultado) {
			AddProyect newProy= new AddProyect();
			ArrayList<Alumno> alumnos = programa.obtenerAlumnos(); //este método NO PUEDE DEVOLVER UN COMBOBOX, 
			//tiene que devolver un arraylist o algo que sea una colección de datos.
			MenuListener Menulist = new MenuListener(newProy);
	        // Muestra mensajes de confirmación o error según el resultado de la inserción del proyecto
	        JOptionPane.showMessageDialog(v, "Proyecto añadido.");
		} else {
	        JOptionPane.showMessageDialog(v, "Error al guardar proyecto.");
		}

	}
}
