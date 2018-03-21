/**
* Clase que implementa la entrada del dia del espectador de una pelicula
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class EntradaDiaEspectador extends Entrada{
	private double descuento;

	/**
	* Constructor de la clase EntradaDiaEspectador.
	* @param precio Precio de la entrada a crear. 
	* @param descuento Descuento de la entrada a crear, dado como un numero entre 0 y 1.
	*/
	public EntradaDiaEspectador(double precio, double descuento){
		super(precio);
		this.descuento = descuento;
	}

	/**
	* Getter del precio de la entrada, incluyendo el descuento por ser el dia del espectador.
	* Redondeamos con dos cifras decimales
	* @return Precio de la entrada con descuento.
	*/
	public double getPrecio(){
		double precio = super.getPrecio() * (1 - this.descuento);
		return (double) Math.round(precio * 100) / 100;
	}
}