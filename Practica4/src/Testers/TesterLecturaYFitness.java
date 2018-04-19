package Testers;

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


/**
* Clase que implementa un test para los metodos basicos de 
* IDominio e IIndividuo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class TesterLecturaYFitness {
	
	/**
	 * Metodo que permite crear un dominio, establecer unos valores,
	 * y comprobar el fitness de un IIndividuo.
	 * 
	 * @param args Argumentos pasados a la funcion. No se utiliza.
	 * @throws IOException Si el fichero usado por el IDominio
	 * no existe.
	 */
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
		
	}
}