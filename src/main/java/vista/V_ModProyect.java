package vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import control.CloseWindowBtnListener;
import control.saveProyBtnListener;
import java.awt.Font;

/**
 * Ventana de inicio de sesión para administradores y estudiantes
 */
public class V_ModProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	
	private JLabel tituloLbl, idLbl, urlLbl, notaLbl, fechaLbl, cursoLbl, grupoLbl;
	
	JButton saveButton;
	private JLabel nombreProyLbl;
	private JTextField idTxtF;
	private JTextField nombreProyTxtF;
	private JTextField urlTxtF;
	private JTextField notaTxtF;
	private JTextField fechaTxtF;
	private JTextField cursoTxtF;
	private JTextField grupoTxtF;
	
	/**
     * CONSTRUCTOR
     */
	public V_ModProyect() {
		super("Modificar Proyecto - Edit");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes y los añade al content pane
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		tituloLbl = new JLabel("MODIFICA EL PROYECTO ");
		tituloLbl.setFont(new Font("Impact", Font.PLAIN, 31));
		tituloLbl.setBounds(86, 22, 326, 29);
	    getContentPane().add(tituloLbl);
		
		idLbl = new JLabel("ID: ");
		idLbl.setBounds(60, 74, 73, 20);
	    getContentPane().add(idLbl);

		urlLbl = new JLabel("URL: ");
		urlLbl.setBounds(60, 139, 73, 20);
	    getContentPane().add(urlLbl);

		notaLbl = new JLabel("Nota: ");
		notaLbl.setBounds(60, 169, 73, 20);
	    getContentPane().add(notaLbl);

		fechaLbl = new JLabel("Fecha: ");
		fechaLbl.setBounds(60, 199, 73, 20);
	    getContentPane().add(fechaLbl);

		cursoLbl = new JLabel("Curso: ");
		cursoLbl.setBounds(60, 230, 73, 20);
	    getContentPane().add(cursoLbl);

		grupoLbl = new JLabel("Grupo: ");
		grupoLbl.setBounds(60, 260, 73, 20);
	    getContentPane().add(grupoLbl);
		
		idTxtF = new JTextField();
		idTxtF.setBounds(209, 75, 203, 20);
	    getContentPane().add(idTxtF);

		nombreProyTxtF = new JTextField();
		nombreProyTxtF.setBounds(209, 110, 203, 20);
	    getContentPane().add(nombreProyTxtF);

		urlTxtF = new JTextField();
		urlTxtF.setBounds(209, 140, 203, 20);
	    getContentPane().add(urlTxtF);

		notaTxtF = new JTextField();
		notaTxtF.setBounds(209, 170, 203, 20);
	    getContentPane().add(notaTxtF);

		fechaTxtF = new JTextField();
		fechaTxtF.setBounds(209, 200, 203, 20);
	    getContentPane().add(fechaTxtF);

		cursoTxtF = new JTextField();
		cursoTxtF.setBounds(209, 231, 203, 20);
	    getContentPane().add(cursoTxtF);
//REVISAR PORQUE NO SALE EL GRUPO
		grupoTxtF = new JTextField();
		grupoTxtF.setBounds(209, 261, 203, 20);
	    getContentPane().add(grupoTxtF);
	    
		saveButton = new JButton("Guardar cambios");
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setBounds(221, 306, 148, 29);
//		saveButton.setLocation(221, 570);
		
		//listeners
		saveProyBtnListener escuchador1 = new saveProyBtnListener();
		saveButton.addActionListener(escuchador1);	    
		CloseWindowBtnListener escuchador = new CloseWindowBtnListener(null, this, null);
		saveButton.addActionListener(escuchador);	    
		getContentPane().add(saveButton);
		
		JButton closeButton = new JButton("Cerrar");
		closeButton.setBounds(86, 306, 107, 29);
		getContentPane().add(closeButton);
		

		
		nombreProyLbl = new JLabel("Nombre del Proyecto: ");
		nombreProyLbl.setBounds(60, 109, 133, 20);
		getContentPane().add(nombreProyLbl);
	    
	    setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(471, 381);
	}
	public JTextField getIdTxtF() {
		return idTxtF;
	}

	public JTextField getNombreProyTxtF() {
		return nombreProyTxtF;
	}

	public JTextField getUrlTxtF() {
		return urlTxtF;
	}

	public JTextField getNotaTxtF() {
		return notaTxtF;
	}

	public JTextField getFechaTxtF() {
		return fechaTxtF;
	}

	public JTextField getCursoTxtF() {
		return cursoTxtF;
	}

	public JTextField getGrupoTxtF() {
		return grupoTxtF;
	}

	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
}
