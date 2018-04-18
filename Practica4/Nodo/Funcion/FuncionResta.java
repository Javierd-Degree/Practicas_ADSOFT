package Nodo.Funcion;

import Nodo.INodo;
import Nodo.Terminal;

/**
* Clase que implementa una Funcion resta n-aria, es decir,
* la funcion tiene n operandos, y resta al primero
* todos los demas.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class FuncionResta extends Funcion{
	
	/**
	 * Constructor por defecto de la clase FuncionResta.
	 * 
	 * @param nDescendientes Numero de operandos de la funcion.
	 */
	public FuncionResta(int nDescendientes) {
		super("-", nDescendientes);
	}
	/**
	 * Metodo que permite copiar una FuncionResta, copiando 
	 * tambien todos sus descendientes.
	 * 
	 * @return funcion copia de la instanciado.
	 */
	@Override
	public INodo copy() {
		INodo copia = new FuncionResta(this.getNumDescendientes());
		for(INodo nodo: this.descendientes) {
			copia.incluirDescendiente(nodo.copy());
		}
		
		return copia;
	}
	
	/**
	 * Metodo que nos permite calcular el valor numerico de
	 * una FuncionResta, teniendo en cuenta que hemos
	 * asignado un valor a Terminal. 
	 * 
	 * @return valor numerico de la Funcion.
	 * Si el Terminal no tiene establecido un valor, devolvemos
	 * 0.0 por defecto para evitar fallos en la aplicacion.
	 */
	@Override
	public double calcular() {
		if(Terminal.getvalor() == null) {
			return 0.0;
		}
		double a = this.getDescendientes().get(0).calcular();
		for(int i = 1; i < this.getDescendientes().size(); i++) {
			a -= this.getDescendientes().get(i).calcular(); 
		}
		return a;
	}

}
