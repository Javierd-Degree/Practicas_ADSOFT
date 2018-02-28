/**
 * Esta clase implementa una autoescuela, perteneciente a una cadena
 * tal y como se explica en la segunda practica.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class EtapaTrabajo{
	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Autoescuela autoescuela;

	
	/*Constructor completo*/
	/*TODO Completar con @params etc*/
	public EtapaTrabajo(Fecha fechaInicio, Fecha fechaFin, Autoescuela autoescuela){
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.autoescuela = autoescuela;
	}

	public String toString(){
		return autoescuela.getNombre() + " desde el " + fechaInicio +
		" hasta el " + fechaFin + ".";
	}
}


