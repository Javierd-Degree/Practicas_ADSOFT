import java.io.IOException;

import Dominio.DominioAritmetico;
import Dominio.IDominio;
import Individuo.IIndividuo;
import Individuo.Individuo;
import Nodo.Terminal;
import Nodo.TerminalAritmetico;
import Nodo.Funcion.Funcion;
import Nodo.Funcion.FuncionMultiplicacion;
import Nodo.Funcion.FuncionResta;
import Nodo.Funcion.FuncionSuma;

public class TesterLecturaYFitness {
	public static void main(String[] args) throws IOException {
		IDominio domAritm;
		double fitness;
		
		domAritm = new DominioAritmetico();
		domAritm.definirValoresPrueba("valoresReducido.txt");
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
		
		IIndividuo indiv = new Individuo();
		indiv.setExpresion(resta);
		System.out.println();
		System.out.println("INDIVIDUO");
		indiv.writeIndividuo();
		System.out.println();
		fitness = domAritm.calcularFitness(indiv);
		/*TODO Explicar porque no se imprimen los valores.
		 *(Lo hemos quitado para no saturar el algoritmo general*/
		System.out.println("\nFITNESS = "+fitness);
		
		
		/* Individuo de verdad. */
		IDominio domAritm2 = new DominioAritmetico();
		domAritm2.definirValoresPrueba("datos.txt");
		Terminal x2 = new TerminalAritmetico("x");
		Funcion suma2 = new FuncionSuma(2);
		Funcion suma3 = new FuncionSuma(2);
		Funcion multi2 = new FuncionMultiplicacion(2);
		Funcion multi3 = new FuncionMultiplicacion(2);
		
		multi2.incluirDescendiente(x2);
		multi2.incluirDescendiente(x2);
		suma2.incluirDescendiente(x);
		suma2.incluirDescendiente(multi2);
		
		multi3.incluirDescendiente(multi2);
		multi3.incluirDescendiente(suma2);
		
		suma3.incluirDescendiente(multi3);
		suma3.incluirDescendiente(suma2);
		
		IIndividuo indiv2 = new Individuo();
		indiv2.setExpresion(suma3);
		System.out.println();
		System.out.println("INDIVIDUO");
		indiv2.writeIndividuo();
		System.out.println();
		fitness = domAritm2.calcularFitness(indiv2);
		/*TODO Explicar porque no se imprimen los valores.
		 *(Lo hemos quitado para no saturar el algoritmo general*/
		System.out.println("\nFITNESS = "+fitness);
		
	}
}