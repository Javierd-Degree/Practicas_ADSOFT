package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Vertice.Vertice;

/**
* Clase abstracta que implementa un grafo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public abstract class Grafo<T> {
	
	/**
	 * @param vertices Mapa con el id como clave y los datos como valor, que contiene todos los vertices del grafo.
	 */
	protected Map<Integer, Vertice<T>> vertices;
	
	/**
	 * @param Mapa con los id de los dos nodos como clave, y el peso como valor; que contiene todos los arcos del grafo.
	 */
	protected Map<Map<Integer, Integer>, Double> arcos;
	
	/**
	 * Constructor del grafo que inicializa los parametros de la clase pero no los anade.
	 */
	public Grafo() {
		this.vertices = new TreeMap<>();
		this.arcos = new HashMap<>();
	}
	
	/**
	 * Funcion que crea un vertice con unos datos determinados llamando a otro metodo que crea un id para el vertice.
	 * @param datos Datos que se quieren anadir al vertice.
	 * @return Vertice anadido.
	 */
	public Vertice<T> addVertice(T datos){
		Vertice<T> v = addVertice(this.vertices.size(), datos);
		return v;
		
	}
	
	/**
	 * Funcion que anade un nuevo vertice al grafo.
	 * @param id Numero de identificacion que tendra el nuevo vertice.
	 * @param datos Datos que contendra el nuevo vertice.
	 * @return Vertice anadido al grafo.
	 */
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> vertice = new Vertice<T>(id, datos);
		this.vertices.put(id, vertice);
		return vertice;
	}
	
	/**
	 * Funcion que coge la lista de vertices del grafo.
	 * @return Lista de vertices del grafo.
	 */
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> lista = new ArrayList<>();
		lista.addAll(vertices.values());
		
		return lista;
	}
	
	/**
	 * Funcion que devuelve un vertice del grafo dado su id.
	 * @param id Integer que es el id del nodo que se quiere coger.
	 * @return Vertice del grafo con el id dado.
	 */
	public Vertice<T> getVertice(Integer id){
		return this.vertices.get(id);
	}
	
	/**
	 * Funcion que devuelve el numero de arcos que componen el grafo.
	 * @return integer que contiene el numero de acos del grafo.
	 */
	public int getNumArcos() {
		return this.arcos.size();
	}
	
	/**
	 * Funcion que devuelve el numero de vertices del grafo.
	 * @return integer que contiene el numero de vertices que componen el grafo.
	 */
	public int getNumVertices() {
		return this.vertices.size();
	}
	
	/**
	 * Funcion que determina si un arco dado existe o no en el grafo.
	 * @param v1 vertice de salida del arco que se quiere saber si existe.
	 * @param v2 vertice final del arco.
	 * @return boolean que es 1 si el arco existe y 0 si no.
	 */
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer, Integer> par1 = new TreeMap<>();
		par1.put(v1.getId(),  v2.getId());
		
		return arcos.containsKey(par1);
		
	}
	
	/**
	 * Funcion que crea un string con la informacion del grafo (incluyendo arcos y vertices.
	 * @return String con los datos del grafo.
	 */
	@Override
	public String toString() {
		String result = "Vertices: \n\t";
		
		result += vertices.toString();
		result += "\nArcos: \n\t";
		result += arcos.toString();
		
		return result;
	}
	
	/* TODO  SI YA ESTA AÑADIDO NO LO VOLVEMOS A ANADIR PORQUE SI NO
	 * LA FUNCION DE GETpESODE NO TIENE SENTIDO*/
	/**
	 * Funcion que anade un arco al grafo, es abstracta pues depende de si el grafo es o no dirigido.
	 * @param v1 Vertice de salida del arco a anadir.
	 * @param v2 vertice final del arco a anadir.
	 * @param peso Peso del arco
	 */
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	/**
	 * Funcion abstracta que averigua el peso de un determinado arco del grafo.
	 * @param v1 vertice de salida del arco.
	 * @param v2 vertice final del arco.
	 * @return double con el peso del arco.
	 */
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	
	/**
	 * Funcion abstracta que obtiene la lista de los vertices vecinos de un vertice dado del grafo.
	 * @param v Vertice del que se quieren hallar los vecinos.
	 * @return lista de los vertices vecinos.
	 */
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);
	
	
}
