package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import control.ConsulBtnListener;
import vista.*;

public class Main extends JFrame{
	private VentanaPrincipal cover;
	private JLayeredPane bg;
	
	public Main() {
//		inicializarComponentes();
		init();
	}
	
	private void init() {
		cover = new VentanaPrincipal();
		bg.add(cover);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				VentanaPrincipal ventana = new VentanaPrincipal();
				
//				ConsulProyect ventana = new ConsulProyect();
		        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana.setVisible(true);
			}
		});


	}
}
