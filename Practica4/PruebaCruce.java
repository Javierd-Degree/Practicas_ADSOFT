import java.util.ArrayList;
import java.util.List;

import Excepciones.CruceNuloException;
import Individuo.IIndividuo;
import Individuo.Individuo;
import Nodo.INodo;

/**
* Clase que se encarga de cruzar dos IIndividuos.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/


public class PruebaCruce {
	
	public List<IIndividuo> cruce(IIndividuo ind1, IIndividuo ind2) throws CruceNuloException{
		List<IIndividuo> result = new ArrayList<>();
		int a = Individuo.aleatNum(0, ind1.getNumeroNodos()-1);
		int b = Individuo.aleatNum(0, ind2.getNumeroNodos()-1);
		
		if(a == 0 && b == 0) {
			throw new CruceNuloException();
		}
		
		System.out.println("Punto de cruce del progenitor 1: "+a);
		System.out.println("Punto de cruce del progenitor 2: "+b);
		
		/*Copiamos los individuos, pues no podemos devolver el mismo.
		 * Una vez copiados, los etiquetamos, pues durante la copia no
		 * copiamos las etiquetas. Así, si los individuos iniciales estaban
		 * etiquetados, no habrá ningun problema, seran iguales, y si no estaban
		 * etiquetados, el algoritmo seguira funcionando.*/
		IIndividuo copia1 = new Individuo();
		copia1.setFitness(ind1.getFitness());
		copia1.setExpresion(ind1.getExpresion().copy());
		copia1.etiquetaNodos();
		
		IIndividuo copia2 = new Individuo();
		copia2.setFitness(ind2.getFitness());
		copia2.setExpresion(ind2.getExpresion().copy());
		copia2.etiquetaNodos();
		
		/*Cogemos enconces los Nodos que queremos intercambiar entre ambos arboles.
		 * En este caso, dado nuestro algoritmo de etiquetacion y nuestra forma de 
		 * generar los numeros aleatorios, sabemos que dicho nodo siempre va a estar,
		 * y por tanto, no hace falta que nos aseguremos de que la funcion buscarNodo
		 * no devuelva null.*/
		
		INodo nodo1 = copia1.getExpresion().buscarNodo(a);
		INodo nodo2 = copia2.getExpresion().buscarNodo(b);
		
		result.add(copia1);
		result.add(copia2);
		copia1.getExpresion().reemplazarNodo(a, nodo2);
		copia2.getExpresion().reemplazarNodo(b, nodo1);
		
		/*TODO Reetiquetar los nodos despues del cruce. No lo hacemos porque
		 * ahora mismo el etiquetar imprime, y seria muy molesto.*/
		
		return result;
	}

}
