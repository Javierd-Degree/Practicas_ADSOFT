/**
 * Esta clase implementa una película de un cine.
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
	 * Getter del titulo de la pelicula.
   	 * @return Titulo de la pelicula.
   	 */
	public String getTitulo(){
		return this.titulo;
	}

	/** 
	 * Getter del director de la pelicula.
   	 * @return Director de la pelicula.
   	 */
	public String getDirector(){
		return this.director;
	}

	/** 
	 * Getter del anno de salida de la pelicula.
   	 * @return Anno de salida de la pelicula.
   	 */
	public int getAnno(){
		return this.anno;
	}

	/** 
	 * Getter del resumen de la pelicula.
   	 * @return Resumen de la pelicula.
   	 */
	public String getSinopsis(){
		return this.sinopsis;
	}

	/** 
	 * Getter del genero de la pelicula.
   	 * @return Genero de la pelicula.
   	 */
	public Genero getGenero(){
		return this.genero;
	}





	/** 
	 * Setter del titulo de la pelicula.
   	 * @param titulo Titulo de la pelicula.
   	 */
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	/** 
	 * Setter del director de la pelicula.
   	 * @param director Director de la pelicula.
   	 */
	public void setDirector(String director){
		this.director = director;
	}

	/** 
	 * Setter del anno de salida de la pelicula.
   	 * @param anno Anno de salida de la pelicula.
   	 */
	public void setAnno(int anno){
		this.anno = anno;
	}

	/** 
	 * Setter del resumen de la pelicula.
   	 * @param sinopsis Resumen de la pelicula.
   	 */
	public void setSinopsis(String sinopsis){
		this.sinopsis = sinopsis;
	}

	/** 
	 * Setter del genero de la pelicula.
   	 * @param genero Genero de la pelicula.
   	 */
	public void setGenero(Genero genero){
		this.genero = genero;
	}



	/** 
	 * Crea un string con los datos de la pelicula.
   	 * @return Un string con todos los datos de la pelicula.
   	 */
	public String toString(){
		return "\n\tTítulo: " + this.titulo + "\n\tDirector: " + this.director + "\n\tAño de salida: " + this.anno + "\n\tSinopsis: " + this.sinopsis + "\n\tGénero: " + this.genero;
	}
}

