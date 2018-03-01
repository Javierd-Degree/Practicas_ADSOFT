/**
 * Esta clase implementa un periodo de tiempo en el que un profesor 
 * ha trabajado en una determinada autoescuela.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class EtapaTrabajo{
	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Autoescuela autoescuela;

	
	/** 
	 * Constructor completo
   	 * @param fechaInicio Fecha en la que el profesor comienza a trabajar en la autoescuela
   	 * @param fechaFin Fecha en la que el profesor deja de trabajar en la autoescuela
   	 * @param autoescuela Autoescuela en la que e profesor estuvo trabajando en este periodo
   	 */
	public EtapaTrabajo(Fecha fechaInicio, Fecha fechaFin, Autoescuela autoescuela){
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.autoescuela = autoescuela;
	}

	/** 
	 * Imprime una frase con los datos de la EtapaTrabajo
   	 * @return String con los datos de la etapa de trabajo de un profesor en una autoescuela
   	 */
	public String toString(){
		return autoescuela.getNombre() + " desde el " + fechaInicio +
		" hasta el " + fechaFin + ".";
	}
}


