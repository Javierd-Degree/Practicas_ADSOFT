import java.util.List;
import java.util.ArrayList;

/**
* Clase que implementa la cartelera (collecion de peliculas) de un cine.
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/


public class Cartelera {
	/**
	* peliculas: Lista de peliculas de la cartelera.
	*/
	private List<Pelicula> peliculas;
	
	/**
	* Constructor de la clase Cartelera
	*/
	public Cartelera() {
		peliculas = new ArrayList<>();
	}
	
	/**
	* Metodo que permite anadir una pelicula a la cartelera, tras comprobar
	* que no esta introducida.
	* @param p Pelicula que se va a anadir
	* @return boolean false si se ha anadido previamente, true si no.
	*/
	public boolean anadirPelicula(Pelicula p) {
		if(this.peliculas.contains(p)) {
			return false;
		}
		
		this.peliculas.add(p);
		return true;
	}
	
	/**
	* Metodo que permite quitar una pelicula a la cartelera, tras comprobar
	* que esta introducida.
	* @param p Pelicula que se va a quitar.
	* @return boolean false no estaba anadida, true si se elimina correctamente.
	*/
	public boolean quitarPelicula(Pelicula p) {
		if(this.peliculas.contains(p)) {
			this.peliculas.remove(p);
			return true;
		}
		return false;
	}
	
	/** 
	 * Crea un string con los datos de la cartelera, incluyendo los
	 * titulos de todas las peliculas.
   	 * @return Un string con todos los datos de la cartelera.
   	 */
	public String toString() {
		String text = "";
		for(Pelicula pelicula : this.peliculas){
			text += pelicula + "\n\n";
		}
		return text;
	}
}
