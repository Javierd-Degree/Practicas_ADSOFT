/**
 * Esta clase implementa un profesor autoescuela, perteneciente a una cadena,
 * tal y como se explica en la segunda practica.
 * Contiene los atributos minimos para ejecutarse como se 
 * pide en el ejercicio opcional.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

import java.util.*;

public class Profesor{
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String segSocial;
	private double antiguedad;
	private double sueldoBase;
	private Autoescuela autoesuelaActual; 
	private List<EtapaTrabajo> autoescuelasAnteriores;

	
	/** 
	 * Constructor completo
   	 * @param dni DNI del profesor
   	 * @param nombre Nombre del profesor
   	 * @param apellidos Apellidos del profesor
   	 * @param telefono Numero de telefono del profesor
   	 * @param segSocial Numero de la seguridad social del profesor
   	 * @param antiguedad Años que lleva el profesor trabajando en la autoescuela actual
   	 * @param sueldoBase Sueldo que cobra el profesor sin contar clases prácticas
   	 * @param autoesuelaActual Autoescuela en la que trabaja actualmente el profesor
   	 * @param autoescuelasAnteriores Lista con todas las etapas en las que ha trabajado anteriormente el profesor en otras autoescuelas
   	 */
	public Profesor(String dni, String nombre, String apellidos, String telefono,
		String segSocial, double antiguedad, double sueldoBase, Autoescuela autoesuelaActual,
		List<EtapaTrabajo> autoescuelasAnteriores){

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.segSocial = segSocial;
		this.antiguedad = antiguedad;
		this.sueldoBase = sueldoBase;
		this.autoesuelaActual = autoesuelaActual;
		this.autoescuelasAnteriores = new ArrayList<>();
		if( autoescuelasAnteriores != null) {
			this.autoescuelasAnteriores.addAll(autoescuelasAnteriores);
		}
	}

	/** 
	 * Añade una nueva etapa a la lista de etapas en las que el profesor ha trabajado anteriormente en otras autoescuelas
   	 * @param etapa Nueva etapa que se quiere añadir a la lista
   	 */
	public void anadirEtapa(EtapaTrabajo etapa){
		this.autoescuelasAnteriores.add(etapa);
	}

	/** 
	 * Consigue una string con el nombre y los apellidos del profesor
   	 * @return Nombre y apellidos del profesor
   	 */
	public String getNombreCompleto(){
		return nombre+" "+apellidos;
	}

	/**
	 * Devuelve el historial de autoesuelas donde ha trabajado el profesor
	 * o bien una linea explicando que solo ha trabajado en su autoescuela actual.
	 * No devuelve la autoescuela actual pues no se pide.
   	 * @return String con todas las autoescuelas en las que el profesor ha trabajado anteriormente
   	 */
	public String getHistorial(){
		String result;

		if(autoescuelasAnteriores.size() == 0){
			return "El profesor " + getNombreCompleto() + " trabaja en la autoescuela " +
			autoesuelaActual.getNombre() + " y no ha trabajado en ninguna mas.";
		}

		result = "El profesor " + getNombreCompleto() + " trabajo en la autoescuela ";
		for(EtapaTrabajo trabajo : autoescuelasAnteriores){
			result += trabajo;
		}

		return result;
	}
}


