package Simulador;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

/**
* Clase abstracta que implementa un Subject.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public abstract class Subject {
	/**
	 * @param observer Lista de Observer que observan al Subject
	 */
	private List<Observer> observer = new ArrayList<>();
	
	/**
	 * Metodo que permite anadir otro Observer al Subject.
	 * @param o Observer a anadir.
	 */
	public void addObserver(Observer o) {
		this.observer.add(o);
	}
	
	/**
	 * Metodo que permite notificar a todos los Observer.
	 */
	public void notificar() {
		this.observer.forEach(o -> o.actualizar());
	}
}
