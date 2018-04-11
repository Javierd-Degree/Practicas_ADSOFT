package Nodo;

import java.util.ArrayList;
import java.util.List;

/**
* Clase abstracta Nodo que implemente la interfaz INodo, 
* permitiendonos asi crear implementaciones de algunas de
* las funciones que son exactamente iguales en todos los tipos
* de nodos.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public abstract class Nodo implements INodo{

	/**
	 * @param simbolo Simbolo del Nodo. 
	 * Usando un objeto como símbolo conseguimos que sea lo
	 * mas generico posible.*/
	protected Object simbolo;
	/**
	 * @param descendientes Lista de descencientes del Nodo.
	 */
	protected List<INodo> descendientes;
	
	/**
	 * Constructor por defecto de la clase Nodo.
	 * 
	 * @param simbolo simbolo del Nodo a crear
	 */
	public Nodo(Object simbolo) {
		this.simbolo = simbolo;
		descendientes = new ArrayList<>();
	}
	
	/**
	 * Metodo que devuelve la raiz de un INodo como
	 * un String.
	 * 
	 * @return String con la raiz del Nodo.
	 */
	@Override
	public String getRaiz() {
		return simbolo.toString();
	}
	
	/**
	 * Metodo que devuelve la lista de descendientes de un INodo.
	 * 
	 * @return List<INodo> con los descendientes del INodo.
	 */
	@Override
	public List<INodo> getDescendientes(){
		return this.descendientes;
	}
	
	/**
	 * Metodo que permite anadir un descenciente a un Nodo.
	 * 
	 * @param nodo INodo descenciente a anadir.
	 */
	@Override
	public void incluirDescendiente(INodo nodo) {
		this.descendientes.add(nodo);
	}
	
	/**
	 * Metodo que devuelve un String que nos permite
	 * reconocer a un Nodo.
	 * 
	 * @return String que describe al Nodo.
	 */
	@Override
	public String toString() {
		return ""+simbolo+" ";
	}
	
	/**
	 * Metodo que, dado un INodo, cuenta de forma recursiva el numero total 
	 * de nodos que hay, incluyendose a si mismo.
	 * 
	 * @return numero de nodos que hay, incluyendose a si mismo.
	 * */
	public int numNodos() {
		int total = 1;
		for(INodo hijo: descendientes) {
			total += hijo.numNodos();
		}
		return total;
	}
}