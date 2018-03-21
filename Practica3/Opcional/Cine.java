import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Esta clase implementa un cine.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

/**
 * Getters para devolver todas las películas y/o poder buscar por titulo.
 * de la pelicula, por ejemplo.
 */

public class Cine{
	private String nombre;
	private String direccion;
	private Cartelera cartelera;
	private List<Sala> salas;
	private List<Entrada> entradas;

	/** 
	 * Constructor sin listas ya que a estas se ls va añadiendo elementos despues.
   	 * @param nombre Nombre del cine.
   	 * @param direccion Direccion del cine.
   	 */
	public Cine(String nombre, String direccion){
		this.nombre = nombre;
		this.direccion = direccion;
		this.cartelera = new Cartelera();
		this.salas = new ArrayList<Sala>();
		this.entradas = new ArrayList<Entrada>();
	}
	
	/**
	* Valida si los datos del cine son o no correctos. 
	* Comprobamos que los String de nombre y dirección no estén vacíos.
	* @retun boolean indicando si es o no valido.
	*/
	public boolean validar(){
		if(this.nombre == "" || this.direccion == ""){
			return false;
		}
		return true;
	}
	
	/*TODO comprobar en las funciones necesarias que las salas, pelis... est�n en los arrays del cine*/
	/*TODO poner los params y returns para javadoc*/
	/*Creamos una pelicula y la añadimos a la lista de películas del cine*/
	public Pelicula crearPelicula(String titulo, String director, int anno, String sinopsis, Genero genero) {
		Pelicula pelicula = new Pelicula(titulo, director, anno, sinopsis, genero);
		if(pelicula.validar() == false) {
			return null;
		}
		
		if(this.cartelera.anadirPelicula(pelicula) == false) {
			return null;
		}
		
		return pelicula;
	}
	
	/*Crea una sala y la añade a la lista de salas. Comprobamos si esta o no añadida*/
	public Sala crearSala(int id, int butacas) {
		Sala sala = new Sala(id, butacas);
		if(sala.validar() == false) {
			return null;
		}
		
		if(this.salas.contains(sala)) {
			return null;
		}
		
		this.salas.add(sala);
		return sala;
	}
	
	/* Crea una sesión con una película del array de películas en la fecha dad y la añade a la sala dada*/
	public Sesion crearSesion(Sala sala, Pelicula pelicula, LocalDate fechaSesion) {
		Sesion sesion = new Sesion(fechaSesion, pelicula, sala, 0);
		if(sesion.validar() == false){
			return null;
		}
		return (sala.anadirSesion(sesion) == true) ? sesion : null;
	}
	
	/*Crea una entrada normal*/
	public double venderEntradas(double precio, Sesion sesion){
		Entrada e;
		e = new Entrada(precio);
		
		if(sesion.actualizarButacasVendidas(1)==true){
			this.entradas.add(e);
			return e.getPrecio();
		}
		
		return -1;
	}
	
	/*Crea una entrada del dia del espectador*/
	public double venderEntradas(double precio, Descuento descuento, Sesion sesion){
		Entrada e;
		
		e = new EntradaDescuento(precio, descuento);
		
		if(sesion.actualizarButacasVendidas(1)==true){
			this.entradas.add(e);
			return e.getPrecio();
		}
		
		return -1;
	}
	
	/*Crea una serie de entradas normales*/
	public double venderEntradas(int numero, double precio, Sesion sesion){
		if(sesion.actualizarButacasVendidas(numero) == false) {
			return -1;
		}
		
		double total = 0;
		for(int i = 0; i < numero; i++) {
			Entrada e = new Entrada(precio);
			
			total += e.getPrecio();
			if (this.entradas.add(e) == false) {
				return -1;
			}
		}
		
		return (double) Math.round(total * 100) / 100;
	}
	
	/*Crea una serie de entradas normales o del dia del espectador*/
	public double venderEntradas(int numero, double precio, Descuento descuento, Sesion sesion){
		if(sesion.actualizarButacasVendidas(numero) == false) {
			return -1;
		}
		
		double total = 0;
		for(int i = 0; i < numero; i++) {
			Entrada e = new EntradaDescuento(precio, descuento);
			
			total += e.getPrecio();
			if (this.entradas.add(e) == false) {
				return -1;
			}
		}
		
		return (double) Math.round(total * 100) / 100;
	}

	/*El campo entrada de Cine indica las entradas vendidas
	 * Redondeamos a dos cifras decimales*/
	public double recaudacion(){
		double rec = 0;
		for(Entrada entrada : this.entradas){
			rec += entrada.getPrecio();
		}
		return (double) Math.round(rec * 100) / 100;
	}


	/* Quita una película del array de películas del cine*/
	public boolean quitarPeliculaCine(Pelicula pelicula){
		/*Quitamos la película de la cartelera*/
		if(this.cartelera.quitarPelicula(pelicula) == false) {
			return false;
		}
		
		/*Quitamos las sesiones en las que aparece dicha película*/
		boolean result = true;
		for(Sala sala : this.salas){
			List<Sesion> temp = new ArrayList<>();
			for(Sesion sesion : sala.getSesiones()){
				if(pelicula.equals(sesion.getPelicula())){
					temp.add(sesion);
				}
			}
			result = result && sala.getSesiones().removeAll(temp);
		}
		return result;
	}

	public String toString() {
		return "Cine " + nombre + " en la dirección " + direccion + "\n";
	}
	
	/*Imprime la lista de películas del cine*/
	public String infoCartelera(){
		return "Cartelera del cine " + nombre + ", " + direccion + ":\n" + this.cartelera;
	}

	/*Imprime la información de todas las sesiones del cine*/
	public String infoSesiones(){
		String text = "Sesiones del cine " + nombre + ", " + direccion + ":\n";
		for(Sala sala : this.salas){
			text += "\t";
			for(Sesion sesion : sala.getSesiones()) {
				text += sesion + "\n\t";
			}
		}
		return text;
	}

	/*Imprime la información de todas las sesiones para una determinada película*/
	public String infoSesionesPelicula(Pelicula pelicula){
		String text = "Sesiones en el cine " + nombre + ", " + direccion + 
				", de la película " + pelicula.getTitulo() + "\n";
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones()){
				if(pelicula.equals(sesion.getPelicula())){
					text += "\t" + sesion;
				}
			}
		}
		return text;
	}
}




	