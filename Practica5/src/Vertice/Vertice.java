package Vertice;

/**
* Clase que implementa un vertice de un grafo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class Vertice<T> implements Comparable<Vertice<T>>{
	
	/**
	 * @param id Integer con el id del vertice.
	 */
	private int id;
	
	/**
	 * @param datos Datos que se quieren anadir al vertice.
	 */
	private T datos;
	
	/**
	 * Constructor del vertice, que anade el id y los datos a este.
	 * @param id Integer con el id del vertice.
	 * @param datos Datos que se quieren anadr al vertice.
	 */
	public Vertice(int id, T datos) {
		this.id = id;
		this.datos = datos;
	}
	
	/**
	 * Getter del id del vertice.
	 * @return int con el id del vertice.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Getter de los datos del vertice.
	 * @return Datos del vertice.
	 */
	public T getDatos() {
		return this.datos;
	}
	
	
	/**
	 * Funcion que crea un string con los datos del vertice.
	 * @return String con los datos del vertice.
	 */
	@Override
	public String toString() {
		return this.datos.toString();
	}
	
	/**
	 * Funcion que compara 2 vertices segun dus ids para ordenarlos.
	 * @return int que indica si el vertice pasado por parametro es mayo o menor.
	 */
	@Override
	public int compareTo(Vertice<T> arg0) {
		
		return this.id - arg0.id;
	}
}
