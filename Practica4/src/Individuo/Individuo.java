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
	 * Metodo privado que nos permite generar un numero aleatorio en un intervalo
	 * cerrado [min, max]
	 * 
	 * @param min Numero aleatorio minimo.
	 * @param max Numero aleatorio maximo.
	 * @return int con un numero aleatorio entre min y max, ambos incluidos.
	 */
	public static int aleatNum(int min, int max) {
		return min + (int)(Math.random() * (max-min+1));
	}
	
	/**
	 * Metodo que nos permite crear un individuo aleatorio dadas
	 * una lista de Terminales y otra de Funciones, ademas de una
	 * profundidad para el arbol.
	 * 
	 * Aunque no se especifica en el enuncido, las funciones
	 * pueden tener cualquier numero de argumentos, de forma
	 * que la clase es lo mas general posible.
	 * 
	 * @param profundidad profundidad para el arbol de la expresion.
	 * @param terminales Lista de terminales entre las que elegir.
	 * @param funciones Lista de funciones entre las que elegir.
	 */
	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		this.expresion = crearRecursivo(profundidad, terminales, funciones);
	}
	
	public INodo crearRecursivo(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		INodo nodo;
		if(profundidad == 0) {
			/* Solo un terminal*/
			nodo = terminales.get(aleatNum(0, terminales.size()-1)).copy();
			return nodo;
		}
		
		/*Si no, una funcion con los parametros que necesite.*/
		Funcion funcion = funciones.get(aleatNum(0, funciones.size()-1));
		nodo = funcion.copy();
		/*Permitimos que uno de los descendientes pueda tener una profundidad menor, 
		 * mejorando asi la aleatoriedad del algoritmo. */
		nodo.incluirDescendiente(crearRecursivo(aleatNum(0, profundidad - 1), terminales, funciones));
		for(int i = 1; i < funcion.getNumDescendientes(); i++) {
			nodo.incluirDescendiente(crearRecursivo(profundidad - 1, terminales, funciones));
		}
		return nodo;
	}

	/**
	 * Metodo que calcula la expresion de un IIndividuo.
	 * Si no se ha esablecido el valor de Terminal, devuelve null.
	 * 
	 * @return evaluacion numerica de la expresion del
	 * IIndividuo. Si no se ha esablecido el valor de 
	 * Terminal, devuelve null.
	 */
	@Override
	public Object calcularExpresion() {
		if(Terminal.getvalor() == null) {
			System.out.println("Es necesrio establecer un valor numerico en el terminal");
			return null;
		}
		return this.expresion.calcular();
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
