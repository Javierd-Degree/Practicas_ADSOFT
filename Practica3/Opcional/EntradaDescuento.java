/**
* Clase que implementa la entrada del dia del espectador de una pelicula
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class EntradaDescuento extends Entrada{
	private Descuento descuento;

	/**
	* Constructor de la clase EntradaDescuento.
	* @param precio Precio de la entrada a crear. 
	* @param descuento Descuento de la entrada a crear.
	*/
	public EntradaDescuento(double precio, Descuento descuento){
		super(precio);
		this.descuento = descuento;
	}

	/**
	* Getter del precio de la entrada, incluyendo el descuento.
	* Redondeamos con dos cifras decimales
	* @return Precio de la entrada con descuento.
	*/
	public double getPrecio(){
		double precio = super.getPrecio() * (1 - this.descuento.getValor());
		return (double) Math.round(precio * 100) / 100;
	}
}