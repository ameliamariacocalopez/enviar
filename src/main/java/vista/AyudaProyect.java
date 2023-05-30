package vista;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import control.AyudaProyectListener;
import control.MenuListener;

/**
 * Clase que representa la ventana de Ayuda del proyecto.
 */
public class AyudaProyect extends JFrame {
	// Crea una instancia de la clase ImageIcon a partir de la imagen "img/pacTrans.png"
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	// Crea una etiqueta JLabel y la inicializa con la imagen creada
	JLabel imgLbl = new JLabel(pacImg);	
    private JList<String> listaProy2;
    private JButton openBtn;

    /**
     * Constructor de la clase AyudaProyect. Inicializa los componentes y configura la apariencia de la ventana.
     */
	public AyudaProyect() {
		super("Ayuda");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes y los añade al content pane
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		//objetos
        imgLbl.setSize(304, 118);
     	imgLbl.setLocation(156, 14);
     	getContentPane().add(imgLbl); 
     	
     	//lista
     	// Crea un modelo de lista predeterminado y agrega elementos de pregunta al
 		// modelo
 		DefaultListModel<String> preguntasList = new DefaultListModel<String>();
 		preguntasList.addElement("¿Cómo cambio mi contraseña?");
 		preguntasList.addElement("¿Cómo borro mi cuenta?");
 		preguntasList.addElement("¿Qué beneficios tiene esta aplicación?");
 		preguntasList.addElement("¿Por qué no puedo acceder a mi cuenta?");
 		preguntasList.addElement("¿Cómo consigo mi número de expediente?");
 		preguntasList.addElement("¿Cuál es mi username cómo administrador?");
 		preguntasList.addElement("¿Cómo se añade un proyecto nuevo?");
 		preguntasList.addElement("¿Cómo se edita un proyecto?");
 		preguntasList.addElement("¿Cómo elimino un proyecto?");
 		preguntasList.addElement("¿Cómo añado un alumno?");

 		listaProy2 = new JList<String>();
		listaProy2.setModel(preguntasList);
		listaProy2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProy2.setLocation(43, 205);
        listaProy2.setSize(560, 171);
		Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
		listaProy2.setBorder(buttonBorder);

		// Crea un objeto de desplazamiento JScrollPane y lo configura con la lista de preguntas
		JScrollPane scrollPane = new JScrollPane(listaProy2);
		scrollPane.setBounds(45, 215, 563, 171);
		getContentPane().add(scrollPane);
     	
	    openBtn = new JButton("Abrir");
	    openBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    openBtn.setBackground(new Color(58, 142, 247));
	    openBtn.setBounds(276, 398, 110, 20);
	    openBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    getContentPane().add(openBtn);
		
	    //Creamos un objeto y lo asigna al botón "openBtn"
 		AyudaProyectListener l = new AyudaProyectListener(this);
 		openBtn.addActionListener(l);
	    
		setSize(677, 485);
		setLocationRelativeTo(null);
		hacerVisible();
	}
	
	/**
	 * Muestra la respuesta seleccionada en un JOptionPane.showMessageDialog.
	 */
	public void mostrarRespuestaSeleccionada() {
		int selectedIndex = listaProy2.getSelectedIndex();
		String a = listaProy2.getSelectedValue();

		if (selectedIndex > -1) {
			String preguntaSeleccionada = listaProy2.getModel().getElementAt(selectedIndex);
			String respuesta = obtenerRespuesta(preguntaSeleccionada);//
			// Muestra un cuadro de diálogo con la respuesta seleccionada
			JOptionPane.showMessageDialog(this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.out.println("Conexión conseguida oficial");
			JOptionPane.showMessageDialog(this, "Seleccione una pregunta primero", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Obtiene la respuesta correspondiente a una pregunta.
	 * @param pregunta La pregunta seleccionada.
	 * @return La respuesta correspondiente a la pregunta.
	 */
	public static String obtenerRespuesta(String pregunta) {
		if (pregunta.equals("¿Cómo cambio mi contraseña?")) {
			return "Puedes cambiar tu contraseña desde la configuración de tu cuenta.";
		} else if (pregunta.equals("¿Cómo borro mi cuenta?")) {
			return "Para borrar tu cuenta, contacta al servicio de soporte.";
		} else if (pregunta.equals("¿Qué beneficios tiene esta aplicación?")) {
			return "Esta aplicación te permite gestionar proyectos de manera eficiente y colaborativa.";
		} else if (pregunta.equals("¿Por qué no puedo acceder a mi cuenta?")) {
			return "Puede haber varias razones, verifica tu nombre de usuario y contraseña.";
		} else if (pregunta.equals("¿Cómo consigo mi número de expediente?")) {
			return "Puedes obtener tu número de expediente solicitándolo en la oficina administrativa.";
		} else if (pregunta.equals("¿Cuál es mi username cómo administrador?")) {
			return "Tu username de administrador es 'admin'.";
		} else if (pregunta.equals("¿Cómo se añade un proyecto nuevo?")) {
			return "Para añadir un proyecto nuevo, ve a la sección 'Proyectos' y haz clic en 'Crear proyecto'.";
		} else if (pregunta.equals("¿Cómo se edita un proyecto?")) {
			return "Para editar un proyecto, selecciona el proyecto en la lista y haz clic en 'Editar proyecto'.";
		} else if (pregunta.equals("¿Cómo elimino un proyecto?")) {
			return "Para eliminar un proyecto, selecciona el proyecto en la lista y haz clic en 'Eliminar proyecto'.";
		} else if (pregunta.equals("¿Cómo añado un alumno?")) {
			return "Para añadir un alumno, ve a la sección 'Alumnos' y haz clic en 'Añadir alumno'.";
		} else {
			return "No se encontró una respuesta para la pregunta seleccionada.";
		}
	}
	
	public Object getOpenBtn() {
		//creado para testear
		return null;
	}

	public Object getListaProy2() {
		// creado para testear
		return null;
	}

}
