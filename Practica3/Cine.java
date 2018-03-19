import java.util.*;
import java.time.LocalDate;

/**
 * Esta clase implementa un cine.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
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
	/*TODO comprobar en las funciones necesarias que las salas, pelis... est�n en los arrays del cine*/
	/*TODO poner los params y returns para javadoc*/
	/*Creamos una pelicula y la a�adimos a la lista de pel�culas del cine*/
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
	
	/*Crea una sala y la a�ade a la lista de salas*/
	public void crearSala(int id, int butacas) {
		Sala sala = new Sala(id, butacas);
		this.salas.add(sala);
	}
	
	/*Crea una sesi�n con una pel�cula del array de pel�culas en la fecha dad y la a�ade a la sala dada*/
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
		double rec=0;
		for(Entrada entrada : this.entradas){
			rec += entrada.getPrecio();
		}
		return rec;
	}


	/* Quita una pel�cula del array de pel�culas del cine*/
	public boolean removePeliculaCartelera(Pelicula pelicula){
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

	/*Imprime la lista de pel�cilas del cine*/
	public void infoCartelera(){
		for(Pelicula pelicula : this.peliculas){
			System.out.println(pelicula + "\n");
		}
	}

	/*Imprime la informaci�n de todas las sesiones del cine*/
	public void infoSesiones(){
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones())
				System.out.println(sesion + "\n");
		}
	}

	/*Imprime la informaci�n de todas las sesiones para una determinada pel�cula*/
	public void infoPeliculaFecha(Pelicula pelicula){
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones()){
				if(pelicula.equals(sesion.getPelicula())){
					System.out.println(sesion + "\n");
				}
			}
		}
	}
}




	