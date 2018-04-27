package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Vertice.Vertice;

public class GrafoNoDirigido<T> extends Grafo<T>{

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

}

