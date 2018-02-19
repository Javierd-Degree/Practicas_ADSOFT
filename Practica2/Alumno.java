/**
 * Esta aplicacion calcula el triangulo de tartaglia de n filas.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class Alumno{
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String carnetMatriculado;
	private String carnetTiene;
	private double descuento;
	private Fecha fechaNacimiento;
	private Fecha fechaMatriculacion;
	private Fecha fechaApruebaPractico;
	private Fecha fechaApruebaTeorico;

	/*Constructor completo*/
	public Alumno(String dni, String nombre, String apellidos, String telefono, String carnetTiene, String carnetMatriculado, double descuento,
	 Fecha fechaNacimiento, Fecha fechaMatriculacion, Fecha fechaApruebaTeorico, Fecha fechaApruebaPractico){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.carnetTiene = carnetTiene;
		this.carnetMatriculado = carnetMatriculado;
		this.descuento = descuento;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaMatriculacion = fechaMatriculacion;
		this.fechaApruebaTeorico = fechaApruebaTeorico;
		this.fechaApruebaPractico = fechaApruebaPractico;

	}

	/*Constructor para el tester dado en clase*/
	public Alumno(String dni, String nombre, String apellidos, String carnetMatriculado, Fecha fechaMatriculacion){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.carnetMatriculado = carnetMatriculado;
		this.fechaMatriculacion = fechaMatriculacion;

	}

	public toString(){
		return "Nombre: " + this.nombre + "\nApellido: " + apellidos + "\nDNI: " + dni + "\nFecha Matricula: " + fechaMatriculacion + "\nTipo Carnet: " + carnetMatriculado;
	}
}


