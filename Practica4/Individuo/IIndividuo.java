package Individuo;

import Nodo.INodo;
import Nodo.Terminal;
import Nodo.Funcion.Funcion;

import java.util.List;

/**
* Interfaz dada con las operaciones necesarias de un IIndividuo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public interface IIndividuo {
	/**
	 * Metodo que devuelve un INodo que es la expresion
	 * del IIndividuo.
	 * @return raiz del IIndividuo.
	 */
	public INodo getExpresion();
	
	/**
	 * Metodo que establece la expresion del IIndividuo.
	 * @param expresion INodo a establecer como expresion
	 * del IIndividuo.
	 */
	public void setExpresion(INodo expresion);
	
	/**
	 * Metodo que devuelve el fitness de un IIndividuo.
	 * @return fitness del IIndividuo.
	 */
	public double getFitness();
	
	/**
	 * Setter del fitness de un IIndividuo.
	 * @param fitness del IIndividuo.
	 */
	public void setFitness(double fitness);
	
	/**
	 * Metodo que nos permite crear un individuo aleatorio dadas
	 * una lista de Terminales y otra de Funciones, ademas de una
	 * profundidad para el arbol.
	 * 
	 * @param profundidad profundidad para el arbol de la expresion.
	 * @param terminales Lista de terminales entre las que elegir.
	 * @param funciones Lista de funciones entre las que elegir.
	 */
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
	
	/**
	 * Metodo que calcula la expresion de un IIndividuo.
	 * Si no se ha esablecido el valor de Terminal, devuelve 0.0.
	 * 
	 * @return evaluacon numerica de la expresion del
	 * IIndividuo. Si no se ha esablecido el valor de 
	 * Terminal, devuelve 0.0.
	 */
	public double calcularExpresion();
	
	/**
	 * Metodo que devuelve el numero total de nodos de una expresion.
	 * @return numero total de nodos de la expresion.
	 */
	public int getNumeroNodos();
	
	/**
	 * Metodo que imprime por pantalla la expresion del IIndividuo.
	 */
	public void writeIndividuo();
}