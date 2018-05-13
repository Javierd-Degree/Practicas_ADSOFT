import Grafo.GrafoGOT;

/**
* Clase que permite probar la clase GrafoGOT mediante el uso de expresiones
* lamba en la medida de lo posible.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class Tester2 {
	
	/**
	 * Metodo main de la clase Tester2. 
	 * Creamos un GrafoGOT y probamos todos los metodos, comprobando su
	 * correccion mediante expresiones lambda, o imprimiendo su resultado
	 * para que se pueda comprobar mediante los archivos suministrados.
	 * 
	 * @param args Argumos de entrada. Se ignoran.
	 */
	public static void main(String[] args) {
		GrafoGOT grafo;
		try {
			grafo = new GrafoGOT("./got-s01-vertices.csv", "./got-s01-arcos.csv");
		} catch (Exception e) {
			System.out.println("Los archivos indicados no existen.");
			e.printStackTrace();
			return;
		}
		
		System.out.println("Imprimimos todas las casas y sus mienbros, "
				+ "para probar así los metodos casas() y miembrosCasa()\n");
		
		grafo.casas().forEach(p -> {
			System.out.println("Casa "+p+":\n\t"+ grafo.miembrosCasa(p));
		});
		
		System.out.println("\nProbamos si las funciones de gradoPersonajes gradoPonderadoPersonajes y  funcionan");
		grafo.gradoPersonajes().forEach((name, value) -> {
			int t = grafo.getVecinosDe(grafo.getVertice(name)).size();
			if(t != value) {
				System.out.println("\tHa fallado en: "+name);
			}
		});
		
		System.out.println(grafo.gradoPonderadoPersonajes());
		
		System.out.println("\nProbamos la funcion de personajesRelevantes");
		System.out.println(grafo.personajesRelevantes());
	}
}
