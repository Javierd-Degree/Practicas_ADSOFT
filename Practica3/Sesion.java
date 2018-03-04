/**
* Clase que implementa la sesion de una pelicula
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class Sesion{

	/*MEMORIA
	En vez usar un int con buatacasDisponibles, usamos 
	el getter de Sala para coger las butacas que tiene.
	Así nos evitamos repetir datos, y en caso de que la
	sala aumente su numero de butacas por ejemplo, no hace falta
	cambiar la sesion.
	Usamos entonces un int que sea butacasReservadas.
	*/

	Date fecha;
	Pelicula pelicula;
	Sala sala;
	int butacasReservadas;

	/**
	* Constructor de la clase Sesion
	* @param fecha Fecha de la sesion.
	* @param pelicula Pelicula que se va a reproducir en la sesion
	* @param sala Sala en la que tiene lugar la sesion
	* @param butacas Numero de butacas butacasReservadas
	*/
	public Sesion(Date fecha, Pelicula pelicula, Sala sala, int butacasReservadas){
		this.fecha = fecha;
		this.pelicula = pelicula;
		this.sala = sala;
		this.butacasReservadas = butacasReservadas;
	}

	/**
	* Metodo que permite actualizar el numero de butacas vendidas de una sesion.
	* @param numero Numero de butacas nuevas que queremos reservar.
	* @return Boolean que indica si hay o no algun error.
	*/
	public Boolean actualizarButacasVendidas(int numero){
		if((this.butacasReservadas + numero) > sala.getButacas()){
			return false;
		}else{
			this.butacasReservadas += numero;
			return true;
		}
	}

	/**
	* Getter de la fecha de la sescion.
	* @return Devuelve la fecha de la sesion.
	*/
	public Date getFecha(){
		return this.fecha;
	}
	
}