package vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import control.CloseWindowBtnListener;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;


/**
 * Clase que representa la ventana de consulta de proyecto.
 */
public class OpenConsulProy extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	private JLabel tituloLbl;
	private JLabel idLbl;
	private JLabel nombreProyLbl;
	private JLabel urlLbl;
	private JLabel notaLbl;
	private JLabel fechaLbl;
	private JLabel cursoLbl;
	private JLabel areaLbl;
	
    private JLabel idTxtF;
    private JLabel nombreProyTxtF;
    private JLabel urlTxtF;
    private JLabel notaTxtF;
    private JLabel fechaTxtF;
    private JLabel cursoTxtF;
    private JLabel areaTxtF;
    private JButton closeButton;
    String nombreProyecto;
    
    /**
     * Constructor de la clase OpenConsulProy.
     * Crea una nueva instancia de la ventana de consulta de proyecto.
     */
    /**
     * Constructor de la clase OpenConsulProy.
     * Crea una nueva instancia de la ventana de consulta de proyecto.
     */
    public OpenConsulProy() {
    	super("Consultar Proyecto");
    	getContentPane().setBackground(new Color(195, 219, 255));
    	inicializarComponentes();

    	String nombreProyecto = "Nombre del proyecto";
    	
    }


	/**
     * Inicializa los componentes de la ventana.
     */
    public void inicializarComponentes() {
		getContentPane().setLayout(null);

	    JLabel tituloLbl = new JLabel("CONSULTA DE PROYECTO ");
	    tituloLbl.setFont(new Font("Impact", Font.PLAIN, 31));
	    tituloLbl.setBounds(88, 42, 340, 29);
	    getContentPane().add(tituloLbl);
		
		idLbl = new JLabel("ID: ");
		idLbl.setBounds(70, 110, 73, 20);
	    getContentPane().add(idLbl);

		nombreProyLbl = new JLabel("Nombre del Proyecto: ");
		nombreProyLbl.setBounds(70, 140, 141, 20);
	    getContentPane().add(nombreProyLbl);

		urlLbl = new JLabel("URL: ");
		urlLbl.setBounds(70, 170, 73, 20);
	    getContentPane().add(urlLbl);

		notaLbl = new JLabel("Nota: ");
		notaLbl.setBounds(70, 200, 73, 20);
	    getContentPane().add(notaLbl);

		fechaLbl = new JLabel("Fecha: ");
		fechaLbl.setBounds(70, 230, 73, 20);
	    getContentPane().add(fechaLbl);

		cursoLbl = new JLabel("Curso: ");
		cursoLbl.setBounds(70, 260, 73, 20);
	    getContentPane().add(cursoLbl);
	    
		areaLbl = new JLabel("Area: ");
		areaLbl.setBounds(70, 290, 73, 20);
	    getContentPane().add(areaLbl);
	    
		//JLabels - info user
	    idTxtF = new JLabel();
	    idTxtF.setBounds(221, 110, 191, 20);
	    getContentPane().add(idTxtF);

	    nombreProyTxtF = new JLabel();
	    nombreProyTxtF.setBounds(221, 140, 191, 20);
	    getContentPane().add(nombreProyTxtF);

	    urlTxtF = new JLabel();
	    urlTxtF.setBounds(221, 170, 269, 20);
	    getContentPane().add(urlTxtF);

	    notaTxtF = new JLabel();
	    notaTxtF.setBounds(221, 200, 191, 20);
	    getContentPane().add(notaTxtF);

	    fechaTxtF = new JLabel();
	    fechaTxtF.setBounds(221, 230, 191, 20);
	    getContentPane().add(fechaTxtF);

	    cursoTxtF = new JLabel();
	    cursoTxtF.setBounds(221, 260, 191, 20);
	    getContentPane().add(cursoTxtF);
	    
	    areaTxtF = new JLabel();
	    areaTxtF.setBounds(221, 290, 191, 20);
	    getContentPane().add(areaTxtF);

		closeButton = new JButton("Cerrar");
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setSize(107, 29);
		closeButton.setLocation(185, 333);
		CloseWindowBtnListener escuchador = new CloseWindowBtnListener(this, null, null);
		closeButton.addActionListener(escuchador);
	    getContentPane().add(closeButton);
	    


	    setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(514, 418);
    }
    
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Getter para la etiqueta de identificación.
	 *
	 * @return La etiqueta de identificación.
	 */
	public JLabel getIdLbl() {
	    return idLbl;
	}

	/**
	 * Setter para la etiqueta de identificación.
	 *
	 * @param idLbl La nueva etiqueta de identificación.
	 */
	public void setIdLbl(JLabel idLbl) {
	    this.idLbl = idLbl;
	}

	/**
	 * Getter para la etiqueta de nombre del proyecto.
	 *
	 * @return La etiqueta de nombre del proyecto.
	 */
	public JLabel getNombreProyLbl() {
	    return nombreProyLbl;
	}

	/**
	 * Setter para la etiqueta de nombre del proyecto.
	 *
	 * @param nombreProyLbl La nueva etiqueta de nombre del proyecto.
	 */
	public void setNombreProyLbl(JLabel nombreProyLbl) {
	    this.nombreProyLbl = nombreProyLbl;
	}

	/**
	 * Getter para la etiqueta de URL.
	 *
	 * @return La etiqueta de URL.
	 */
	public JLabel getUrlLbl() {
	    return urlLbl;
	}

	/**
	 * Setter para la etiqueta de URL.
	 *
	 * @param urlLbl La nueva etiqueta de URL.
	 */
	public void setUrlLbl(JLabel urlLbl) {
	    this.urlLbl = urlLbl;
	}

	/**
	 * Getter para la etiqueta de nota.
	 *
	 * @return La etiqueta de nota.
	 */
	public JLabel getNotaLbl() {
	    return notaLbl;
	}

	/**
	 * Setter para la etiqueta de nota.
	 *
	 * @param notaLbl La nueva etiqueta de nota.
	 */
	public void setNotaLbl(JLabel notaLbl) {
	    this.notaLbl = notaLbl;
	}

	/**
	 * Getter para la etiqueta de fecha.
	 *
	 * @return La etiqueta de fecha.
	 */
	public JLabel getFechaLbl() {
	    return fechaLbl;
	}

	/**
	 * Setter para la etiqueta de fecha.
	 *
	 * @param fechaLbl La nueva etiqueta de fecha.
	 */
	public void setFechaLbl(JLabel fechaLbl) {
	    this.fechaLbl = fechaLbl;
	}

	/**
	 * Getter para la etiqueta de curso.
	 *
	 * @return La etiqueta de curso.
	 */
	public JLabel getCursoLbl() {
	    return cursoLbl;
	}

	/**
	 * Setter para la etiqueta de curso.
	 *
	 * @param cursoLbl La nueva etiqueta de curso.
	 */
	public void setCursoLbl(JLabel cursoLbl) {
	    this.cursoLbl = cursoLbl;
	}


	/**
	 * Getter para el campo de texto de identificación.
	 *
	 * @return El campo de texto de identificación.
	 */
	public JLabel getIdTxtF() {
	    return idTxtF;
	}

	/**
	 * Setter para el campo de texto de identificación.
	 *
	 * @param idTxtF El nuevo campo de texto de identificación.
	 */
	public void setIdTxtF(JLabel idTxtF) {
	    this.idTxtF = idTxtF;
	}

	/**
	 * Getter para el campo de texto de nombre del proyecto.
	 *
	 * @return El campo de texto de nombre del proyecto.
	 */
	public JLabel getNombreProyTxtF() {
	    return nombreProyTxtF;
	}

	/**
	 * Setter para el campo de texto de nombre del proyecto.
	 *
	 * @param nombreProyTxtF El nuevo campo de texto de nombre del proyecto.
	 */
	public void setNombreProyTxtF(JLabel nombreProyTxtF) {
	    this.nombreProyTxtF = nombreProyTxtF;
	}

	/**
	 * Getter para el campo de texto de URL.
	 *
	 * @return El campo de texto de URL.
	 */
	public JLabel getUrlTxtF() {
	    return urlTxtF;
	}

	/**
	 * Setter para el campo de texto de URL.
	 *
	 * @param urlTxtF El nuevo campo de texto de URL.
	 */
	public void setUrlTxtF(JLabel urlTxtF) {
	    this.urlTxtF = urlTxtF;
	}

	/**
	 * Getter para el campo de texto de nota.
	 *
	 * @return El campo de texto de nota.
	 */
	public JLabel getNotaTxtF() {
	    return notaTxtF;
	}

	/**
	 * Setter para el campo de texto de nota.
	 *
	 * @param notaTxtF El nuevo campo de texto de nota.
	 */
	public void setNotaTxtF(JLabel notaTxtF) {
	    this.notaTxtF = notaTxtF;
	}

	/**
	 * Getter para el campo de texto de fecha.
	 *
	 * @return El campo de texto de fecha.
	 */
	public JLabel getFechaTxtF() {
	    return fechaTxtF;
	}

	/**
	 * Setter para el campo de texto de fecha.
	 *
	 * @param fechaTxtF El nuevo campo de texto de fecha.
	 */
	public void setFechaTxtF(JLabel fechaTxtF) {
	    this.fechaTxtF = fechaTxtF;
	}

	/**
	 * Getter para el campo de texto de curso.
	 *
	 * @return El campo de texto de curso.
	 */
	public JLabel getCursoTxtF() {
	    return cursoTxtF;
	}

	/**
	 * Setter para el campo de texto de curso.
	 *
	 * @param cursoTxtF El nuevo campo de texto de curso.
	 */
	public void setCursoTxtF(JLabel cursoTxtF) {
	    this.cursoTxtF = cursoTxtF;
	}

	
	
	public JLabel getAreaLbl() {
		return areaLbl;
	}


	public void setAreaLbl(JLabel areaLbl) {
		this.areaLbl = areaLbl;
	}


	public JLabel getAreaTxtF() {
		return areaTxtF;
	}


	public void setAreaTxtF(JLabel areaTxtF) {
		this.areaTxtF = areaTxtF;
	}


	/**
	 * Getter para el botón de guardar.
	 *
	 * @return El botón de guardar.
	 */
	public JButton getSaveButton() {
	    return closeButton;
	}

	/**
	 * Setter para el botón de guardar.
	 *
	 * @param saveButton El nuevo botón de guardar.
	 */
	public void setSaveButton(JButton saveButton) {
	    this.closeButton = saveButton;
	}
}