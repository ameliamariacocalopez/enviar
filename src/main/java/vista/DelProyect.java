package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.*;
import javax.swing.border.*;

import control.DelProyBtnListener;
import control.MenuListener;
import modelo.ProyectoIntegrador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Ventana para borrar proyectos
 */
public class DelProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	private JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	
	private JLabel delTxt;
    private JLabel filterTxt;
    private JTextField filterTxtF;
    private JList<String> projectList;
    private ArrayList<ProyectoIntegrador> listaProyectos;
    private DefaultListModel<String> listaProy;
    private JButton delBtn;
	
	public DelProyect() {
		super("Borrar Proyecto");
		listaProyectos = new ArrayList<ProyectoIntegrador>();
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
				
        delTxt = new JLabel("Selecciona el proyecto que quieras eliminar");
        delTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        delTxt.setBounds(33, 145, 413, 20);
	    getContentPane().add(delTxt);
	    
	    delBtn = new JButton("Eliminar");
	    delBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    delBtn.setBackground(new Color(58, 142, 247));
	    delBtn.setBounds(261, 396, 117, 20);
	    delBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));    
        getContentPane().add(delBtn);
	    
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
		listaProy = new DefaultListModel();
      
	    //listener
        MenuListener menuList = new MenuListener(this);
        setListener(menuList);
		
	    //lista
        projectList = new JList<>(listaProy);
        projectList.setLocation(43, 205);
        projectList.setSize(563, 171);
	    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
	    
	    JScrollPane scrollPane = new JScrollPane(projectList);
	    scrollPane.setBounds(43, 205, 563, 171);
	    getContentPane().add(scrollPane);
	    
	    DelProyBtnListener delListenerButton = new DelProyBtnListener(projectList);
        delBtn.addActionListener(delListenerButton);
        
		setSize(677, 485);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Establece el listener en los elementos de menú
	 * @param listener El listener del menú
	 */
	public void setListener(MenuListener listener) {
		consulItem.addActionListener(listener);
		addItem.addActionListener(listener);
		delItem.addActionListener(listener);
		modItem.addActionListener(listener);
		areasM.addActionListener(listener);
		alumnosM.addActionListener(listener);
	}
	
	/**
	 * Muestra los proyectos en la lista
	 * @param lista La lista de proyectos a mostrar
	 */
	public void showProys(ArrayList<ProyectoIntegrador> lista) {
		for(ProyectoIntegrador p : lista) {
			listaProy.addElement(p.toString());
			System.out.println(p.getNombreProyecto());
	    }
	}
	
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Desactiva la ventana
	 */
	public void desactivar() {
		setVisible(false);
	}
}