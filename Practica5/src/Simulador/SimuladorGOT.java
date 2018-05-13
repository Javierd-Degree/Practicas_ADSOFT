package Simulador;

import java.util.ArrayList;
import java.util.List;

import Grafo.GrafoGOT;
import Personaje.PersonajeGOT;
import Vertice.Vertice;

/**
* Clase que hereda de Subject y que  implementa un simulador 
* de las interacciones en un GrafoGOT.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class SimuladorGOT extends Subject {
	/**
	 * @param grafo Grafo en el que se realizan las interacciones.
	 */
	private GrafoGOT grafo;
	
	/**
	 * @param origen PersonajeGOT sobre el que realizamos la ultima interaccion.
	 */
	private PersonajeGOT origen;
	
	/**
	 * destinos Lista de PersonajeGOT con los que interactuo el origen.
	 */
	private List<PersonajeGOT> destinos;
	
	/**
	 * Constructor por defecto de la clase SimuladorGOT.
	 * 
	 * @param grafo GrafoGOT sobre el que hacemos la simulacion.
	 */
	public SimuladorGOT(GrafoGOT grafo) {
		this.grafo = grafo;
	}
	
	/**
	 * Getter del personaje que interacciona con el resto.
	 * @return PersonajeGOT que interacciona.
	 */
	public PersonajeGOT getOrigen() {
		return origen;
	}
	
	/**
	 * Getter de la lista de personajes que interaccionan con el origen.
	 * @return Lista de PersonajeGOT que interaccionan con el origen.
	 */
	public List<PersonajeGOT> getDestinos() {
		return destinos;
	}
	
	/**
	 * Dado un nombre, se usa el algoritmo explicado en el enunciado de la 
	 * práctica para determinar las interacciones que un personaje dado
	 * por su nombre tiene con sus vecinos.
	 * 
	 * @param nombre Nombre del personaje que interacciona.
	 */
	public void interaccion(String nombre) {
		Vertice<PersonajeGOT> v = grafo.getVertice(nombre);
		this.origen = v.getDatos();
		this.destinos = new ArrayList<>();
		Double suma = grafo.gradoPonderadoPersonajes().get(nombre);
		for(Vertice<PersonajeGOT> v2: grafo.getVecinosDe(v)) {
			Double p = grafo.getPesoDe(v, v2)/suma;
			Double r = Math.random();
			if(r < p) {
				destinos.add(v2.getDatos());
			}
		}
		
		if(this.destinos.size() > 0) {
			this.notificar();
		}
	}
}
