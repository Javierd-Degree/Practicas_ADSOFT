package Algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Dominio.IDominio;
import Excepciones.ArgsDistintosFuncionesException;
import Excepciones.CruceNuloException;
import Individuo.IIndividuo;
import Individuo.Individuo;
import Nodo.INodo;
import Nodo.Terminal;
import Nodo.Funcion.Funcion;

/**
* Clase Algoritmo que implementa un algortmo genetico mediante
* la interfaz IAlgoritmo.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class Algoritmo implements IAlgoritmo{
	
	/**
	 * @param terminales Lista de terminales del algoritmo.
	 */
	private List<Terminal> terminales;
	
	/**
	 * @param funciones Lista de funciones del algoritmo.
	 */
	private List<Funcion> funciones;
	
	/**
	 * @param poblacion Poblacion con la cual trabaja el 
	 * algoritmo.
	 */
	private List<IIndividuo> poblacion;
	
	/**
	 * @param numIndividuos numero de individuos con los que
	 * trabajara el algoritmo.
	 */
	private int numIndividuos;
	
	/**
	 * @param profundidad Profundidad inicial de los individuos
	 * del algoritmo.
	 */
	private int profundidad;
	
	/**
	 * @param numGeneraciones Numero de generaciones que queremos que desarrolle el
	 * algoritmo.
	 */
	private int numGeneraciones;
	
	/**
	 * Constructor de la clase Algoritmo.
	 * 
	 * @param numIndividuos Numero de individuos de la pobalcion.
	 * @param profundidad Profundidad por defecto de los individuos
	 * de la poblacion.
	 * @param numGeneraciones Numero de generaciones que desarrollara
	 * el algoritmo.
	 */
	public Algoritmo(int numIndividuos, int profundidad, int numGeneraciones) {
		this.numIndividuos = numIndividuos;
		this.profundidad = profundidad;
		this.numGeneraciones = numGeneraciones;
	}
	
	/**
	 * Metodo que permite definir el conjunto de terminales del Algoritmo.
	 * 
	 * @param terminales Conjunto de terminales que tendra el algoritmo.
	 */
	@Override
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;
	}

	/**
	 * Metodo que permite definir el conjunto de funciones del Algoritmo.
	 * 
	 * @param funciones Conjunto de funciones que tendra el algoritmo.
	 * @throws ArgsDistintosFuncionesException Nunca, pero estaba definido
	 * asi en la interfaz dada.
	 */
	@Override
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.funciones = funciones;
	}

	/**
	 * Metodo inicializa la poblacion inicial de un algoritmo, 
	 * creando individuos aleatorios con las funciones, terminales
	 * y profundidad establecidos.
	 * 
	 * Si no se han establecido los terminales o las funciones
	 * simplemente lanza un mensaje de error. 
	 */
	@Override
	public void crearPoblacion() {
		if(this.terminales == null || this.funciones == null) {
			System.out.println("Error. Los terminales y las funciones tienen que estar inicializados");
			return;
		}
		
		poblacion = new ArrayList<>();
		for(int i = 0; i < this.numIndividuos; i++) {
			Individuo ind = new Individuo();
			ind.crearIndividuoAleatorio(this.profundidad, this.terminales, this.funciones);
			this.poblacion.add(ind);
		}
	}
	
	/**
	 * Metodo que implementa el cruce aleatorio entre dos individuos.
	 * Elegimos un nodo al azar de cada uno de los individuos, los
	 * cambiamos, y devolvemos una copia. Asi, dos indiviuos generan
	 * otros dos descendientes, que son una mezcla de ambos.
	 * 
	 * Es el mismo metodo que el creado en PruebaCruce.
	 * 
	 * @param ind1 IIndividuo para cruzar
	 * @param ind2 IIndividuo para cruzar
	 * @return Lista con los dos individuos descendientes.
	 * @throws CruceNuloException Si los dos descendientes
	 */
	@Override
	public List<IIndividuo> cruce(IIndividuo ind1, IIndividuo ind2) throws CruceNuloException {
		List<IIndividuo> result = new ArrayList<>();
		int a = Individuo.aleatNum(0, ind1.getNumeroNodos()-1);
		int b = Individuo.aleatNum(0, ind2.getNumeroNodos()-1);
		
		/* TODO Descomentar para la entrega. Lo quitamos para acelerar las pruebas.
		 * if(a == 0 && b == 0) {
			throw new CruceNuloException();
		}*/
		
		while(a == 0 && b == 0) {
			a = Individuo.aleatNum(0, ind1.getNumeroNodos()-1);
			b = Individuo.aleatNum(0, ind2.getNumeroNodos()-1);
		}
		
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
		
		copia1.getExpresion().reemplazarNodo(a, nodo2);
		copia2.getExpresion().reemplazarNodo(b, nodo1);
		copia1.etiquetaNodos();
		copia2.etiquetaNodos();
		
		result.add(copia1);
		result.add(copia2);
		return result;
	}

	/**
	 * Metodo que permite evolucionar a la poblacion.
	 * Usamos un algorimo basado en la seleccion natural, de esta forma,
	 * dada una generacion, solo la mitad de los individuos, aquellos
	 * con mejor fitness, sobreviven, y de estos, la primera mitad
	 * se reproduce con el resto. De esta forma, siempre se van a 
	 * reproducir los mejores entre si, y mantenemos el numero de la
	 * poblacion constante.
	 */
	@Override
	public void crearNuevaPoblacion() {
		/* Nos quedamos con los mejores individuos. Del resto, cruzamos la mitad, los mejores,
		 * y el resto los borramos.*/
		List<IIndividuo> poblacion2 = new ArrayList<>();
		int numFijos = (int) (poblacion.size()/2);
		/* Incluimos el 50%, los mejores */
		poblacion2.addAll(this.poblacion.subList(0, numFijos));
		
		/* De los mejores, mezclamos la primera mitad 
		 * con todos, juntandolos de forma aleatoria */
		List<IIndividuo> temp = poblacion.subList(0, numFijos+1);
		for(int i = 0; i < temp.size()/2; i++) {
			int j;
			do {
				j = Individuo.aleatNum(0, temp.size()-1);
			}while(j != i);
			
			try {
				poblacion2.addAll(cruce(temp.get(i), temp.get(j)));
			} catch (CruceNuloException e) {
				e.printStackTrace();
			}
		}
		
		//this.poblacion.clear();
		this.poblacion = poblacion2;
	}
	
	/**
	 * Metodo que permite, una vez inicializadas las funciones,
	 * los terminales y la poblacion del Algoritmo, desarrollarlo,
	 * imprimiendo por pantalla el mejor algoritmo de cada generacion.
	 */
	@Override
	public void ejecutar(IDominio dominio) {
		if(this.poblacion == null) {
			System.out.println("Error. Es necesario crear la poblacion inicial antes");
			return;
		}
		
		for(int i = 0; i < this.numGeneraciones; i++) {
			/*Calculamos el fitness de todos los terminos de la lista*/
			for(IIndividuo ind: this.poblacion) {
				dominio.calcularFitnessAvanzado(ind);
			}
			
			/* Implementamos un comparator que nos permita ordenar los Individuos
			 * segun su fitness, de mayor a menor. */
			Comparator<IIndividuo> comparaFitness = new Comparator<IIndividuo>() {
				@Override
				public int compare(IIndividuo arg0, IIndividuo arg1) {
					return (int) -(arg1.getFitness() - arg0.getFitness());
				}
				
			};
			
			Collections.sort(this.poblacion, comparaFitness);
			System.out.printf("En la generacion %d el mejor fitness es %.2f de la expresion: %s\n",
					i, this.poblacion.get(0).getFitness(), this.poblacion.get(0).getExpresion().toString());
			
			if(poblacion.get(0).getFitness() == 0.0) {
				break;
			}
			
			crearNuevaPoblacion();
		}
		
	}

}
