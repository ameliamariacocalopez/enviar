package com.daw.proyectoIntegradoor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import control.MenuListener;
import vista.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ProyectoIntegradorTest {

	private AyudaProyect ayudaProyect;
    private AreasProyect areasProyect;
    private AddProyect addProyect;
	private S_ConsulProyect consulProyect;

	// Antes de ejecutar cualquier método de prueba en la clase, se ejecuta este método.
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	// Después de ejecutar todos los métodos de prueba en la clase, se ejecuta este método.
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// Antes de ejecutar cada método de prueba, se ejecuta este método.
	@Before
	public void setUp() throws Exception {
		// Se crean las instancias de las clases necesarias para realizar las pruebas.
		ayudaProyect = new AyudaProyect();
        areasProyect = new AreasProyect();
        addProyect = new AddProyect();
//		consulProyect = new S_ConsulProyect();
	}

	// Después de ejecutar cada método de prueba, se ejecuta este método.
	@After
	public void tearDown() throws Exception {
	}

	// Método de prueba para probar el método "obtenerRespuesta" de la clase AyudaProyect.
	@Test
	public void testObtenerRespuesta() {
		// Prueba para una pregunta existente
		String respuesta = ayudaProyect.obtenerRespuesta("¿Cómo cambio mi contraseña?");
		assertEquals("Puedes cambiar tu contraseña desde la configuración de tu cuenta.", respuesta);

		// Prueba para una pregunta inexistente
		respuesta = AyudaProyect.obtenerRespuesta("¿Esta pregunta no existe?");
		assertEquals("No se encontró una respuesta para la pregunta seleccionada.", respuesta);
		System.out.println("test obtener respuesta check");
        return;
	}

    // Método de prueba para probar el método "setListener" de la clase AreasProyect.
    @Test
    public void testSetListener() {
        MenuListener listener = new MenuListener(areasProyect);
        areasProyect.setListener(listener);
		System.out.println("test SetListener check");
		return;
    }
    
    // Método de prueba para probar el método "getConsulItem" de la clase AreasProyect.
    @Test
    public void testGetConsulItem() {
        AreasProyect areasProyect = new AreasProyect();
        Object consulItem = areasProyect.getConsulItem();
        assertNull(consulItem);
		System.out.println("test GetConsultItem check");
    }
    
    // Método de prueba para probar el método "getAddItem" de la clase AreasProyect.
    @Test
    public void testGetAddItem() {
        AreasProyect areasProyect = new AreasProyect();
        Object addItem = areasProyect.getAddItem();
        assertNull(addItem);
		System.out.println("test GetAddItem check");
    }

	// Método de prueba para probar el método "hacerVisible" de la clase S_ConsulProyect.
	@Test
	public void testHacerVisible() {
		consulProyect.hacerVisible();
		assertTrue(consulProyect.isVisible());
		System.out.println("test HacerVisible check");
	}

	@Test
	public void testProyectoIntegrador() {
		fail("Not yet implemented");
	}
}
