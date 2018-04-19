package Nodo.Funcion;

import Nodo.INodo;
import Nodo.Nodo;

/**
* Clase abstracta Funcion que hereda de Nodo e implementa
* una operacion matematica.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public abstract class Funcion extends Nodo{
	/**
	 * @param nDescencientes Numero de operandos que tiene
	 * la operacion.
	 */
	private int nDescendientes;
	
	/**
	 * Constructor por defecto de la clase Funcion.
	 * 
	 * @param simbolo Simbolo de la Funcion(Ej +, -)
	 * @param nDescendientes Numero de operandos de la Funcion.
	 */
	public Funcion(Object simbolo, int nDescendientes) {
		super(simbolo);
		this.nDescendientes = nDescendientes;
	}
	
	/**
	 * Getter del numero de descendientes de una funcion.
	 * @return numero de descencientes que tiene la funcion.
	 */
	public int getNumDescendientes() {
		return this.nDescendientes;
	}
	
	/**
	 * Metodo que permite anadir un descendiente mas a la Funcion.
	 * 
	 * @param nodo Operando a anadir.
	 */
	@Override
	public void incluirDescendiente(INodo nodo) {
		if(this.descendientes.size() == nDescendientes) {
			return;
		}
		
		this.descendientes.add(nodo);
	}
	
	/**
	 * Metodo que devuelve un String que representa a la Funcion,
	 * con sus descendientes, en modo prefijo.
	 * 
	 * @return String que describe la Funcion.
	 */
	@Override
	public String toString() {
		String result = "( "+this.simbolo+" ";
		for(INodo nodo: this.descendientes) {
			result += nodo;
		}
		return result + ") ";
	}
}
