package Nodo;

/**
* Clase que implementa un TerminalAritmetico que hereda de Terminal.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/


public class TerminalAritmetico extends Terminal{

	/**
	 * Constructor por defecto de la clase TerminalAritmetico.
	 * 
	 * @param simbolo Simbolo que queremos que tenga el terminal aritmetico.
	 */
	public TerminalAritmetico(Object simbolo) {
		super(simbolo);
	}
	
	/**
	 * Metodo que permite copiar un TerminalAritmetico.
	 * 
	 * @return TerminalAritmetico copia del instanciado.
	 */
	@Override
	public INodo copy() {
		INodo copia = new TerminalAritmetico(simbolo);
		
		return copia;
	}
	
	/**
	 * Metodo que permite obtener el valor del TerminalAritmetico.
	 * 
	 * @return valor del terminal.
	 */
	@Override
	public Double calcular() {
		return (Double) Terminal.getvalor();
	}
}
