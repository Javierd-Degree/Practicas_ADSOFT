/**
 * Esta clase implementa una pelicula de un cine.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class Pelicula{
	private String titulo;
	private String director;
	private int anno;
	private String sinopsis;
	private Genero genero;

	/** 
	 * Constructor completo
   	 * @param titulo Titulo de la pelicula.
   	 * @param director Director de la pelicula.
   	 * @param anno Anno en que salio la pelicula.
   	 * @param sinopsis Resumen de la pelicula.
   	 * @param genero Genero de la pelicula.
   	 */
	public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero){
		this.titulo = titulo;
		this.director = director;
		this.anno = anno;
		this.sinopsis = sinopsis;
		this.genero = genero;
	}

	/**
	* Valida si los datos de la pelicula son o no correctos. 
	* Comprobamos que el anno sea un numero positivo al menos y que los Strings no sean vacios.
	* @retun boolean indicando si es o no valido.
	*/
	public boolean validar(){
		if(this.anno < 0){
			return false;
		}else if(this.titulo == "" || this.director == "" || this.sinopsis == ""){
			return false;
		}
		return true;
	}

	/** 
	 * Crea un string con los datos de la pelicula.
   	 * @return Un string con todos los datos de la pelicula.
   	 */
	public String toString(){
		if(this.validar() == true) {
			return "\tTítulo: " + this.titulo + "\n\tDirector: " + this.director + "\n\tAño de salida: " + this.anno + "\n\tSinopsis: " + this.sinopsis + "\n\tGénero: " + this.genero;	
		}
		return "\tPelícula no válida.";
	}

	/** 
	 * Getter del titulo de la pelicula.
   	 * @return Titulo de la pelicula.
   	 */
	public String getTitulo(){
		return this.titulo;
	}
	
	/**
	 * Compara dos Pelicula para ver si son o no la misma.
	 * @return boolean con true si son la misma y false en caso contrario.
	 * */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Pelicula)) {
			return false;
		}
		Pelicula p = (Pelicula) o;
		return p != null && this.titulo.equals(p.titulo) && this.director.equals(p.director) && this.anno == p.anno &&
				this.sinopsis.equals(p.sinopsis) && this.genero == p.genero;
	}
}

