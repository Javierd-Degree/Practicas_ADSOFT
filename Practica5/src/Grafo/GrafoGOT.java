package Grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Personaje.PersonajeGOT;
import Vertice.Vertice;

/**
* Clase que implementa un grafo no dirigido de los personajes de juego de tronos.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	
	/**
	 * Constructor del grafo no dirigido, que lo crea a partir de los datos de 2 ficheros.
	 * @param ficheroVertices String con el nombre del fichero con los datos de los vertices.
	 * @param ficheroArchivos String con el nombre del fichero con los datos de los arcos del grafo.
	 */
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		super();

		/*Leemos los vertices del grafo.*/
		String data;
		FileReader f = new FileReader(ficheroVertices);
		BufferedReader b = new BufferedReader(f);
		while((data = b.readLine())!=null) {
			String[] tokens = data.split(",");
			int id = Integer.parseInt(tokens[0]);
			PersonajeGOT p = new PersonajeGOT(tokens[1], tokens[2]);
			addVertice(p, id);
		}
		b.close();
		
		/*Leemos y creamos los arcos del grafo*/
		f = new FileReader(ficheroArcos);
		b = new BufferedReader(f);
		while((data = b.readLine())!=null) {
			String[] tokens = data.split(",");
			int id1 = Integer.parseInt(tokens[0]);
			int id2 = Integer.parseInt(tokens[1]);
			int peso = Integer.parseInt(tokens[2]);
			addArco(getVertice(id1), getVertice(id2), peso);
		}
		b.close();
	}
	
	/**
	 * Funcion que anade un vertice con un PersonajeGOT al grafo.
	 * @param datos PersonajeGOT del vertice a anadir.
	 * @param id int con el id del vertice a anadir.
	 * @return vertice anadido.
	 */
	public Vertice<PersonajeGOT> addVertice(PersonajeGOT datos, int id){
		Vertice<PersonajeGOT> v = addVertice(id, datos);
		return v;
	}
	
	/**
	 * Funcion que halla el vertice del grafo con el personaje con el nombre que se pasa como argumento.
	 * @param nombre String con el nombre del personaje del vertice que se quiere hallar.
	 * @return vertice con el personaje con el nombre pasado como argumento.
	 */
	public Vertice<PersonajeGOT> getVertice(String name){
		return this.getVertices().stream().filter(v -> v.getDatos().getNombre().equals(name)).findFirst().get();
	}
	
	/**
	 * Funcion que halla una lista con el nombre de las casas de los personajes del grafo.
	 * @return Lista de Strings con los nombres de las casas.
	 */
	public List<String> casas(){
		Set<String> set = this.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa).collect(Collectors.toCollection(() -> new TreeSet<>()));
		return new ArrayList<String>(set);
	}
	
	/**
	 * Funcion que halla los nombres de los personajes del grafo de una casa determinada.
	 * @param casa String con el nombre de la casa de la que se quieren hallar los personajes.
	 * @return Lista de Strings con los nombres de los personajes de la casa.
	 */
	public List<String> miembrosCasa(String casa){
		Predicate<PersonajeGOT> predicate = new Predicate<PersonajeGOT>() {
			@Override
			public boolean test(PersonajeGOT arg0) {
				return arg0.getCasa().equals(casa);
			}
		};
		
		return this.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).filter(predicate).map(PersonajeGOT::getNombre).collect(Collectors.toList());
	}
	
	/**
	 * Funcion que halla los grados de los vertices de todos los personajes del grafo.
	 * @return Map con el nombre del personaje y el grado de su vertice en el grafo.
	 */
	public Map<String, Integer> gradoPersonajes(){
		Map<String, Integer> map = new HashMap<>();
		this.getVertices().stream().forEach((p) -> {
			map.put(p.getDatos().getNombre(), getVecinosDe(p).size());
		});
		
		return map;
	}
	
	/**
	 * Funcion que halla el grado ponderado de los personajes del grafo.
	 * @return Map con el nombre de los personajes y el grado ponderado de sus vertices.
	 */
	public Map<String, Double> gradoPonderadoPersonajes(){
		Map<String, Double> map = new HashMap<>();
		this.getVertices().stream().forEach((p) -> {
			Double suma = 0.0;
			List<Vertice<PersonajeGOT>> vecinos = getVecinosDe(p);
			for(Vertice<PersonajeGOT> v: vecinos) {
				suma += getPesoDe(p, v);
			}
			map.put(p.getDatos().getNombre(), suma);
		});
		
		return map;
	}
	
	/**
	 * Funcion que halla los personajes que son mas relevantes de los del grafo (fijandose en su grado ponderado)
	 * @return Map con el nombre del personaje y el grado ponderado de su vertice.
	 */
	public Map<String, Double> personajesRelevantes(){
		Map<String, Double> personajes = gradoPonderadoPersonajes();
		Double media = personajes.entrySet().stream().mapToDouble(Entry<String, Double>::getValue).average().orElse(0.0);
		/*Ponerlos en un map*/
		return personajes.entrySet().stream().filter(v -> v.getValue() > media).collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue()));
	}
	
	
}
