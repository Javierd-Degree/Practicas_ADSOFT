package Observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Personaje.PersonajeGOT;
import Simulador.SimuladorGOT;


/**
* Clase que hereda de Observer y que  implementa un observador 
* de las interacciones de un PersonajeGOT.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class ObservadorGOT extends Observer {
	/**
	 * @param personaje PersonajeGOT al que queremos observar en el grafo.
	 */
	private PersonajeGOT personaje;
	
	/**
	 * @param interaccionesCasa numero de interacciones que ha hecho con
	 * los personajes de su propia casa.
	 */
	private int interaccionesCasa;
	
	/**
	 * @param interaccionesFuera Map con las interacciones que ha tenido con cada una de las casas.
	 */
	private Map<String, Integer> interaccionesFuera;
	
	/**
	 * Constructor por defecto de la clase ObservadorGOT.
	 * 
	 * @param s Simulador que tenemos que observar.
	 * @param p Personaje dentro del simulador que tenemos que observar.
	 */
	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		super(s);
		this.personaje = p;
		this.interaccionesCasa = 0;
		this.interaccionesFuera = new HashMap<>();
	}
	
	/**
	 * Metodo que permite notificar al ObservadorGOT de
	 * que actualice las interacciones del PersonajeGOT.
	 */
	public void actualizar() {
		SimuladorGOT simulador = (SimuladorGOT) super.subject;
		PersonajeGOT origen = simulador.getOrigen();
		List<PersonajeGOT> destinos = simulador.getDestinos();
		if(!origen.equals(this.personaje)) {
			return;
		}
		
		for(PersonajeGOT p: destinos) {
			if(p.getCasa().equals(this.personaje.getCasa())) {
				this.interaccionesCasa ++;
			}else {
				if(this.interaccionesFuera.containsKey(p.getCasa())) {
					this.interaccionesFuera.put(p.getCasa(), this.interaccionesFuera.get(p.getCasa()) + 1);
				}else {
					this.interaccionesFuera.put(p.getCasa(), 1);
				}
			}
		}
	}
	
	/**
	 * Metodo que permite mostrar las interacciones del PersonajeGOT seguido.
	 * 
	 * @return String con un desglose de las interacciones realizadas.
	 */
	public String toString() {
		String result = personaje.getNombre();
		int intFuera = interaccionesFuera.entrySet().parallelStream().mapToInt(Entry<String, Integer>::getValue).sum();
		result += "\n\tInteracciones: "+(interaccionesCasa+intFuera);
		result += "\n\t\tCon miembros de su casa: "+this.interaccionesCasa;
		result += "\n\t\tCon miembros de casa ajena: "+intFuera;
		for(Entry<String, Integer> c: this.interaccionesFuera.entrySet()) {
			result +=  "\n\t\t\t"+c.getKey()+": "+c.getValue();
		}
		
		return result;
	}
}
