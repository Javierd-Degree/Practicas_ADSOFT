package Grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Vertice.Vertice;

public class GrafoDirigido<T> extends Grafo<T>{

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

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer, Integer> par = new TreeMap<>();
		par.put(v1.getId(),  v2.getId());
		Double peso = arcos.get(par);
		
		return peso == null ? -1: peso;
	}

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
