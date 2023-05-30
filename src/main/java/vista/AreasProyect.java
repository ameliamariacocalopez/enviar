package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import control.MenuListener;

/**
 * Clase que representa la interfaz gráfica de las áreas del proyecto.
 */
public class AreasProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
//    AreasProyect areasProy = new AreasProyect();
	private JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	
    private JLabel dawLbl;
    private JLabel dawText;
    private JLabel damLbl;
    private JLabel damText;
    private JLabel asirLbl;
    private JLabel asirText;
	
    /**
     * Constructor de la clase AreasProyect.
     */
	public AreasProyect() {
		super("Áreas");
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
     	
     	dawLbl = new JLabel("DAW:");
     	dawLbl.setBounds(70, 148, 63, 20);
	    getContentPane().add(dawLbl);
	    
	    //he usado html para poder ajustar el texto al tamaño del JLabel
	    dawText = new JLabel("<html><body style='width: 118px;'>Los estudiantes de Diseño y Desarrollo de Aplicaciones Web aprenden lenguajes de programación web, bases de datos y diseño de interfaces. Se enfoca en la experiencia del usuario y la creación de interfaces intuitivas y atractivas.</body></html>");
	    dawText.setVerticalAlignment(SwingConstants.TOP);
	    dawText.setBounds(70, 190, 147, 200);
	    getContentPane().add(dawText);
	    
	    damLbl = new JLabel("DAM");
	    damLbl.setBounds(262, 148, 63, 20);
	    getContentPane().add(damLbl);
	    
	    damText = new JLabel("<html><body style='width: 118px;'>Los estudiantes de Desarrollo de Aplicaciones Multiplataforma se enfocan en el estudio y desarrollo de aplicaciones para diferentes plataformas y dispositivos. Estudian lenguajes como Java, C#, Swift.</body></html>");
	    damText.setVerticalAlignment(SwingConstants.TOP);
	    damText.setPreferredSize(new Dimension(147, 200));
	    damText.setBounds(262, 190, 147, 200);
	    getContentPane().add(damText);
	    
	    asirLbl = new JLabel("ASIR:");
	    asirLbl.setBounds(450, 148, 63, 20);
	    getContentPane().add(asirLbl);
	    
	    asirText = new JLabel("<html><body style='width: 118px;'>Los estudiantes de Administración de Sistemas Informáticos en Red adquieren conocimientos en áreas como sistemas operativos, redes de computadoras, seguridad informática y servicios de infraestructura.</body></html>");
	    asirText.setVerticalAlignment(SwingConstants.TOP);
	    asirText.setPreferredSize(new Dimension(147, 200));
	    asirText.setBounds(450, 190, 147, 200);
	    getContentPane().add(asirText);
	    
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
        
	    //listener
        MenuListener menuList = new MenuListener(this);
        setListener(menuList);
		
		setSize(677, 485);
		setLocationRelativeTo(null);
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
	
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
     * Método getter para el elemento consulItem (creado solo para testing).
     * @return El elemento consulItem.
     */
    public Object getConsulItem() {
        return null;
    }

    /**
     * Método getter para el elemento addItem (creado solo para testing).
     * @return El elemento addItem.
     */
    public Object getAddItem() {
        return null;
    }

}
