import java.util.List;
import java.util.stream.Collectors;

import Grafo.GrafoGOT;
import Observer.ObservadorGOT;
import Observer.Observer;
import Personaje.PersonajeGOT;
import Simulador.SimuladorGOT;
import Vertice.Vertice;

/**
* Clase que permite ejecutar la simulacion tal y como se explica en el enunciado 
* de la práctica.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class TesterSimulacion {
	
	/**
	 * Metodo main de la clase TesterSimulacion.
	 * Para probar las clases SimuladorGOT y ObserverGOT, inicializamos un GrafoGOT,
	 * y establecemos tres Observer, uno para Jon Snow, otro para Hodor, y otro para
	 * Viserys Targaryen.
	 * Entonces, elegimos aleatoriamente un personaje del grafo, y hacemos que interaccione.
	 * Repetimos dicho proceso un numero N de veces, fijado al principio.
	 * Finalmente, mostramos por pantalla el resultado de las interacciones de 
	 * los tres personajes.
	 * 
	 * @param args Argumos de entrada. Se ignoran.
	 */
	public static void main(String[] args) {
		int N = 5000;
		
		GrafoGOT grafo;
		try {
			grafo = new GrafoGOT("./got-s01-vertices.csv", "./got-s01-arcos.csv");
		} catch (Exception e) {
			System.out.println("Los archivos indicados no existen.");
			e.printStackTrace();
			return;
		}
		System.out.println("Grafo cargado");
		
		SimuladorGOT simulador = new SimuladorGOT(grafo);
		
		//Creamos varios observadores:
		PersonajeGOT seguimos1 = grafo.getVertice("Jon Snow").getDatos();
		Observer observer1 = new ObservadorGOT(simulador, seguimos1);
		PersonajeGOT seguimos2 = grafo.getVertice("Hodor").getDatos();
		Observer observer2 = new ObservadorGOT(simulador, seguimos2);
		PersonajeGOT seguimos3 = grafo.getVertice("Viserys Targaryen").getDatos();
		Observer observer3 = new ObservadorGOT(simulador, seguimos3);
		
		List<String> nombresPersonajes = grafo.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getNombre).collect(Collectors.toList());
		for(int i = 0; i < N; i++) {
			// Elegimos un personaje aleatorio de todos los disponibles en el grafo.
			String nombre = nombresPersonajes.get((int) Math.floor((Math.random()*nombresPersonajes.size())));
			simulador.interaccion(nombre);
		}
		
		System.out.println(observer1.toString());
		System.out.println(observer2.toString());
		System.out.println(observer3.toString());
	}
}
