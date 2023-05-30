package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vista.AyudaProyect;
import vista.VentanaPrincipal;

/**
 * Clase que implementa la interfaz ActionListener para el botón de Ayuda.
 * Abre la ventana de AyudaProyect al hacer clic en el botón.
 */
public class AyudaBtnListener implements ActionListener {

	/**
     * Método que se ejecuta al hacer clic en el botón de Ayuda.
     * Abre la ventana de AyudaProyect.
     * @param e El evento de acción generado por el botón de Ayuda.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
        AyudaProyect ayudaProy = new AyudaProyect();
        ayudaProy.hacerVisible();
   }
	
}