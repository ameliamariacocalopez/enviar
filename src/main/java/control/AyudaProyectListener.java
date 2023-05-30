package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AyudaProyect;

/**
 * Clase que implementa el ActionListener para el botón de la ventana de Ayuda.
 */
public class AyudaProyectListener implements ActionListener {
    private AyudaProyect ayudaProyect;

    /**
     * Constructor de la clase AyudaProyectListener.
     * @param ayudaProyect La instancia de AyudaProyect a la que se asocia este listener.
     */
    public AyudaProyectListener(AyudaProyect ayudaProyect) {
        this.ayudaProyect = ayudaProyect;
    }

    /**
     * Método que se invoca cuando se produce un evento de acción.
     * @param e El evento de acción.
     */
    public void actionPerformed(ActionEvent e) {
        ayudaProyect.mostrarRespuestaSeleccionada();
    }
}
