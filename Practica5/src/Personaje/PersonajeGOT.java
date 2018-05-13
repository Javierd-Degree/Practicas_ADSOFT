package Personaje;

/**
* Clase que implementa un personaje de juego de tronos con su nombre y su casa..
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class PersonajeGOT {
	/**
	 * @param nombre String con el nombre del personaje.
	 */
	private String nombre;
	
	/**
	 * @param casa String con el nombre de la casa del personaje.
	 */
	private String casa;
	
	/**
	 * Constructor del PersonajeGOT que anade el nombre y la casa a este.
	 * @param nombre String con el nombre del personaje.
	 * @param casa String con el nombre de la casa del personaje.
	 */
	public PersonajeGOT(String nombre, String casa) {
		this.nombre = nombre;
		this.casa = casa;
	}
	
	/**
	 * Getter del nombre del personaje.
	 * @return String con el nombre del personaje.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Getter de la casa del personaje.
	 * @return String con el nombre de la casa del personaje.
	 */
	public String getCasa() {
		return casa;
	}
	
	/**
	 * Funcion que crea un String con los datos del personaje.
	 * @return String con el nombre y la casa del personaje.
	 */
	@Override 
	public String toString() {
		return nombre+", de la casa "+casa;
	}
	
	/**
	 * Funcion que compara 2 persoanjes ara ver si son el mismo.
	 * @return boolean que indica si los personajes son los mismos o no.
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof PersonajeGOT)) {
			return false;
		}
		
		PersonajeGOT p = (PersonajeGOT) o;
		return p.casa.equals(this.casa) && p.nombre.equals(this.nombre);
	}
}
