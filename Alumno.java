package ejercicio4;

import java.time.LocalDate;

/**
 * Clase que representa a un alumno con sus datos personales.
 */

public class Alumno {

	private int nia; // Número de Identificación del Alumno
	
	private String nombre; // Nombre del alumno
	
	private String apellidos; // Apellidos del alumno
	
	private char generoCaracter; // Género del alumno (M/F/O)
	
	private LocalDate fechaNac; // Fecha de nacimiento del alumno
	
	private String ciclo; // Ciclo que cursa el alumno
	
	private String curso; // Curso que cursa el alumno
	
	private String grupo; // Grupo al que pertenece el alumno
	
	/**
     * Constructor para crear un objeto Alumno.
     * 
     * @author Juanjo
     *
     * @param nia Número de Identificación del Alumno
     * @param nombre Nombre del alumno
     * @param apellidos Apellidos del alumno
     * @param generoCaracter Género del alumno
     * @param fechaNac Fecha de nacimiento del alumno
     * @param ciclo Ciclo que cursa el alumno
     * @param curso Curso que cursa el alumno
     * @param grupo Grupo al que pertenece el alumno
     */
	
	public Alumno(int nia, String nombre, String apellidos, char generoCaracter,  LocalDate fechaNac, String ciclo, String curso, String grupo) {
		
		this.nia = nia;
		
		this.nombre = nombre;
		
		this.apellidos = apellidos;
		
		this.generoCaracter = generoCaracter;
		
		this.fechaNac = fechaNac;
		
		this.ciclo = ciclo;
		
		this.curso = curso;
		
		this.grupo = grupo;
		
	}
	
	// Métodos getter para acceder a los atributos del alumno

	public int getNia() {
		
		return nia;
		
	}

	public String getNombre() {
		
		return nombre;
		
	}

	
	public String getApellidos() {
		
		return apellidos;
		
	}

	public char getGenero() {
		
		return generoCaracter;
		
	}

	public LocalDate getFechaNac() { 
		
		return fechaNac; 
		
		}
	
	public String getCiclo() {
		
		return ciclo;
		
	}

	public String getCurso() {
		
		return curso;
		
	}

	public String getGrupo() {
		
		return grupo;
		
	}

	@Override
	
	// Devuelve una representación en formato de cadena del objeto Alumno
	
	public String toString() {
		
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", generoCaracter="
				
				+ generoCaracter + ", fechaNac=" + fechaNac + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo="
				
				+ grupo + "]";
	}
	
}
