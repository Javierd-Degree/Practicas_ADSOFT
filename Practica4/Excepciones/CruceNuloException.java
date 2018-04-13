package Excepciones;

/**
* Excepcion usada para evitar que se eligan los dos nodos
* iniciales como nodos de un cruce.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/


public class CruceNuloException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Metodo que devuelve informacion de la excepcion.
	 * @return String con la informacion de la excepcion.
	 */
	@Override
	public String toString() {
		return "No se pueden cruzar los nodos iniciales "
				+ "de ambas funciones";
	}

}
