import java.time.LocalDate;

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

	LocalDate fecha;
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
	public Sesion(LocalDate fecha, Pelicula pelicula, Sala sala, int butacasReservadas){
		this.fecha = fecha;
		this.pelicula = pelicula;
		this.sala = sala;
		this.butacasReservadas = butacasReservadas;
	}
	
	/**
	* Valida si los datos de la sesion son o no correctos. 
	* Comprobamos que la pelicula no sean null, y que el numero de butacas
	* reservadas no sea negativo.
	* No comprobamos si sala es null porque puede haber una sesion que establezca
	* la sala posteriormente.
	* No validamos la pelicula o la sala, solo comprobamos que existan.
	* @retun boolean indicando si es o no valido.
	*/
	public boolean validar(){
		if(this.butacasReservadas < 0){
			return false;
		}else if(pelicula == null || sala == null){
			return false;
		}
		return true;
	}

	/**
	* Metodo que permite actualizar el numero de butacas vendidas de una sesion.
	* @param numero Numero de butacas nuevas que queremos reservar.
	* @return Boolean que indica si hay o no algun error.
	*/
	public boolean actualizarButacasVendidas(int numero){
		if(sala == null) {
			return false;
		}else if((this.butacasReservadas + numero) > sala.getButacas()){
			return false;
		}else{
			this.butacasReservadas += numero;
			return true;
		}
	}

	/**
	* Getter de la fecha de la sesion.
	* @return Devuelve la fecha de la sesion.
	*/
	public LocalDate getFecha(){
		return this.fecha;
	}
	
	/**
	* Getter de la pelicula de la sescion.
	* @return Devuelve la fecha de la sesion.
	*/
	public Pelicula getPelicula(){
		return this.pelicula;
	}

	/** 
	 * Crea un string con los datos de la sesion.
   	 * @return Un string con todos los datos de la sesion.
   	 */
	public String toString(){
		if(this.validar()==true){
			return "Sesi�n de la pel�cula " + pelicula.getTitulo() + 
					" el d�a " + fecha + " en la sala " + sala.getId() + ".";
		}
		return "\tSesi�n no v�lida.";
	}
	
	/**
	 * Compara dos Sesion para ver si son o no la misma.
	 * @return boolean con true si son la misma y false en caso contrario.
	 * */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Sesion)) {
			return false;
		}
		Sesion s = (Sesion) o;
		return s != null && this.sala.equals(s.sala) && this.pelicula.equals(s.pelicula) &&
				this.fecha.equals(s.fecha) && this.butacasReservadas == s.butacasReservadas;
	}
}