package modelo;

public class ProyectoIntegrador {
	
	private String idProyecto;
	private String nombreProyecto;
	private String urlProyecto;
	private String nota;
	private String fecha;
	private String curso;
	private String areaCorrespondiente;
	
	/**
	 * Constructor de la clase ProyectoIntegrador.
	 *
	 * @param idProyecto          ID del proyecto.
	 * @param nombreProyecto      Nombre del proyecto.
	 * @param urlProyecto         URL del proyecto.
	 * @param nota                Nota del proyecto.
	 * @param fecha               Fecha del proyecto.
	 * @param curso               Curso asociado al proyecto.
	 * @param areaCorrespondiente Área correspondiente del proyecto.
	 */
	public ProyectoIntegrador (String idProyecto, String nombreProyecto, String urlProyecto, String note, String fecha, String curso,  String areaCorrespondiente ) {
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.urlProyecto = urlProyecto;
		this.nota = note;
		this.fecha = fecha;
		this.curso = curso;
		this.areaCorrespondiente = areaCorrespondiente;
	}
	
	public ProyectoIntegrador() {
		
	}

	/**
	 * GETTERS Y SETTERS
	 */
	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getUrlProyecto() {
		return urlProyecto;
	}

	public void setUrlProyecto(String urlProyecto) {
		this.urlProyecto = urlProyecto;
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


	public String getAreaCorrespondiente() {
		return areaCorrespondiente;
	}

	public void setAreaCorrespondiente(String areaCorrespondiente) {
		this.areaCorrespondiente = areaCorrespondiente;
	}
	
	public String toString() {
		return nombreProyecto + " - " + nota;
	}
	
}
