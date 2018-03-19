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
 * TODO Cambiar funciones info que imprimen por un String, con return
 * Getters para devolver todas las películas y/o poder buscar por titulo.
 * de la pelicula, por ejemplo.
 */

public class Cine{
	private String nombre;
	private String direccion;
	private List<Pelicula> peliculas;
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
		this.peliculas = new ArrayList<Pelicula>();
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
	public boolean crearPelicula(String titulo, String director, int anno, String sinopsis, Genero genero) {
		Pelicula pelicula = new Pelicula(titulo, director, anno, sinopsis, genero);
		if(pelicula.validar() == false) {
			return false;
		}
		
		for(Pelicula p  : this.peliculas){
			if(p.equals(pelicula)) {
				return false;
			}
		}
		this.peliculas.add(pelicula);
		return true;
	}
	
	/*Crea una sala y la añade a la lista de salas. Comprobamos si esta o no añadida*/
	public boolean crearSala(int id, int butacas) {
		Sala sala = new Sala(id, butacas);
		if(sala.validar() == false) {
			return false;
		}
		
		for(Sala s: this.salas) {
			if(s.equals(sala)) {
				return false;
			}
		}
		this.salas.add(sala);
		return true;
	}
	
	/* TODO ¿No es mejor llamarlo crearSesion?
	 * Crea una sesión con una película del array de películas en la fecha dad y la añade a la sala dada*/
	public boolean anadirPeliculaSala(Sala sala, Pelicula pelicula, LocalDate fechaSesion) {
		Sesion sesion = new Sesion(fechaSesion, pelicula, sala, 0);
		if(sesion.validar() == false){
			return false;
		}
		return sala.anadirSesion(sesion);
	}

	/*Vender 1 entrada*/
	/*TODO ver si creamos las entradas dentro*/
	public double venderEntradas(Entrada entrada, Sesion sesion){
		if(sesion.actualizarButacasVendidas(1)==true){
			this.entradas.add(entrada);
			System.out.println(sesion);
			return entrada.getPrecio();
		}
		return -1;
	}
	
	/*Vender varias entradas*/
	/*TODO ver si creamos las entradas dentro*/
	public double venderEntradas(List<Entrada> entradas, Sesion sesion){
		int precio = 0;
		if(sesion.actualizarButacasVendidas(entradas.size())==true){
			System.out.println(sesion);
			for(Entrada entrada : entradas) {
				this.entradas.add(entrada);
				precio += entrada.getPrecio();
			}
			return precio;
		}
		return -1;
	}

	/*El campo entrada de Cine indica las entradas vendidas*/
	public double recaudacion(){
		double rec = 0;
		for(Entrada entrada : this.entradas){
			rec += entrada.getPrecio();
		}
		return rec;
	}


	/* Quita una película del array de películas del cine*/
	public boolean quitarPeliculaCartelera(Pelicula pelicula){
		for(Pelicula p : this.peliculas){
			if(pelicula.equals(p)){
				this.peliculas.remove(p);
				break;
			}
		}
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones()){
				if(pelicula.equals(sesion.getPelicula())){
					sala.getSesiones().remove(sesion);
				}
			}
		}
		return true;
	}

	public String toString() {
		return "Cine " + nombre + " en la dirección " + direccion + "\n";
	}
	
	/*Imprime la lista de películas del cine*/
	public String infoCartelera(){
		String text = "Cartelera del cine " + nombre + ", " + direccion + "\n";
		for(Pelicula pelicula : this.peliculas){
			text += pelicula + "\n";
		}
		return text;
	}

	/*Imprime la información de todas las sesiones del cine*/
	public String infoSesiones(){
		String text = "Sesiones del cine " + nombre + ", " + direccion + "\n";
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones())
				text += sesion;
		}
		return text;
	}

	/*Imprime la información de todas las sesiones para una determinada película*/
	public String infoSesionesPelicula(Pelicula pelicula){
		String text = "Sesiones en el cine " + nombre + ", " + direccion + 
				"de la película " + pelicula.getTitulo() + "\n";
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones()){
				if(pelicula.equals(sesion.getPelicula())){
					text += sesion;
				}
			}
		}
		return text;
	}
}




	