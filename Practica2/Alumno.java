/**
 * Esta clase implementa un alumno de una autoescuela.
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

	/** 
	 * Constructor completo
   	 * @param dni DNI del alumno
   	 * @param nombre Nombre del alumno
   	 * @param apellidos Apellidos del alumno
   	 * @param telefono Numero de telefono del alumno
   	 * @param carnetTiene Carnet que ya posee el alumno (si posee alguno)
   	 * @param carnetMatriculado Carnet para el que el alumno se ha matriculado en la autoescuela
   	 * @param descuento Descuento que obtiene el alumno en la matrícula (si obtiene alguno)
   	 * @param fechaNacimiento Fecha de nacimiento del alumno
   	 * @param fechaMatriculacion Fecha en la que se ha matriculado el alumno en la autoescuela
   	 * @param fechaApruebaTeorico Fecha en la que el alumno ha aprobado el teorico (si lo ha aprobado)
   	 * @param fechaApruebaPractico Fecha en la que el alumno ha aprobado el practico (si lo ha aprobado)
   	 */
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

	/**
	 * Constructor para el tester dado en clase 
   	 * @param dni DNI del alumno
   	 * @param nombre Nombre del alumno
   	 * @param apellidos Apellidos del alumno
   	 * @param anyo Año en el que se matriculo el alumno
   	 * @param mes Mes en el que se matriculo el alumno
   	 * @param dia Dia en el que se matriculo el alumno
   	 * @param carnetMatriculado Carnet para el que el alumno se ha matriculado en la autoescuela
   	 */
	public Alumno(String dni, String nombre, String apellidos, int anyo, int mes, int dia, String carnetMatriculado){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.carnetMatriculado = carnetMatriculado;
		this.fechaMatriculacion =new Fecha(anyo, mes, dia);

	}

	/** 
	 * Getter de la fecha de matriculación del alumno
   	 * @return Fecha de matriculación del alumno
   	 */
	public Fecha getFechaMatr(){
		return this.fechaMatriculacion;

	}

	/** 
	 * Crea un string con los datos del alumno
   	 * @return Un string con todos los datos del alumno
   	 */
	public String toString(){
		return "\n\tNombre: " + this.nombre + "\n\tApellido: " + apellidos + "\n\tDNI: " + dni + "\n\tFecha Matricula: " + fechaMatriculacion + "\n\tTipo Carnet: " + carnetMatriculado;
	}
}


