import java.util.List;

import Grafo.Grafo;
import Grafo.GrafoNoDirigido;
import Vertice.Vertice;

/**
* Clase que permite probar las clases Grafo y GrafoNoDirigido.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class Tester1 {

	/**
	 * Metodo main de la clase Tester1. 
	 * Creamos un GrafoNoDirigido, anadimos vertices y arcos entre dichos vertices,
	 * e imprimims el grafo y archos para comprobar que funciona correctamente.
	 * 
	 * @param args Argumos de entrada. Se ignoran.
	 */
		public static void main(String[] args) {
			
			Grafo<String> g = new GrafoNoDirigido<>();
			//Grafo<String> g = new GrafoDirigido<>();
			System.out.println(g.getClass().getName() + "\n");
			Vertice<String> v1 = g.addVertice("A");
			Vertice<String> v2 = g.addVertice("B");
			Vertice<String> v3 = g.addVertice("C");
			
			g.addArco(v1, v2, 10);
			g.addArco(v1, v2, 20);
			g.addArco(v3, v1, 30);
			
			System.out.println(g);
			List<Vertice<String>> vecinos1 = g.getVecinosDe(v1);
			System.out.println("Vecinos de " + v1 + ":");
			for (Vertice<String> v : vecinos1) {
			 System.out.println(v);
			}
			double peso1 = g.getPesoDe(v1, v2);
			System.out.println("Peso entre " + v1 + " y " + v2 + ": " + peso1);
			double peso2 = g.getPesoDe(v1, v3);
			System.out.println("Peso entre " + v1 + " y " + v3 + ": " + peso2); 
		}
}
