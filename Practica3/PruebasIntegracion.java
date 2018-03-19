

/**
 * Esta clase implementa todas las pruebas para evaluar el correcto
 * funcionamiento de la clase cine, y por tanto la integración
 * de todas las clases del proyecto.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class PruebasIntegracion {
	
	/** 
	 * Main que realiza pruebas de integración de todo el proyecto
	 * mediante el uso de la clase Cine.
   	 * @param args Array de strings que el usuario pasa por teclado (se ignora)
   	 */
	public static void main(String[] args) {
		/*Creamos un cine correcto y otro no válido*/
		Cine cine = new Cine("Yelmo", "Callao");
		Cine cine2 = new Cine("", "Callao");
		System.out.println("¿Es válido el cine 1? " + cine.validar());
		System.out.println("¿Es válido el cine 2? " + cine2.validar());
		System.out.print("El primer cine es: " + cine);
		
		/**
		 * En este caso no creamos películas, sesiones, salas etc 
		 * incorrectas y correctas porque ya las hemos comprobado
		 * su correcto funcionamiento en las pruebas unitarias.
		 * 
		 * */
		System.out.println("\nAñadimos una película al cine: " +
				cine.crearPelicula("Cars", "John Lasseter", 2011, "Película infantil de coches.",
				Genero.DIBUJOS));
		System.out.println("Intentamos volver a añadir la misma película: " +
				cine.crearPelicula("Cars", "John Lasseter", 2011, "Película infantil de coches.",
				Genero.DIBUJOS));
		System.out.println("Intentamos añadir una película no válida: " +
				cine.crearPelicula("Nada", "", -2011, "",
				Genero.SUSPENSE));
		
		System.out.println("\nAñadimos una nueva sala al cine: " + cine.crearSala(9, 124));
		System.out.println("Intentamos volver a añadir la misma sala: " + cine.crearSala(9, 124));
		System.out.println("Intentamos añadir una sala no válida: " + cine.crearSala(7, -124));
	
		/*TODO Añadirpelicula, vender entrada ... quitarPeliculaCartelera*/
		
		/*TODO Añadir mas peliculas, sesiones y salas para la prueba*/
		System.out.println(cine.infoCartelera());
		System.out.println(cine.infoSesiones());
		/*TODO infoSesionesPelicula*/
	}
}
