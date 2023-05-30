package vista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

import control.AyudaBtnListener;
import control.LoginBtnListener;
import modelo.AccesoBBDD;

import java.awt.*;

/**
 * Ventana de inicio de sesión para administradores y estudiantes.
 */
public class VentanaPrincipal extends JFrame implements IVentana {

    //Creo todos los objetos que voy a utilizar
    ImageIcon pacImg = new ImageIcon("img/aa.png");
    JLabel imgLbl = new JLabel(pacImg);

    JMenuBar menu;
    JLabel studentLbl;
    JLabel adminLbl;
    JLabel studOpt;
    JTextField studResp;

    JLabel adminOpt1;
    JLabel adminOpt2;
    JTextField adminRes1;
    JPasswordField adminRes3;

    JButton loginBtn;
    JButton ayudaBtn;

    /**
     * CONSTRUCTOR
     */
    public VentanaPrincipal() {
        super("Login");
        getContentPane().setForeground(new Color(0, 0, 0));
        getContentPane().setBackground(new Color(195, 219, 255));
        inicializarComponentes();
    }

    /**
     * Inicializa los componentes y los añade al content pane.
     */
    @Override
    public void inicializarComponentes() {
        getContentPane().setLayout(null);

        //componentes
        imgLbl.setSize(304, 118);
        imgLbl.setLocation(156, 14);
        getContentPane().add(imgLbl);

        studentLbl = new JLabel("ESTUDIANTE");
        studentLbl.setForeground(new Color(70, 149, 216));
        studentLbl.setBounds(98, 166, 100, 20);
        getContentPane().add(studentLbl);

        adminLbl = new JLabel("ADMINISTRADOR");
        adminLbl.setForeground(new Color(91, 148, 226));
        adminLbl.setBounds(366, 166, 110, 20);
        getContentPane().add(adminLbl);

        //student login
        studOpt = new JLabel("Núm de expediente");
        studOpt.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        studOpt.setBounds(119, 225, 132, 20);
        getContentPane().add(studOpt);

        studResp = new JTextField();
        studResp.setBounds(119, 257, 100, 20);
        getContentPane().add(studResp);

        //admin log in
        adminOpt1 = new JLabel("Username");
        adminOpt1.setHorizontalAlignment(SwingConstants.RIGHT);
        adminOpt1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        adminOpt1.setBounds(376, 210, 81, 20);
        getContentPane().add(adminOpt1);

        adminRes1 = new JTextField();
        adminRes1.setBounds(401, 235, 100, 20);
        getContentPane().add(adminRes1);

        adminOpt2 = new JLabel("Contraseña");
        adminOpt2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        adminOpt2.setHorizontalAlignment(SwingConstants.RIGHT);
        adminOpt2.setBounds(376, 270, 91, 20);
        getContentPane().add(adminOpt2);

        adminRes3 = new JPasswordField();
        adminRes3.setBounds(401, 293, 100, 20);
        getContentPane().add(adminRes3);

        //login button
        loginBtn = new JButton("Log In");
        loginBtn.setForeground(new Color(100, 100, 100));
        loginBtn.setBackground(new Color(242, 255, 248));
        loginBtn.setBounds(283, 374, 72, 20);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LoginBtnListener escuchador = new LoginBtnListener(this);
        loginBtn.addActionListener(escuchador);
        getContentPane().add(loginBtn);

        //help button
        ayudaBtn = new JButton("Ayuda");
        ayudaBtn.setBounds(563, 407, 81, 29);
        ayudaBtn.setForeground(new Color(100, 100, 100));
        Border buttonBorder2 = BorderFactory.createLineBorder(Color.BLACK);
        loginBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        ayudaBtn.setContentAreaFilled(false);
        ayudaBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(ayudaBtn);
        ayudaBtn.addActionListener(new AyudaBtnListener());

        setSize(677, 485);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Hace todo visible.
     */
    @Override
    public void hacerVisible() {
        setVisible(true);
    }

    /**
     * GETTERS Y SETTERS
     */

    /**
     * Obtiene la imagen del paquete.
     *
     * @return la imagen del paquete.
     */
    public ImageIcon getPacImg() {
        return pacImg;
    }

    /**
     * Establece la imagen del paquete.
     *
     * @param pacImg la imagen del paquete a establecer.
     */
    public void setPacImg(ImageIcon pacImg) {
        this.pacImg = pacImg;
    }

    /**
     * Obtiene la etiqueta de imagen.
     *
     * @return la etiqueta de imagen.
     */
    public JLabel getImgLbl() {
        return imgLbl;
    }

    /**
     * Establece la etiqueta de imagen.
     *
     * @param imgLbl la etiqueta de imagen a establecer.
     */
    public void setImgLbl(JLabel imgLbl) {
        this.imgLbl = imgLbl;
    }

    /**
     * Obtiene el menú.
     *
     * @return el menú.
     */
    public JMenuBar getMenu() {
        return menu;
    }

    /**
     * Establece el menú.
     *
     * @param menu el menú a establecer.
     */
    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    /**
     * Obtiene la etiqueta de estudiante.
     *
     * @return la etiqueta de estudiante.
     */
    public JLabel getStudentLbl() {
        return studentLbl;
    }

    /**
     * Establece la etiqueta de estudiante.
     *
     * @param studentLbl la etiqueta de estudiante a establecer.
     */
    public void setStudentLbl(JLabel studentLbl) {
        this.studentLbl = studentLbl;
    }

    /**
     * Obtiene la etiqueta de administrador.
     *
     * @return la etiqueta de administrador.
     */
    public JLabel getAdminLbl() {
        return adminLbl;
    }

    /**
     * Establece la etiqueta de administrador.
     *
     * @param adminLbl la etiqueta de administrador a establecer.
     */
    public void setAdminLbl(JLabel adminLbl) {
        this.adminLbl = adminLbl;
    }

    /**
     * Obtiene la etiqueta de opción de estudiante.
     *
     * @return la etiqueta de opción de estudiante.
     */
    public JLabel getStudOpt() {
        return studOpt;
    }

    /**
     * Establece la etiqueta de opción de estudiante.
     *
     * @param studOpt la etiqueta de opción de estudiante a establecer.
     */
    public void setStudOpt(JLabel studOpt) {
        this.studOpt = studOpt;
    }

    /**
     * Obtiene el campo de texto de respuesta de estudiante.
     *
     * @return el campo de texto de respuesta de estudiante.
     */
    public JTextField getStudResp() {
        return studResp;
    }

    /**
     * Establece el campo de texto de respuesta de estudiante.
     *
     * @param studResp el campo de texto de respuesta de estudiante a establecer.
     */
    public void setStudResp(JTextField studResp) {
        this.studResp = studResp;
    }

    /**
     * Obtiene la etiqueta de opción de administrador.
     *
     * @return la etiqueta de opción de administrador.
     */
    public JLabel getAdminOpt1() {
        return adminOpt1;
    }

    /**
     * Establece la etiqueta de opción de administrador.
     *
     * @param adminOpt1 la etiqueta de opción de administrador a establecer.
     */
    public void setAdminOpt1(JLabel adminOpt1) {
        this.adminOpt1 = adminOpt1;
    }

    /**
     * Obtiene la etiqueta de opción de administrador 2.
     *
     * @return la etiqueta de opción de administrador 2.
     */
    public JLabel getAdminOpt2() {
        return adminOpt2;
    }

    /**
     * Establece la etiqueta de opción de administrador 2.
     *
     * @param adminOpt2 la etiqueta de opción de administrador 2 a establecer.
     */
    public void setAdminOpt2(JLabel adminOpt2) {
        this.adminOpt2 = adminOpt2;
    }

    /**
     * Obtiene el campo de texto de respuesta de administrador 1.
     *
     * @return el campo de texto de respuesta de administrador 1.
     */
    public JTextField getAdminRes1() {
        return adminRes1;
    }

    /**
     * Establece el campo de texto de respuesta de administrador 1.
     *
     * @param adminRes1 el campo de texto de respuesta de administrador 1 a establecer.
     */
    public void setAdminRes1(JTextField adminRes1) {
        this.adminRes1 = adminRes1;
    }

    /**
     * Obtiene el campo de contraseña de respuesta de administrador 3.
     *
     * @return el campo de contraseña de respuesta de administrador 3.
     */
    public JPasswordField getAdminRes3() {
        return adminRes3;
    }

    /**
     * Establece el campo de contraseña de respuesta de administrador 3.
     *
     * @param adminRes3 el campo de contraseña de respuesta de administrador 3 a establecer.
     */
    public void setAdminRes3(JPasswordField adminRes3) {
        this.adminRes3 = adminRes3;
    }

    /**
     * Obtiene el botón de inicio de sesión.
     *
     * @return el botón de inicio de sesión.
     */
    public JButton getLoginBtn() {
        return loginBtn;
    }

    /**
     * Establece el botón de inicio de sesión.
     *
     * @param loginBtn el botón de inicio de sesión a establecer.
     */
    public void setLoginBtn(JButton loginBtn) {
        this.loginBtn = loginBtn;
    }

    /**
     * Obtiene el botón de ayuda.
     *
     * @return el botón de ayuda.
     */
    public JButton getAyudaBtn() {
        return ayudaBtn;
    }

    /**
     * Establece el botón de ayuda.
     *
     * @param ayudaBtn el botón de ayuda a establecer.
     */
    public void setAyudaBtn(JButton ayudaBtn) {
        this.ayudaBtn = ayudaBtn;
    }
}
