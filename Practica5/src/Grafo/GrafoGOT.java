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

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	
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
	
	public Vertice<PersonajeGOT> addVertice(PersonajeGOT datos, int id){
		Vertice<PersonajeGOT> v = addVertice(id, datos);
		return v;
	}
	
	public Vertice<PersonajeGOT> getVertice(String name){
		return this.getVertices().stream().filter(v -> v.getDatos().getNombre().equals(name)).findFirst().get();
	}
	
	public List<String> casas(){
		Set<String> set = this.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa).collect(Collectors.toCollection(() -> new TreeSet<>()));
		return new ArrayList<String>(set);
	}
	
	public List<String> miembrosCasa(String casa){
		Predicate<PersonajeGOT> predicate = new Predicate<PersonajeGOT>() {
			@Override
			public boolean test(PersonajeGOT arg0) {
				return arg0.getCasa().equals(casa);
			}
		};
		
		return this.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).filter(predicate).map(PersonajeGOT::getNombre).collect(Collectors.toList());
	}
	
	public Map<String, Integer> gradoPersonajes(){
		Map<String, Integer> map = new HashMap<>();
		this.getVertices().stream().forEach((p) -> {
			map.put(p.getDatos().getNombre(), getVecinosDe(p).size());
		});
		
		return map;
	}
	
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
	
	public Map<String, Double> personajesRelevantes(){
		Map<String, Double> personajes = gradoPonderadoPersonajes();
		Double media = personajes.entrySet().stream().mapToDouble(Entry<String, Double>::getValue).average().orElse(0.0);
		/*Ponerlos en un map*/
		return personajes.entrySet().stream().filter(v -> v.getValue() > media).collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue()));
	}
	
	
}
