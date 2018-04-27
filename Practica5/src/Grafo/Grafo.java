package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Vertice.Vertice;

public abstract class Grafo<T> {
	protected Map<Integer, Vertice<T>> vertices;
	/**
	 * Mapa con los id de los dos nodos como clave, y el peso como valor.
	 */
	protected Map<Map<Integer, Integer>, Double> arcos;
	
	public Grafo() {
		this.vertices = new TreeMap<>();
		this.arcos = new HashMap<>();
	}
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> v = addVertice(this.vertices.size(), datos);
		return v;
		
	}
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> vertice = new Vertice<T>(id, datos);
		this.vertices.put(id, vertice);
		return vertice;
	}
	
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> lista = new ArrayList<>();
		lista.addAll(vertices.values());
		
		return lista;
	}
	
	public int getNumArcos() {
		return this.arcos.size();
	}
	
	public int getNumVertices() {
		return this.vertices.size();
	}
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer, Integer> par1 = new TreeMap<>();
		par1.put(v1.getId(),  v2.getId());
		
		return arcos.containsKey(par1);
		
	}
	
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
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);
	
	
}
