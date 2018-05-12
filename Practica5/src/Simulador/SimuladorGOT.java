package Simulador;

import java.util.ArrayList;
import java.util.List;

import Grafo.GrafoGOT;
import Personaje.PersonajeGOT;
import Vertice.Vertice;

public class SimuladorGOT extends Subject {
	private GrafoGOT grafo;
	
	private PersonajeGOT origen;
	private List<PersonajeGOT> destinos;
	
	public SimuladorGOT(GrafoGOT grafo) {
		this.grafo = grafo;
	}
	
	
	public PersonajeGOT getOrigen() {
		return origen;
	}
	
	public List<PersonajeGOT> getDestinos() {
		return destinos;
	}
	
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
