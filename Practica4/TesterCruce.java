import java.util.ArrayList;
import java.util.List;

import Excepciones.CruceNuloException;
import Individuo.IIndividuo;
import Individuo.Individuo;
import Nodo.Terminal;
import Nodo.TerminalAritmetico;
import Nodo.Funcion.Funcion;
import Nodo.Funcion.FuncionMultiplicacion;
import Nodo.Funcion.FuncionResta;
import Nodo.Funcion.FuncionSuma;


/**
* Clase que nos permite probar el cruce de dos IIndividuos 
* usando el metodo creado en Pruebacruce.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class TesterCruce {
	/**
	 * Metodo que inicializa y cruza dos individuos, imprimiendolos
	 * a ellos y a sus descendientes.
	 * 
	 * Dado el funcionamiento aleatorio de nuestro algoritmo, y la 
	 * simpleza de los IIndividuos utilizados para este ejemplo, es
	 * es posible que al ejecutarse los progenitores y los descendientes
	 * sean exactamente iguales, y por tanto haya que ejecutarlo varias
	 * veces hasta poder ver cambios.
	 * 
	 * @param args Argumentos pasados a la funcion. No se utiliza.
	 */
	public static void main(String[] args) {
		PruebaCruce prueba = new PruebaCruce();
		List<IIndividuo> descendientes = new ArrayList<IIndividuo>();
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
	
		IIndividuo prog1 = new Individuo();
		prog1.setExpresion(resta);
		prog1.etiquetaNodos();
		IIndividuo prog2 = new Individuo();
		prog2.setExpresion(suma);
		prog2.etiquetaNodos();
		System.out.println();
		System.out.println("PROGENITOR 1");
		prog1.writeIndividuo();
		System.out.println("PROGENITOR 2");
		prog2.writeIndividuo();
		
		try {
			descendientes = prueba.cruce(prog1, prog2);
			System.out.println();
			System.out.println("DESCENDIENTE 1");
			descendientes.get(0).writeIndividuo();
			System.out.println("DESCENDIENTE 2");
			descendientes.get(1).writeIndividuo();
		} catch (CruceNuloException e) {
			e.printStackTrace();
		}
	}
}