package modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class AccesoBBDD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/ProyectoIntegrador";
	private String user = "root";
	private String pwd = "rootroot";

	//s_consulProyect y consulProyect.java
	private String userAlumno, usrname, resultado;
	private String password = "";
	private boolean check;
	int r;
	
	//addProyect.java
	private String id, nombre, urlP, nota, fecha, curso, grupo;
	private int area;
	

	Connection conexion = null;

	/**
     * Obtiene una conexión a la base de datos.
     * @return La conexión establecida.
     */
	public Connection getConexion() {
		conexion = null;

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pwd);
			System.out.println("Conexión conseguida");
		} catch (SQLException a) {
			System.out.println("Error!");
		} catch (Exception e) {
			System.out.println("Error!");
		}
		return conexion;
	}

	/**
     * Comprueba si existe un usuario con el nombre especificado en la base de datos.
     * @return true si el nombre existe, false en caso contrario.
     */	public boolean comprobarNombre() {
		check = false;

		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM administrado WHERE username='" + usrname.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);
			if (resultados.next()) {
				check = true;

			} else {
				check = false;

			}
		} catch (SQLException a) {

		} catch (Exception e) {

		}
		return check;
	}

	/**
     * Registra un nuevo usuario en la base de datos.
     */
	public void register() {
		try {
			conexion = DriverManager.getConnection(url, user, pwd);
			String query = "INSERT INTO administrado VALUES('" + usrname.trim() + "','" + password.trim() + "')";
			Statement statement = conexion.createStatement();
			r = statement.executeUpdate(query);
		} catch (SQLException a) {
			System.out.println("No se ha podido insertar");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			e.printStackTrace();
		}
	}

	 /**
     * Realiza el proceso de inicio de sesión.
     * @return true si el inicio de sesión es exitoso, false en caso contrario.
     */
	public boolean login() {
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT username FROM administrado WHERE username='" + usrname.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);

			if (resultados.next()) {
				if (resultados.getString("username").equals(usrname.trim())) {
					query = "SELECT pass FROM administrado WHERE username='" + usrname.trim() + "'";
					resultados = statement.executeQuery(query);
					resultados.next();
					if (password.trim().equals(resultados.getString("pass"))) {
						check = true;

					} else {
						check = false;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error al intentar el login");
			e.printStackTrace();
		}
		
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT numExpediente FROM alumno WHERE numExpediente='" + userAlumno.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);

			if (resultados.next()) {
				if (resultados.getString("numExpediente").equals(userAlumno.trim())) {
					resultados.next();
					System.out.println("Número de expediente válido");
					check = true;

				} else {
					System.out.println("Número de expediente incorrecto");
					check = false;
				}
			}
		} catch (Exception e) {
			System.out.println("Error al intentar el login");
			e.printStackTrace();
		}
		return check;
	}
	
	//Consultar project page	
	 /**
     * Carga los proyectos integradores que coinciden con el criterio de búsqueda especificado.
     * @param buscar Criterio de búsqueda para los proyectos.
     * @return Una lista de proyectos integradores que coinciden con el criterio de búsqueda.
     */
	public ArrayList<ProyectoIntegrador> cargarProyectos(String buscar) {
	    ArrayList<ProyectoIntegrador> proyectos = new ArrayList<>();
	    try {
	        // Crear una sentencia
	        Statement statement = conexion.createStatement();
	        
	        // Construir la consulta SQL
	        String query = buscar;
	        
	        
	        // Ejecutar la consulta y obtener los resultados
	        ResultSet resultados = statement.executeQuery(query);

	        // Recorrer los resultados y crear objetos ProyectoIntegrador
	        while (resultados.next()) {
	            String idProyecto = resultados.getString("idProyecto");
	            String nombre = resultados.getString("nombreProyecto");
	            String urlProy = resultados.getString("urlProyecto");
	            String notaP = resultados.getString("nota");
	            String fechaP = resultados.getString("fecha");
	            String cursoP = resultados.getString("curso");
	            String grupoP = resultados.getString("grupo");
	            
	            //meter aqui algo para consultar un select para meter el area de 1-DAW 2-DAM 3-ASIR
	            String areaP = "areaCorrespondiente";
//	            String areaP= resultados.getString("areaCorrespondiente");
//	            int areaCorrespondiente = resultados.getInt("areaCorrespondiente");
//	            String areaP = "";
	            
	            //No entiendo porque no lo coge de la Base de datos
	            int codigoArea = resultados.getInt("areaCorrespondiente");
	            PreparedStatement areaStatement = conexion.prepareStatement("SELECT nombre FROM areas WHERE codigo = ?");
	            areaStatement.setInt(1, codigoArea);
	            ResultSet areaResultados = areaStatement.executeQuery();
	            if (areaResultados.next()) {
	                areaP = areaResultados.getString("nombre");
	            }
	            
	            ProyectoIntegrador proyecto = new ProyectoIntegrador(idProyecto, nombre, urlProy, notaP, fechaP, cursoP, areaP);
	            proyectos.add(proyecto);
	        }
	    } catch (SQLException e) {
	        // Manejar la excepción de SQL
	        e.printStackTrace();
	    } catch (Exception e) {
	        // Manejar otras excepciones
	        e.printStackTrace();
	    }
	    return proyectos;
	}
	
	
	public ProyectoIntegrador obtenerDatosProyectoDesdeBD(String nombre) {
		// TODO Auto-generated method stub
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    ProyectoIntegrador proyecto = new ProyectoIntegrador();

	    try {
	        // Preparar la consulta SQL
	        String sql = "SELECT * FROM proyectointegrador WHERE nombreproyecto = ?";
	        stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, nombre); // Usar el nombre del proyecto que deseas consultar

	        // Ejecutar la consulta
	        rs = stmt.executeQuery();

	        // Obtener los resultados
	        if (rs.next()) {
	            int id = rs.getInt("idproyecto");
	            String nom = rs.getString("nombreproyecto");
	            String url = rs.getString("urlproyecto");
	            int nota = rs.getInt("nota");
	            int area =rs.getInt("areaCorrespondiente");
	            String curso = rs.getString("curso");
	            String fecha = rs.getString("fecha");


	            // Obtener los demás campos del proyecto
	            proyecto.setIdProyecto(String.valueOf(id));
	            proyecto.setNombreProyecto(nombre);
	            proyecto.setUrlProyecto(url);
	            proyecto.setNota(String.valueOf(nota));
	            proyecto.setCurso(String.valueOf(curso));
	            proyecto.setAreaCorrespondiente(String.valueOf(area));
	            proyecto.setFecha(fecha);;
           	         
	        } else {
	            // El proyecto no existe en la base de datos
	            JOptionPane.showMessageDialog(null, this, "El proyecto no existe", area);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cerrar las conexiones, declaraciones y resultados
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return proyecto;
	}

//	public void guardarCambiosProyecto(String nombreProyecto) {
//	    PreparedStatement stmt = null;
//
//	    try {
//	        // Preparar la consulta SQL para actualizar el proyecto
//	        String sql = "UPDATE proyectointegrador SET nombreproyecto = ?, urlproyecto = ?, nota = ?, areaCorrespondiente = ?, curso = ?, fecha = ? WHERE idproyecto = ?";
//	        stmt = conexion.prepareStatement(sql);
//	        stmt.setString(1, selectedProject.getNombreProyecto());
//	        stmt.setString(2, selectedProject.getUrlProyecto());
//	        stmt.setInt(3, Integer.parseInt(selectedProject.getNota()));
//	        stmt.setInt(4, Integer.parseInt(selectedProject.getAreaCorrespondiente()));
//	        stmt.setString(5, selectedProject.getCurso());
//	        stmt.setString(6, selectedProject.getFecha());
//	        stmt.setInt(7, Integer.parseInt(selectedProject.getIdProyecto()));
//
//
//	        // Ejecutar la consulta
//	        stmt.executeUpdate();
//	        JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente.");
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        JOptionPane.showMessageDialog(null, "Error al guardar los cambios en la base de datos.");
//	    } finally {
//	        // Cerrar la conexión y la declaración
//	        try {
//	            if (stmt != null) stmt.close();
//	            if (conexion != null) conexion.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}


	//Add project page
	 /**
     * Agrega un nuevo proyecto integrador a la base de datos.
     * @return true si el proyecto se agrega correctamente, false en caso contrario.
     */
	public boolean proyectoNuevo() {
	    boolean check = false;
	    try {
	        Statement statement = conexion.createStatement();
	        String query = "INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente) VALUES ('" + id.trim() + "', '" + nombre.trim() + "', '" + urlP.trim() + "', '" + nota.trim() + "', '" + fecha.trim() + "', '" + curso.trim() + "', '" + grupo.trim() + "', '" + area + "')";
	        int resultados = statement.executeUpdate(query);
	        System.out.println("Datos guardados correctamente");
	        if (resultados != 0) {
	            check = true;
	        }

	        // Obtener JComboBox de alumnos
	        JComboBox<String> comboBoxAlumnos = obtenerAlumnos();
	        // Realizar las operaciones necesarias con el JComboBox

	    } catch (SQLException a) {
	        System.out.println("No se ha podido insertar");
	        a.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("Error de aplicación");
	        e.printStackTrace();
	    }
	    return check;
	}
/**
 * Hemos añadido esto, y no funciona el JComboBox
 * @return
 */
	public JComboBox<String> obtenerAlumnos() {
	    JComboBox<String> comboBoxAlumnos = new JComboBox<>();
	    try {
	        Statement statement = conexion.createStatement();
	        String query = "SELECT nombre FROM alumnos";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String nombreAlumno = resultSet.getString("nombre");
	            comboBoxAlumnos.addItem(nombreAlumno);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener los alumnos");
	        e.printStackTrace();
	    }
	    return comboBoxAlumnos;
	}



	/**
     * Comprueba si ya existe un proyecto con el mismo nombre en la base de datos.
     * @return true si el proyecto ya existe, false en caso contrario.
     */
	public boolean proyectoRepetido(){
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM proyectoIntegrador WHERE nombreProyecto = '" + nombre.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);
			if(resultados.next()) {
				check = true;
			}
		} catch (Exception e) {
			
		}
		return check;
	}

	//Delete project page
	/**
     * Elimina los proyectos integradores que coinciden con el criterio de búsqueda especificado.
     * @param buscar Criterio de búsqueda para los proyectos a eliminar.
     * @return Una lista de proyectos integradores que coinciden con el criterio de búsqueda y serán eliminados.
     */
	public ArrayList<ProyectoIntegrador> deleteProyects(String buscar) {
		ArrayList<ProyectoIntegrador> proyectos = new ArrayList();
    try {
			Statement statement = conexion.createStatement();
			String query = buscar;
			ResultSet resultados = statement.executeQuery(query);

        while (resultados.next()) {
            String idProyecto = resultados.getString("idProyecto");
            String nombre = resultados.getString("nombreProyecto");
            String urlProy = resultados.getString("urlProyecto");
            String notaP = resultados.getString("nota");
            String fechaP = resultados.getString("fecha");
            String cursoP = resultados.getString("curso");
            String grupoP = resultados.getString("grupo");
            String areaP = resultados.getString("areaCorrespondiente");

            ProyectoIntegrador proyecto = new ProyectoIntegrador(idProyecto, nombre, urlProy, notaP, fechaP, cursoP, areaP);
            proyectos.add(proyecto);
        }
    } catch (SQLException a) {

    } catch (Exception e) {

    }
    return proyectos;
	}
	
	//alumnos project page
	/**
	 * Muestra por pantalla todos los alumnos
	 * @param buscar
	 * @return alumnList
	 */
	public ArrayList<Alumno> todosAlumnos(String buscar) {
		ArrayList<Alumno> alumnosList = new ArrayList();
		try {
			Statement statement = conexion.createStatement();
			String query = buscar;
			ResultSet resultados = statement.executeQuery(query);
			
			while(resultados.next()) {
				int numEx = resultados.getInt("numExpediente");
				int cod = resultados.getInt("codigo");
				String nombre =resultados.getString("nombre");
				String apellidos = resultados.getString("apellidos");
				int idProyecto = resultados.getInt("idProyecto");
            
				Alumno alumn = new Alumno(numEx, cod, nombre, apellidos, idProyecto);
				alumnosList.add(alumn);
			}
		} catch (SQLException a) {
		} catch (Exception e) {
		}
		return alumnosList;
		}
		
	/**
	 * GETTERS Y SETTERS
	 */
	
	
	public String getUserAlumno() {
		return userAlumno;
	}
	
	public void setUserAlumno(String userAlumno) {
		this.userAlumno = userAlumno;
	}
	
	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCheck() {
		return check;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlP() {
		return urlP;
	}

	public void setUrlP(String urlP) {
		this.urlP = urlP;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}


	

//	public int getR() {
//		return r;
//	}
//
//	public void setR(int r) {
//		this.r = r;
//	}

//	public void cerrarConexion() {
//		try {
//			conexion.close();
//			System.out.print("Conexion cerrada");
//		} catch (Exception e) {
//			System.out.println("Error!");
//			e.printStackTrace();
//		}
//	}
}
