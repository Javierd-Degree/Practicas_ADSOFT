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
	 * Metodo que nos permite calcular el valor de un INodo.
	 * 
	 * @return valor de un INodo.
	 */
	public Object calcular();
	
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
	
	/**
	 * Metodo anadido por nosotros que permite etiquetar a un Nodo y todos sus 
	 * descendientes, con enteros del cero al numero total de nodos menos 1.
	 */
	public void etiquetaNodos();
	
	/**
	 * Metodo anadido por nosotros que permite etiquetar INodos de 
	 * forma recursiva.
	 * 
	 * @param etiqueta etiqueta a asignar a dicho nodo.
	 * @return siguiente etiqueta que estaria disponible.
	 */
	public int etiquetar(int etiqueta);
	
	
	/**
	 * Metodo anadido por nosotros que permite encontrar
	 * un Nodo dentro de los descendientes de otro, de 
	 * forma recursiva, usando su etiqueta.
	 * 
	 * @param etiqueta etiqueta del nodo que estamos buscando.
	 * @return INodo buscado, o null si no se encuentra.
	 */
	public INodo buscarNodo(int etiqueta);
	
	
	/**
	 * Metodo recursivo que permite reemplazar el INodo cuya etiqueta se pasa
	 * como parametro, por el INodo pasado.
	 * 
	 * @param etiqueta int con la etiqueta del nodo a reemplazar.
	 * @param sustituto INodo que queremos poner en la posicion
	 * del anterior.
	 * @return parametro usado por la recursion que se puede ignorar.
	 */
	public boolean reemplazarNodo(int etiqueta, INodo sustituto);
}