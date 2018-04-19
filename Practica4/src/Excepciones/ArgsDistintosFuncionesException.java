package Excepciones;

/**
* Excepcion usada para asegurar la integridad
* de la funcion definirConjuntoFunciones en un IDominio.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class ArgsDistintosFuncionesException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Metodo que devuelve informacion de la excepcion.
	 * @return String con la informacion de la excepcion.
	 */
	@Override
	public String toString() {
		return "Error de argumentos que aun no se que hace.";
	}

}
