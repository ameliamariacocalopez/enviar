
package vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import control.*;
import modelo.ProyectoIntegrador;

/**
 * Ventana para modificar proyectos
 */
public class ModProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	private JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	private JLabel headingTxt;

    private JList<String> modProjList;
    private ArrayList<ProyectoIntegrador> listaProyectos;
    private DefaultListModel<String> listaNombresProy;
    private JButton modBtn2;
    
	public ModProyect(ArrayList<ProyectoIntegrador> listaProyectos) {
		super("Modificar Proyecto");
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
     	
     	headingTxt = new JLabel("Selecciona el proyecto que quieras modificar");
     	headingTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
     	headingTxt.setBounds(33, 145, 519, 20);
	    getContentPane().add(headingTxt);
	    

	    
		//lista
	    listaNombresProy = new DefaultListModel<String>();
	    
	    modProjList = new JList<String>(listaNombresProy);
        modProjList.setLocation(43, 205);
        modProjList.setSize(563, 171);
	    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
	    
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
		
        //menu listener
        MenuListener menuList = new MenuListener(this);
        setListener(menuList);
		
	    JScrollPane scrollPane = new JScrollPane(modProjList);
	    scrollPane.setBounds(43, 205, 563, 171);
	    getContentPane().add(scrollPane);
		
	    
	    modBtn2 = new JButton("Editar");
	    modBtn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    modBtn2.setBackground(new Color(58, 142, 247));
	    modBtn2.setBounds(239, 396, 63, 20);
	    modBtn2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    modBtnListener escuchador = new modBtnListener(modProjList);
	    modBtn2.addActionListener(escuchador);
	    getContentPane().add(modBtn2);
	    
	    
		setSize(677, 485);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Configura los listeners para los elementos del menú.
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
	
	/**
	 * Muestra los proyectos en la lista.
	 * @param lista La lista de proyectos a mostrar.
	 */
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