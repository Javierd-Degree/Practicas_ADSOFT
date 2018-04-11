package Nodo;

/**
* Clase que implementa un Terminal que hereda de Nodo.
* Dicho terminal tiene una variable estatica, de forma
* que modificando dicha variable, y llamando a calcular
* de un individuo, podemos obtener el valor que tendria 
* dicho individuo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public abstract class Terminal extends Nodo{
	/**
	 * @param valor Variable estatica que nos permite realizar operaciones
	 * con numeros reales, ademas de trabajar con expresiones simbolicas.
	 */
	private static Double valor;
	
	/**
	 * Constructor por defecto de la clase Terminal.
	 * 
	 * @param simbolo Simbolo que queremos que tenga el terminal.
	 */
	public Terminal(Object simbolo) {
		super(simbolo);
	}

	/**
	 * Metodo que permite modificar el valor de la variable estatica valor.
	 * 
	 * @param valor Nuevo valor a establecer.
	 */
	public static void setValor(double valor) {
		Terminal.valor = valor;
	}
	
	
	/**
	 * Metodo que permite obtener el valor del Terminal.
	 * 
	 * @return valor del terminal.
	 */
	@Override
	public double calcular() {
		return valor;
	}
	
	/**
	 * Metodo que devuelve el valor del Terminal.
	 * Funciona igual que el metodo calcular, pero al ser
	 * estatico no es necesario tener un objeto terminal para
	 * llamarlo.
	 * El metodo calcular no podia ser estatico porque no estaba
	 * definido asi en la interfaz INodo.
	 * 
	 * @return valor del terminal.
	 */
	public static Double getvalor() {
		return valor;
	}
	
	/**
	 * Metodo que impide anadir un descenciente a un Terminal.
	 * A pesar de heredar de Nodo, los terminales, no pueden
	 * tener descendientes, por lo que sobreescribimos la 
	 * funcion para evitarlo.
	 * 
	 * @param nodo INodo descenciente a anadir. No se va a
	 * anadir.
	 */
	@Override
	public void incluirDescendiente(INodo nodo) {
		return;
	}
}
