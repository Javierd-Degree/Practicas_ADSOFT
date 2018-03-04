/**
* Clase que implementa la sesion de una pelicula
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

/*TODO ¿Añadir la pelicula de la que es la entrada?*/

public class Entrada{
	double precio;

	/**
	* Constructor de la clase Entrada.
	* @param precio Precio de la entrada a crear. 
	*/
	public Entrada(double precio){
		this.precio = precio;
	}

	/**
	* Getter del precio de la entrada.
	* @return Precio de la entrada.
	*/
	public double getPrecio(){
		return this.precio;
	}
}