/**
 * Esta clase implementa pruebas unitarias de las clases
 * Pelicula, Sesion y Sala.
 * Probamos en primer lugar la clase Pelicula, pues es independiente
 * de las otras, y despues la clase Sala y Sesion, que dependen una de
 * la otra, y a su vez de la clase Pelicula.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

import java.time.LocalDate;

public class PruebasIndividuales{

	/** 
	 * Main que realiza pruebas unitarias de las clases Pelicula, Sesion y Sala.
	 * Creamos dos peliculas y comprobamos si son o no correctas.
	 * Creamos dos salas, con numero de butacas positivo y negativo, y comprobamos
	 * si son o no correctas y las imprimimos.
	 * Creamos dos sesiones. Una valida (numero de butacas reservadas positivo)
	 * y otra no valida (numero de butacas reservadas negativo), y las validamos.
	 * Anadimos dichas sesiones a la sala, para ver que al tener la misma fecha
	 * no se pueden anadir ambas. Esto prueba el metodo anadirSesion de sala, pues
	 * no se puede probar sin usar Sala.
	 * Imprimimos la sesion valida.
   	 * @param args Array de strings que el usuario pasa por teclado (se ignora)
   	 */
	public static void main(String[] args) {
		Pelicula p = new Pelicula("Cars 2",
			"John Lasseter", 2011, 
			"Rayo McQueen y su amigo, la grua Mate, viajan al extranjero para participar en el primer Campeonato Mundial en el que se decidira cuál es el coche mas rápido del planeta.",
			Genero.DIBUJOS);
		System.out.println("¿Es válida la película 1?: " + p.validar());
		System.out.println(p + "\n");

		
		Pelicula p2 = new Pelicula("", "Ronald", 1999, "", Genero.ROMANCE);
		System.out.println("¿Es válida la película 2?: " + p2.validar());
		System.out.println(p2 + "\n");

		System.out.println("¿Son p1 y p1 la misma película? " + p.equals(p));
		System.out.println("¿Son p1 y p2 la misma película? " + p.equals(p2) + "\n");
		
		Sala s = new Sala(1, 123);
		System.out.println("Creada sala con id: " + s + " y 123 butacas.");
		System.out.println("¿Es válida la sala 1?: " + s.validar());
		Sala s2 = new Sala(2, -66);
		System.out.println("Creada sala con id: " + s2 + " y -66 butacas.");
		System.out.println("¿Es válida la sala 2?: " + s2.validar());
		System.out.println("¿Son s1 y s1 la misma sala? " + s.equals(s));
		System.out.println("¿Son s1 y s2 la misma sala? " + s.equals(s2) + "\n");

		Sesion se = new Sesion(LocalDate.of(2018, 3, 29), p, s, 0);
		Sesion se2 = new Sesion(LocalDate.of(2018, 3, 29), p, s, -5);
		System.out.println("¿Es válida la sesión 1?: " + se.validar());
		System.out.println("¿Es valida la sesión 2?: " + se2.validar());
		System.out.println("¿Son se1 y se1 la misma sesión? " + se.equals(se));
		System.out.println("¿Son se1 y se2 la misma sesión? " + se.equals(se2) + "\n");
		System.out.println("Imprimimos la sesiÃ³n: " + se);
		System.out.println("Vendemos menos entradas de las disponibles: " + se.actualizarButacasVendidas(10));
		System.out.println("Vendemos mas entradas de las disponibles: " + se.actualizarButacasVendidas(200));
		
		System.out.println("\nAñadimos a una sala una sesión que aun no esta añadida: " + s.anadirSesion(se));
		System.out.println("Añadimos otra sesión en la misma fecha: " + s.anadirSesion(se));
	}
}