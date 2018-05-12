import Grafo.GrafoGOT;

public class Tester2 {
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
		
		System.out.println("Probamos si las funciones de grado funcionan");
		grafo.gradoPersonajes().forEach((name, value) -> {
			int t = grafo.getVecinosDe(grafo.getVertice(name)).size();
			if(t != value) {
				System.out.println("Ha fallado en: "+name);
			}
		});
		
		System.out.println(grafo.gradoPonderadoPersonajes());
		
		
		System.out.println(grafo.personajesRelevantes());
	}
}
