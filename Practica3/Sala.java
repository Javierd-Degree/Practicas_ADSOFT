/**
 * Esta clase implementa una sala de un cine.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class Sala{
	private int id;
	private int butacas;
	private List<Sesion> sesiones;

	/** 
	 * TODO Mirar si se utiliza y si no borrar.
	 * Constructor completo
   	 * @param id Numero de identificacion de la sala.
   	 * @param butacas Numero de butacas en la sala.
   	 * @param sesiones Lista de las sesiones que se dan en la sala.
   	 */
	public Sala(int id, int butacas, List<Sesion> sesiones){
		this.id = id;
		this.butacas = butacas;
		this.sesiones = new ArrayList<Sesion>();
		this.sesiones.addAll(sesiones);
	}

	/** 
	 * Constructor sin sesiones, las sesiones se añaden posteriormente.
   	 * @param id Numero de identificacion de la sala.
   	 * @param butacas Numero de butacas en la sala.
   	 */
	public Sala(int id, int butacas){
		this.id = id;
		this.butacas = butacas;
		this.sesiones = new ArrayList<Sesion>();
	}




	/** 
	 * Getter del numero de identificacion de la sala.
   	 * @return Numero de identificacion de la sala.
   	 */
	public int getId(){
		return this.id;
	}

	/** 
	 * Getter del numero de butacas de la sala.
   	 * @return Numero de butacas en la sala.
   	 */
	public int getButacas(){
		return this.butacas;
	}

	/** 
	 * Getter de las sesiones que se emiten en la sala.
   	 * @return Lista de sesiones que se emiten en la sala.
   	 */
	public List<Sesion> getSesiones(){
		return this.sesiones;
	}


	/** 
	 * Setter del numero de butacas de la sala.
   	 * @param butacas Numero de buatacas de la sala.
   	 */
	public void setButacas(int butacas){
		this.butacas = butacas;
	}






	/** 
	 * Añade una sesión a la lista de sesiones de la sala.
   	 * @param sesion Sesion que se quiere añadir a la lita de sesiones de la sala.
   	 * @return Boolean que indica si se ha podido o no añadir la sesión a la lista comprobando las fechas.
   	 */
	public Boolean anadirSesion(Sesion sesion){
		for(Sesion ses : this.sesiones){
			if(ses.getFecha().equals(sesion.getFecha())) return false;
		}
		this.sesiones.add(sesion);
		return true;
	}

	/** 
	 * TODO Borrar si no es necesario.
	 * Añade una lista de sesiones a la lista de sesiones de la sala.
   	 * @param sesiones Lista de las sesiones que se quieren añadir a la lista.
   	 * @return int con el número de sesiones de la lista que se han podido añadir correctamente (teniendo en cuenta que no pueden coincidir fechas).
   	 */
	public int anadirListaSesiones(List<Sesion> sesiones){
		int n = 0;

		for(Sesion sesion : sesiones){
			if(this.sesiones.añadirSesion(sesion) == true) n++;
		}
		return n;
	}

	





	/** 
	 * Crea un string con los datos de la pelicula.
   	 * @return Un string con todos los datos de la pelicula.
   	 */
	public String toString(){
		return "\n\tTítulo: " + this.titulo + "\n\tDirector: " + this.director + "\n\tAño de salida: " + this.anno + "\n\tSinopsis: " + this.sinopsis + "\n\tGénero: " + this.genero;
	}
}

