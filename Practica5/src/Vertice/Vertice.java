package Vertice;

public class Vertice<T> implements Comparable<Vertice<T>>{
	private int id;
	private T datos;
	
	public Vertice(int id, T datos) {
		this.id = id;
		this.datos = datos;
	}
	
	public int getId() {
		return this.id;
	}
	
	public T getDatos() {
		return this.datos;
	}
	
	@Override
	public String toString() {
		return this.datos.toString();
	}

	@Override
	public int compareTo(Vertice<T> arg0) {
		
		return this.id - arg0.id;
	}
}
