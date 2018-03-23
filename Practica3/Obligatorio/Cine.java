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

public class Cine{
	/**
	* nombre: Nombre del cine.
	*/
	private String nombre;
	/**
	* direccion: Direccion del cine.
	*/
	private String direccion;
	/**
	* peliculas: Cartelera de peliculas del cine.
	*/
	private List<Pelicula> peliculas;
	/**
	* salas: Lista de salas del cine.
	*/
	private List<Sala> salas;
	/**
	* entradas: Entradas vendidas del cine.
	*/
	private List<Entrada> entradas;

	/** 
	 * Constructor de la clase cine sin listas ya que a estas se les va anadiendo elementos despues.
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
	* Comprobamos que los String de nombre y direccion no esten vacios.
	* @return boolean indicando si es o no valido.
	*/
	public boolean validar(){
		if(this.nombre == "" || this.direccion == ""){
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo que crea una Pelicula y, si no esta aun, y es valida, la anade al array 
	 * de peliculas del cine.
	 * @param titulo Titulo de la pelicula que se va a crear
	 * @param director Director de la pelicula
	 * @param anno Anno de estreno de la pelicula
	 * @param sinopsis Resumen de la pelicula
	 * @param genero Genero de la pelicula
	 * @return Pelicula creada o null si ya estaba insertada o si no era valida.
	 */
	public Pelicula crearPelicula(String titulo, String director, int anno, String sinopsis, Genero genero) {
		Pelicula pelicula = new Pelicula(titulo, director, anno, sinopsis, genero);
		if(pelicula.validar() == false) {
			return null;
		}
		
		if(this.peliculas.contains(pelicula)) {
			return null;
		}
		
		this.peliculas.add(pelicula);
		return pelicula;
	}
	
	/**
	 * Metodo que crea una nueva sala y la anade al cine,
	 * comprobando antes que la sala no existe ya, y que es valida.
	 * @param id Numero de identificacion de la sala
	 * @param butacas Numero de butacas de la sala
	 * @return Sala creada o null si ya estaba insertada o si no era valida.
	 */
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
	
	/**
	 * Metodo que crea una nueva sesion de una pelicula en el en la sala deseada del cine
	 * en la fecha introdicida como argumento,.
	 * @param sala Sala en la que se quiere anadir la sesion
	 * @param pelicula Pelicula para la que se quiere crear la sesion
	 * @param fechaSesion Fecha de la sesion que se quiere crear
	 * @return Sesion creada o null si no se ha podido crear o anadir correctamente a la sala, o si no es valida.
	 */
	public Sesion crearSesion(Sala sala, Pelicula pelicula, LocalDate fechaSesion) {
		Sesion sesion = new Sesion(fechaSesion, pelicula, sala, 0);
		if(sesion.validar() == false){
			return null;
		}
		return (sala.anadirSesion(sesion) == true) ? sesion : null;
	}
	
	/**
	 * Metodo que crea una entrada normal que se va a vender, la anade al array de entradas del
	 * cine y devuelve el un string con la informacion de la sesion y el precio de la entrada.
	 * @param precio Precio de la entrada
	 * @param sesion Sesion a la que corresponde la entrada
	 * @return String con la información de la sesion y el precio de la entrada.
	 */
	public String venderEntradas(double precio, Sesion sesion){
		Entrada e = new Entrada(precio);
		
		if(sesion.actualizarButacasVendidas(1)==true){
			this.entradas.add(e);
			return "Entradas para: " + sesion + " Precio: " + e.getPrecio();
		}
		
		return "Error en la venta.";
	}

	/**
	 * Metodo que crea una entrada del dia del espectador que se va a vender, la anade al array de entradas del
	 * cine y devuelve un string con la informacion de la sesion y el precio de la entrada.
	 * @param precio Precio de la entrada.
	 * @param descuento Descuento que se aplica a la venta de la entrada del dia del espectador.
	 * @param sesion Sesion a la que corresponde la entrada.
	 * @return String con la información de la sesion y el precio de la entrada.
	 */
	public String venderEntradas(double precio, double descuento, Sesion sesion){
		Entrada e = new EntradaDiaEspectador(precio, descuento);
		
		if(sesion.actualizarButacasVendidas(1)==true){
			this.entradas.add(e);
			return "Entradas dia del espectador para: " + sesion + " Precio: " + e.getPrecio();
		}
		
		return "Error en la venta.";
	}
	
	/**
	 * Metodo que crea varias entradas normales que se van a vender y las anade al array de entradas del
	 * cine y devuelve un string con la informacion de la sesion y el precio total de las entradas.
	 * @param numero Numero de entradas que se van a vender.
	 * @param precio Precio de cada una de las entradas.
	 * @param sesion Sesion a la que corresponden las entradas.
	 * @return String con la información de la sesion y el precio total de las entradas.
	 */
	public String venderEntradas(int numero, double precio, Sesion sesion){
		if(sesion.actualizarButacasVendidas(numero) == false) {
			return "Error en la venta.";
		}
		
		double total = 0;
		for(int i = 0; i < numero; i++) {
			Entrada e = new Entrada(precio);
			
			total += e.getPrecio();
			if (this.entradas.add(e) == false) {
				return "Error en la venta.";
			}
		}
		
		return numero + " Entradas para: " + sesion + " Precio: " + total;
	}

	/**
	 * Metodo que crea varias entradas del dia del espectador que se van a vender y las
	 * anade al array de entradas del cine y devuelve un string con la informacion de la 
	 * sesion y el precio total de las entradas.
	 * @param numero Numero de entradas que se van a vender.
	 * @param precio Precio de cada una de las entradas.
	 * @param descuento Descuento que se aplica a la venta de las entradas del dia del espectador.
	 * @param sesion Sesion a la que corresponden las entradas.
	 * @return String con la información de la sesion y el precio total de las entradas.
	 */
	public String venderEntradas(int numero, double precio, double descuento, Sesion sesion){
		if(sesion.actualizarButacasVendidas(numero) == false) {
			return "Error en la venta.";
		}
		
		double total = 0;
		for(int i = 0; i < numero; i++) {
			Entrada e = new EntradaDiaEspectador(precio, descuento);
			
			total += e.getPrecio();
			if (this.entradas.add(e) == false) {
				return "Error en la venta.";
			}
		}
		
		return numero + " Entradas dia del espectador para: " + sesion + " Precio: " + total;
	}
	
	/**
	 * Metodo que calcula la recaudacion total del cine a partir de las 
	 * entradas vendidas teniendo en cuenta que el campo entradas del 
	 * cine es un array de las entradas vendidas, y redondeando la 
	 * recaudacion a 2 decimales
	 * @return Recaudacion total del cine
	 */
	public double recaudacion(){
		double rec = 0;
		for(Entrada entrada : this.entradas){
			rec += entrada.getPrecio();
		}
		return (double) Math.round(rec * 100) / 100;
	}


	/**
	 * Metodo que quita una determinada pelicula del array de peliculas del cine,
	 * eliminando tambien todas las sesiones de dicha pelicula.
	 * @param pelicula Pelicula que se va a quitar de la cartelera
	 * @return boolean que indica si la pelicula se ha eliminado correctamente o no
	 */
	public boolean quitarPeliculaCine(Pelicula pelicula){
		/*Quitamos la pelicula de la cartelera*/
		if(this.peliculas.contains(pelicula)) {
			this.peliculas.remove(pelicula);
		}else {
			return false;
		}
		
		/*Quitamos las sesiones en las que aparece dicha pelicula*/
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

	/**
	 * Metodo que devuelve una string con la informacion del cine
	 * @return String con la informacion del cine
	 */
	public String toString() {
		if(this.validar() == true) {
			return "Cine " + nombre + " en la dirección " + direccion + "\n";
		}
		return "\tEl cine no es válido.";
	}
	
	/**
	 * Metodo que devuelve una string con la cartelera (Array de peliculas) del cine
	 * @return String con las peliculas de la cartelera del cine
	 */
	public String infoCartelera(){
		String text = "Cartelera del cine " + nombre + ", " + direccion + ":\n";
		for(Pelicula pelicula : this.peliculas){
			text += pelicula + "\n\n";
		}
		return text;
	}

	/**
	 * Metodo que devuelve una string con los datos de todas las sesiones del cine
	 * @return String con los datos de las sesiones del cine
	 */
	public String infoSesiones(){
		String text = "Sesiones del cine " + nombre + ", " + direccion + ":\n\t";
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones()) {
				text += sesion + "\n\t";
			}
		}
		return text;
	}

	/**
	 * Metodo que devuelve una string con la informacion de todas las sesiones del cine
	 * de una determinada pelicula
	 * @param pelicula Pelicula a la que corresponden las sesiones 
	 * @return String con la informacion de las sesiones
	 */
	public String infoSesionesPelicula(Pelicula pelicula){
		String text = "Sesiones en el cine " + nombre + ", " + direccion + 
				", de la película " + pelicula.getTitulo() + "\n\t";
		for(Sala sala : this.salas){
			for(Sesion sesion : sala.getSesiones()){
				if(pelicula.equals(sesion.getPelicula())){
					text += sesion + "\n\t";
				}
			}
		}
		return text;
	}
}




	