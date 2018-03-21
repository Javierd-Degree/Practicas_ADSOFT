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
	 * Main que realiza pruebas de integracion de todo el proyecto
	 * mediante el uso de la clase Cine.
   	 * @param args Array de strings que el usuario pasa por teclado (se ignora)
   	 */
	public static void main(String[] args) {
		/*Creamos un cine correcto y otro no v�lido*/
		Cine cine = new Cine("Yelmo", "Callao");
		Cine cine2 = new Cine("", "Callao");
		System.out.println("�Es v�lido el cine 1? " + cine.validar());
		System.out.println("�Es v�lido el cine 2? " + cine2.validar());
		System.out.print("El primer cine es: " + cine);
		
		/**
		 * En este caso no creamos peliculas, sesiones, salas etc 
		 * incorrectas y correctas porque ya las hemos comprobado
		 * su correcto funcionamiento en las pruebas unitarias.
		 * 
		 * */
		Pelicula p = cine.crearPelicula("Cars", "John Lasseter", 2011, "Pel�cula infantil de coches.",
				Genero.DIBUJOS);
		System.out.println("\nA�adimos una pel�cula al cine: " +
				(p != null));
		System.out.println("Intentamos volver a a�adir la misma pel�cula: " +
				(cine.crearPelicula("Cars", "John Lasseter", 2011, "Pel�cula infantil de coches.",
				Genero.DIBUJOS) != null));
		System.out.println("Intentamos a�adir una pel�cula no v�lida: " +
				(cine.crearPelicula("Nada", "", -2011, "",
				Genero.SUSPENSE) != null));
		
		/*Guardamos la sala simplemente para a�adirla a la sesi�n luego.*/
		Sala s = cine.crearSala(9, 124);
		System.out.println("\nA�adimos una nueva sala al cine: " + (s != null));
		System.out.println("Intentamos volver a a�adir la misma sala: " + (cine.crearSala(9, 124) != null));
		System.out.println("Intentamos a�adir una sala no v�lida: " + (cine.crearSala(7, -124) != null));
	
		/*Guardamos la sesi�n simplemente para vender entradas luego.*/
		Sesion se = cine.crearSesion(s, p, LocalDate.of(2018, 3, 29));
		System.out.println("\nA�adimos una nueva sesi�n al cine: " + (se != null));
		System.out.println("Intentamos volver a a�adir la misma sesi�n al cine: " + 
				(cine.crearSesion(s, p, LocalDate.of(2018, 3, 29)) != null));
		System.out.println("Intentamos a�adir una sesi�n no v�lida al cine: " + 
				(cine.crearSesion(s, null, LocalDate.of(2018, 3, 29)) != null));
		/*Llamamos a la funci�n aqu� para simplicar el c�digo */
		Pelicula p2 = cine.crearPelicula("Cars 2", "John Lasseter", 2016, "Pel�cula infantil de coches.",
				Genero.ACCION);
		System.out.println("Intentamos a�adir una sesi�n distinta, pero que concide en sala y fecha con la primera: " + 
				(cine.crearSesion(s, p2, LocalDate.of(2018, 3, 29)) != null));
		/*Guardamos para vender entradas posteriormente.*/
		Sesion se2 = cine.crearSesion(s, p2, LocalDate.of(2018, 5, 29));
		System.out.println("A�adimos otra sesi�n en misma sala y distinta fecha: " + 
				(se2 != null) + "\n");
		
		System.out.println("Vendemos una entrada normal de la primera sesi�n: " + cine.venderEntradas(9.99, 0, se));
		System.out.println("Vendemos una entrada del dia del espectador de la primera sesi�n: " + cine.venderEntradas(9.99, 0.2, se));
		System.out.println("Vendemos cinco entradas normales de la segunda sesi�n: " + cine.venderEntradas(5, 9.99, 0, se2));
		System.out.println("Vendemos diez entradas del dia del espectador de la segunda sesi�n: " + cine.venderEntradas(10, 9.99, 0.2, se2));
		System.out.println("Intentamos vender mas entradas de las disponibles en la segunda sesi�n: " + cine.venderEntradas(10000, 9.99, 0, se2) + "\n");
		System.out.println("La recaudaci�n total del cine es: " + cine.recaudacion() + "\n");
		
		System.out.println(cine.infoCartelera());
		System.out.println(cine.infoSesiones());
		/*TODO infoSesionesPelicula*/
		System.out.println("Buscamos las sesiones en las que est� la pel�cula Cars:");
		System.out.println(cine.infoSesionesPelicula(p) + "\n");
		
		/*TODO Quitar la pel�cula de varias sesiones, no solo de una.*/
		System.out.println("Quitamos la pel�cula Cars de la cartelera: " + cine.quitarPeliculaCartelera(p));
		System.out.println(cine.infoCartelera());
		System.out.println(cine.infoSesiones());
	}
}
