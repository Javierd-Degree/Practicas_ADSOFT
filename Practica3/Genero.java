/**
* Enumeracion con los tipos de peliculas disponibles
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public enum Genero{
	CIENCIA_FICCION("Ciencia ficcion"), TERROR("Terror"), 
	ROMANCE("Romance"), DRAMA("Drama"), COMEDIA("Comedia"), 
	WESTERN("Westerm"), SUSPENSE("Suspense"),
	EPOCA("Epoca"), ACCION("Accion"), DIBUJOS("Dibujos animados");

	Genero(String n){nombre = n;}

	private final String nombre;
	
	/**
	 * Metodo que devuelve una string con el nombre del genero
	 * @return String con el nombre del genero
	 */
	public String toString() {
		return nombre;
	}
}