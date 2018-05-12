package Observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Personaje.PersonajeGOT;
import Simulador.SimuladorGOT;

public class ObservadorGOT extends Observer {
	private PersonajeGOT personaje;
	private int interaccionesCasa;
	private Map<String, Integer> interaccionesFuera;
	
	public ObservadorGOT(SimuladorGOT s, PersonajeGOT p) {
		super(s);
		this.personaje = p;
		this.interaccionesCasa = 0;
		this.interaccionesFuera = new HashMap<>();
	}
	
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
