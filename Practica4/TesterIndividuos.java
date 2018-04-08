import Individuo.IIndividuo;
import Individuo.Individuo;
import Nodo.Terminal;
import Nodo.TerminalAritmetico;
import Nodo.Funcion.*;

public class TesterIndividuos {

	public static void main(String[] args) {
			Terminal x = new TerminalAritmetico("x");
			Funcion suma = new FuncionSuma();
			Funcion resta = new FuncionResta();
			Funcion multi = new FuncionMultiplicacion();
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
