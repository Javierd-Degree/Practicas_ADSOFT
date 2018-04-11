import Individuo.IIndividuo;
import Individuo.Individuo;
import Nodo.Terminal;
import Nodo.TerminalAritmetico;
import Nodo.Funcion.*;

/**
* Clase que implementa un test para los metodos basicos de 
* las funciones, TerminalAritmetico e Individuo, definidos
* en la primera parte de la practica.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public class TesterIndividuos {

	/**
	 * Metodo main que nos permite probar el funcionamiento basico de 
	 * las clases Terminal, TerminalAritmetico, Funcion, FuncionSuma,
	 * FuncionResta, FuncionMultiplicacion e Individuo.
	 * 
	 * Creamos un Terminal y una Funcion de cada tipo, con estos,
	 * definimos una expresion simbolica para cada funcion que 
	 * imprimimos, para comprobar que se ha formado correctamente.
	 * Tras esto, asignamos la expresion resta al individuo, e 
	 * imprimimos el individuo para ver que funciona correctamente. 
	 * 
	 * @param args Argumentos pasados a la funcion. No se utiliza.
	 */
	public static void main(String[] args) {
			Terminal x = new TerminalAritmetico("x");
			Funcion suma = new FuncionSuma(2);
			Funcion resta = new FuncionResta(2);
			Funcion multi = new FuncionMultiplicacion(2);
			
			multi.incluirDescendiente(x);
			multi.incluirDescendiente(x);
			suma.incluirDescendiente(multi);
			suma.incluirDescendiente(x);
			resta.incluirDescendiente(suma);
			resta.incluirDescendiente(multi);
			
			System.out.println("Función multiplicación: " + multi);
			System.out.println();
			System.out.println("Función suma: " + suma);
			System.out.println();
			System.out.println("Función resta: " + resta);
			
			IIndividuo indiv = new Individuo();
			indiv.setExpresion(resta);
			System.out.println();
			System.out.println("INDIVIDUO");
			indiv.writeIndividuo();
		}
}
