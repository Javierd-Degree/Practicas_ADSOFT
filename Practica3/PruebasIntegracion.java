import java.time.LocalDate;

/**
 * Esta clase implementa todas las pruebas para evaluar el correcto
 * funcionamiento de la clase cine, y por tanto la integración
 * de todas las clases del proyecto.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

/**
 * TODO Apuntar en memoria: En las funciones de crearSala etc, devolvemos la sala ara que se
 * pueda usar luego directamente, o bien null, de forma que no es necesario crear las clases
 * fuera del cine. Por esto, es los print de las pruebas de integracion imprimimos si el
 * resultado es o no null, para que se vea más facilmente el correcto funcionamiento de las 
 * clases.
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
		Pelicula p = cine.crearPelicula("Cars", "John Lasseter", 2011, "Película infantil de coches.",
				Genero.DIBUJOS);
		System.out.println("\nAñadimos una película al cine: " +
				(p != null));
		System.out.println("Intentamos volver a añadir la misma película: " +
				(cine.crearPelicula("Cars", "John Lasseter", 2011, "Película infantil de coches.",
				Genero.DIBUJOS) != null));
		System.out.println("Intentamos añadir una película no válida: " +
				(cine.crearPelicula("Nada", "", -2011, "",
				Genero.SUSPENSE) != null));
		
		/*Guardamos la sala simplemente para añadirla a la sesión luego.*/
		Sala s = cine.crearSala(9, 124);
		System.out.println("\nAñadimos una nueva sala al cine: " + (s != null));
		System.out.println("Intentamos volver a añadir la misma sala: " + (cine.crearSala(9, 124) != null));
		System.out.println("Intentamos añadir una sala no válida: " + (cine.crearSala(7, -124) != null));
	
		/*Guardamos la sesión simplemente para vender entradas luego.*/
		Sesion se = cine.crearSesion(s, p, LocalDate.of(2018, 3, 29));
		
		/*TODO Añadir mas peliculas, sesiones y salas para la prueba*/
		System.out.println(cine.infoCartelera());
		System.out.println(cine.infoSesiones());
		/*TODO infoSesionesPelicula*/
	}
}
