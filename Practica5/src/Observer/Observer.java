package Observer;

import Simulador.Subject;

/**
* Clase abstracta que implementa un observador de un Subject.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public abstract class Observer {
	/**
	 * @param subject Subject al que queremos observar.
	 */
	protected Subject subject;
	
	/**
	 * Constructor por defecto de la clase Observador.
	 * 
	 * @param s Subject que tenemos que observar.
	 */
	public Observer(Subject s) {
		this.subject = s;
		this.subject.addObserver(this);
	}
	
	/**
	 * Metodo abstracto que permite notificar al Observer
	 * de que ha habido cambios.
	 */
	public abstract void actualizar();
	
	/**
	 * Getter del Subject del Observer.
	 * 
	 * @return Subject que estamos observando.
	 */
	public Subject getSubject() {
		return this.subject;
	}
	
	/**
	 * Metodo que permite mostrar las interacciones del Subject seguido.
	 * 
	 * @return String con un desglose de las observaciones.
	 */
	public abstract String toString();
}
