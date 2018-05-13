package Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Vertice.Vertice;

/**
* Clase que implementa un grafo no dirigido.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class GrafoNoDirigido<T> extends Grafo<T>{
	
	/**
	 * Funcion que anade un arco al grafo no dirigido.
	 * @param v1 Uno de los vertices del arco a anadir.
	 * @param v2 El otro vertice del arco.
	 * @param peso double con el peso del arco a anadir.
	 */
	@Override
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if(existeArco(v1, v2) || existeArco(v2, v1)) {
			/*No lo anadimos porque ya existe.*/
			return;
		}
		
		Map<Integer, Integer> par = new TreeMap<>();
		par.put(v1.getId(),  v2.getId());
		arcos.put(par, peso);
	}
	
	/**
	 * Funcion que devuelve el peso de un arco del grafo.
	 * @param v1 Uno de los vertices del arco.
	 * @param v2 El otro vertice del arco.
	 * @return double con el peso del arco.
	 */
	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer, Integer> par1 = new TreeMap<>();
		par1.put(v1.getId(),  v2.getId());
		
		Map<Integer, Integer> par2 = new TreeMap<>();
		par2.put(v2.getId(), v1.getId());
		
		if(arcos.containsKey(par1)) {
			return arcos.get(par1);
		}
		
		if(arcos.containsKey(par2)) {
			return arcos.get(par2);
		}
		
		return -1;
	}
	
	/**
	 * Funcion que halla los vecinos de un vertice dado del arco.
	 * @param v Vertice del que se quieren hallar los vecinos.
	 * @return Lista de vertices vecinos del vertice dado.
	 */
	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> lista = new ArrayList<>();
		
		for(Map.Entry<Integer, Vertice<T>> par: vertices.entrySet()) {
			if(existeArco(v, par.getValue())) {
				lista.add(par.getValue());
			}else if(existeArco(par.getValue(), v)) {
				lista.add(par.getValue());
			}
		}
		
		return lista;
	}
	
	/**
	 * Funcion que halla el numero de arcos del grafo.
	 * @return int con el numero de arcos del grafo.
	 */
	@Override
	public int getNumArcos() {
		return super.getNumArcos()/2;
	}

}

