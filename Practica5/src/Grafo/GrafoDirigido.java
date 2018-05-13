package Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Vertice.Vertice;

/**
* Clase que implementa un grafo dirigido.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class GrafoDirigido<T> extends Grafo<T>{
	
	/**
	 * Funcion que anade un arco dado al grafo dirigido.
	 * @param v1 vertice del que sale el nuevo arco a anadir.
	 * @param v2 vertice al que llega el arco a anadir.
	 * @param peso Peso que tendra el nuevo arco.
	 */
	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if(existeArco(v1, v2)) {
			/*No lo anadimos porque ya existe.*/
			return;
		}
		
		Map<Integer, Integer> par = new TreeMap<>();
		par.put(v1.getId(),  v2.getId());
		arcos.put(par,  peso);
	}
	
	/**
	 * Funcion que devuelve el peso de un arco dado.
	 * @param v1 vertice del que sale el arco del que se quiere hallar el peso.
	 * @param v2 vertice al que llega el arco del que se quiere hallar el peso.
	 * @return double Peso del arco.
	 */
	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer, Integer> par = new TreeMap<>();
		par.put(v1.getId(),  v2.getId());
		Double peso = arcos.get(par);
		
		return peso == null ? -1: peso;
	}
	
	/**
	 * Funcion que devuelve una lista con los vertices vecinos de un vertice dado del grafo.
	 * @param v Vertice del que se quieren hallar los vecinos.
	 * @return Lista de los vecinos del vertice dado.
	 */
	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> lista = new ArrayList<>();
		
		for(Map.Entry<Integer, Vertice<T>> par: vertices.entrySet()) {
			if(existeArco(v, par.getValue())) {
				lista.add(par.getValue());
			}
		}
		
		return lista;
	}

}
