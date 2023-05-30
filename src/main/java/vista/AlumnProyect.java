package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import control.AddStdntBtnListener;
import control.ConsulBtnListener;
import control.MenuListener;
import modelo.Alumno;
import modelo.ProyectoIntegrador;
import control.EditStdntBtnListener;

/**
 * Clase que representa la interfaz gráfica de la aplicación de gestión de
 * alumnos.
 */
public class AlumnProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);	
	private JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	
	private JList<String> alumnList;
    private ArrayList<Alumno> listaAlumnos;
    private DefaultListModel<String> listaAlumn;
	private JButton editAlumn;

	/**
	 * Constructor de la clase AlumnProyect.
	 */
    public AlumnProyect() {
		super("Alumnos");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes de la interfaz gráfica.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		alumnosM = new JMenuItem("Alumnos");
		
		//objetos
        imgLbl.setSize(304, 118);
     	imgLbl.setLocation(150, 30);
     	getContentPane().add(imgLbl);
     		    

	    //menu
  		menu = new JMenuBar();
        areasM = new JMenuItem("Áreas");
        alumnosM = new JMenuItem("Alumnos");
        JMenu proyectoM = new JMenu("Proyecto Integrador");
        consulItem = new JMenuItem("Consultas");
        addItem = new JMenuItem("Añadir Proyecto");
        delItem = new JMenuItem("Borrar Proyecto");
        modItem = new JMenuItem("Modificar Proyecto");
        proyectoM.add(consulItem);
        proyectoM.add(addItem);
        proyectoM.add(delItem);
        proyectoM.add(modItem);
        menu.add(proyectoM);
        menu.add(areasM);
        menu.add(alumnosM);
        setJMenuBar(menu);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        listaAlumn = new DefaultListModel();
	    
        //menu listener
        MenuListener menuList = new MenuListener(this);
        setListener(menuList);
        
	    //lista
        alumnList = new JList<>(listaAlumn);
	    alumnList.setLocation(43, 205);
	    alumnList.setSize(563, 260);
	    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
        
	    JScrollPane scrollPane = new JScrollPane(alumnList);
	    scrollPane.setBounds(40, 144, 563, 232);
	    getContentPane().add(scrollPane);
	    
	    editAlumn = new JButton("Editar");
	    editAlumn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    editAlumn.setSize(107, 29);
     	editAlumn.setBounds(284, 386, 87, 20);
     	AddStdntBtnListener escuchador = new AddStdntBtnListener();
	    editAlumn.addActionListener(escuchador);
	    getContentPane().add(editAlumn);
	    
	    
		setSize(677, 485);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    /**
     * Establece el listener para los elementos del menú.
     * @param listener El objeto MenuListener que manejará los eventos del menú.
     */
	public void setListener(MenuListener listener) {
		consulItem.addActionListener(listener);
		addItem.addActionListener(listener);
		delItem.addActionListener(listener);
		modItem.addActionListener(listener);
		areasM.addActionListener(listener);
		alumnosM.addActionListener(listener);
	}
	public void cargarAlumnos(ArrayList<Alumno> lista) {
	    // Obtener la lista de alumnos desde la base de datos utilizando AccesoBBDD
	    // Agregar los nombres de los alumnos a la lista de la JList
	    for (Alumno a : lista) {
	        listaAlumn.addElement(a.toString());
	    }
	    alumnList.setModel(listaAlumn); // Establecer el modelo de la JList con la lista de nombres de los alumnos
	}
	
	//setear lista del objeto de la BBDD y luego asignar al ScrollPane.
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Hace toda la página visible
	 */
	public void desactivar() {
		setVisible(false);
	}
}