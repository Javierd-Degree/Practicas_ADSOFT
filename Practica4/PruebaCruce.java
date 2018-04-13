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
	
	/**
	 * Metodo privado que nos permite generar un numero aleatorio en un intervalo
	 * cerrado [min, max]
	 * 
	 * @param min Numero aleatorio minimo.
	 * @param max Numero aleatorio maximo.
	 * @return int con un numero aleatorio entre min y max, ambos incluidos.
	 */
	private static int aleatNum(int min, int max) {
		return min + (int)(Math.random() * (max-min+1));
	}
	
	public List<IIndividuo> cruce(IIndividuo ind1, IIndividuo ind2) throws CruceNuloException{
		List<IIndividuo> result = new ArrayList<>();
		int a = aleatNum(0, ind1.getNumeroNodos());
		int b = aleatNum(0, ind2.getNumeroNodos());
		
		if(a == 0 && b == 0) {
			throw new CruceNuloException();
		}
		
		System.out.println("Buscamos los nodos " + a + ", "+ b);
		
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
		System.out.println("Nodo con etiqueta "+a + ": "+copia1.getExpresion().buscarNodo(a));
		System.out.println("Nodo con etiqueta "+b + ": "+copia2.getExpresion().buscarNodo(b));
		
		result.add(copia1);
		result.add(copia2);
		copia1.getExpresion().reemplazarNodo(a, nodo2);
		copia2.getExpresion().reemplazarNodo(b, nodo1);
		return result;
	}

}
