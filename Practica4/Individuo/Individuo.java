package Individuo;

import java.util.List;

import Nodo.Funcion.Funcion;
import Nodo.INodo;
import Nodo.Terminal;

/**
* Clase Individuo que implementa la interfaz IIndividuo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class Individuo implements IIndividuo{
	/**
	 * @param expresion Expresion del Individuo.
	 */
	private INodo expresion;
	
	/**
	 * @param fitness Nivel de fitness del individuo.
	 */
	public double fitness = 0;
	
	/**
	 * Metodo que devuelve un INodo que es la expresion
	 * del IIndividuo.
	 * @return raiz del IIndividuo.
	 */
	@Override
	public INodo getExpresion() {
		return this.expresion;
	}

	/**
	 * Metodo que establece la expresion del IIndividuo.
	 * @param expresion INodo a establecer como expresion
	 * del IIndividuo.
	 */
	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
		
	}

	/**
	 * Metodo que devuelve el fitness de un IIndividuo.
	 * @return fitness del IIndividuo.
	 */
	@Override
	public double getFitness() {
		return this.fitness;
	}

	/**
	 * Setter del fitness de un IIndividuo.
	 * @param fitness del IIndividuo.
	 */
	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
		
	}

	/**
	 * Metodo que nos permite crear un individuo aleatorio dadas
	 * una lista de Terminales y otra de Funciones, ademas de una
	 * profundidad para el arbol.
	 * 
	 * @param profundidad profundidad para el arbol de la expresion.
	 * @param terminales Lista de terminales entre las que elegir.
	 * @param funciones Lista de funciones entre las que elegir.
	 */
	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo que calcula la expresion de un IIndividuo.
	 * Si no se ha esablecido el valor de Terminal, devuelve 0.0.
	 * 
	 * @return evaluacon numerica de la expresion del
	 * IIndividuo. Si no se ha esablecido el valor de 
	 * Terminal, devuelve 0.0.
	 */
	@Override
	public double calcularExpresion() {
		if(Terminal.getvalor() == null) {
			System.out.println("Es necesrio establecer un valor numerico en el terminal");
			return 0.0;
		}
		return expresion.calcular();
	}

	/**
	 * Metodo que devuelve el numero total de nodos de una expresion.
	 * @return numero total de nodos de la expresion.
	 */
	@Override
	public int getNumeroNodos() {
		if(expresion == null) {
			return 0;
		}
		return expresion.numNodos();
	}

	/**
	 * Metodo que imprime por pantalla la expresion del IIndividuo.
	 */
	@Override
	public void writeIndividuo() {
		System.out.println(expresion);
	}
	
	/**
	 * Metodo que permite etiquetar el nodo raiz Nodo y todos sus descendientes, con
	 * enteros del cero al numero total de nodos menos 1.
	 */
	public void etiquetaNodos() {
		this.expresion.etiquetaNodos();
	}

}
