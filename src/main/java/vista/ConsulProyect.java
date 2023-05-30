package vista;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import control.*;
import modelo.*;

/**
 * Ventana para consultar proyectos
 */
public class ConsulProyect extends JFrame {
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
    
    private JList<String> projectList;
    private ArrayList<ProyectoIntegrador> listaProyectos;
    private DefaultListModel<String> listaNombresProy;
    private JButton consBtn;
    
	/**
	 * Constructor de la clase ConsulBtnListener.
	 * @param listaProyectos el componente JList que contiene los proyectos.
	 */
    public ConsulProyect(ArrayList<ProyectoIntegrador> listaProyectos) {
        super("Consultar Proyecto");
        this.listaProyectos = listaProyectos;
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
                
        delTxt = new JLabel("Selecciona el proyecto que quieras consultar");
        delTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        delTxt.setBounds(33, 145, 413, 20);
        getContentPane().add(delTxt);
        
        
        //lista
        listaNombresProy = new DefaultListModel<String>();

        projectList = new JList<String>(listaNombresProy);
        projectList.setLocation(43, 205);
        projectList.setSize(563, 171);
        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
        
        JScrollPane scrollPane = new JScrollPane(projectList);
        scrollPane.setBounds(43, 205, 563, 171);
        getContentPane().add(scrollPane);
        
        // Menu
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
        
        //menu listener
        MenuListener menuList = new MenuListener(this);
        setListener(menuList);
        
        consBtn = new JButton("Consultar");
        consBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        consBtn.setBackground(new Color(58, 142, 247));
        consBtn.setBounds(275, 397, 92, 20);
        consBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        ConsulBtnListener escuchador = new ConsulBtnListener(projectList);
        consBtn.addActionListener(escuchador);
        getContentPane().add(consBtn);
        
        setSize(677, 485);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Configura los listeners para los elementos del menú.
     * 
     * @param listener El objeto que escucha los eventos del menú.
     */
    public void setListener(MenuListener listener) {
        consulItem.addActionListener(listener);
        addItem.addActionListener(listener);
        delItem.addActionListener(listener);
        modItem.addActionListener(listener);
        areasM.addActionListener(listener);
        alumnosM.addActionListener(listener);
    }
    
    public void showProys(ArrayList<ProyectoIntegrador> lista) {
        for(ProyectoIntegrador p : lista) {
            listaNombresProy.addElement(p.toString());
        }
    }
    
    /**
     * Hace toda la página visible
     */
    public void hacerVisible() {
        setVisible(true);
    }
    
    /**
     * Hides window
     */
    public void desactivar() {
        setVisible(false);
    }
    
    public void setListaProyectos(ArrayList<ProyectoIntegrador> p) {
    	listaProyectos = p;
    }

}