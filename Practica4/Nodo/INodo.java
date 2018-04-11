package Nodo;

import java.util.List;

/**
* Interfaz dada con las operaciones necesarias de un INodo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public interface INodo {
	/**
	 * Metodo que devuelve la raiz de un INodo como
	 * un String.
	 * 
	 * @return String con la raiz del Nodo.
	 */
	public String getRaiz();
	
	/**
	 * Metodo que devuelve la lista de descendientes de un INodo.
	 * 
	 * @return List<INodo> con los descendientes del INodo.
	 */
	public List<INodo> getDescendientes();
	
	/**
	 * Metodo que permite anadir un descenciente a un INodo.
	 * 
	 * @param nodo INodo descenciente a anadir.
	 */
	public void incluirDescendiente(INodo nodo);

	/**
	 * Metodo que nos permite calcular el valor numerico de un INodo.
	 * 
	 * @return valor numerico de un INodo.
	 */
	public double calcular();
	
	/**
	 * Metodo que permite copiar un nodo, copiando tambien todos sus 
	 * descendientes.
	 * 
	 * @return nodo copia del instanciado.
	 */
	public INodo copy();
	
	
	/**
	 * Metodo anadido por nosotros que nos permite contar el numero
	 * de nodos de un INodo.
	 * 
	 * @return numero de nodos de un INodo, incluyendose a si mismo.
	 * */
	public int numNodos();
}