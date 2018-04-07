import Nodo.Funcion;
import Nodo.Terminal;
import Nodo.TerminalAritmetico;

public class TesterIndividuos {

	public static void main(String[] args) {
			Terminal x = new TerminalAritmetico("x");
			Funcion suma = new Funcion("+", 2);
			Funcion resta = new Funcion("-", 2);
			Funcion multi = new Funcion("*", 2);
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
		}
}
