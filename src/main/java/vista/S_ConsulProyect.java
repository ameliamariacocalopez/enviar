package vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import control.ConsulBtnListener;
import modelo.ProyectoIntegrador;

/**
 * Ventana para consultar proyectos
 */
public class S_ConsulProyect extends JFrame{
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);	
	private JLabel delTxt;
    
    private JList<String> projectList;
    private ArrayList<ProyectoIntegrador> listaProyectos;
    private DefaultListModel<String> listaNombresProy;    
    private JButton consBtn;
	
	/**
	 * Constructor de la clase ConsulBtnListener.
	 * @param projectList el componente JList que contiene los proyectos.
	 */
	public S_ConsulProyect(ArrayList<ProyectoIntegrador> listaProyectos) {
		super("Consultar Proyecto - ESTUDIANTES");
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
	 * Recorre todos los proyectos y los añade a la lista
	 * @param lista
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