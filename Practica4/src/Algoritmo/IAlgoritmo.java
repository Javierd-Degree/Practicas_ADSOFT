package Algoritmo;

import java.util.List;

import Dominio.IDominio;
import Excepciones.ArgsDistintosFuncionesException;
import Excepciones.CruceNuloException;
import Individuo.IIndividuo;
import Nodo.Terminal;
import Nodo.Funcion.Funcion;

/**
* Interfaz IAlgoritmo que incluye los metodos necesarios para
* crear un algoritmo genetico.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public interface IAlgoritmo {
	
	/**
	 * Metodo que permite definir el conjunto de terminales del Algoritmo.
	 * 
	 * @param terminales Conjunto de terminales que tendra el algoritmo.
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);
	
	/**
	 * Metodo que permite definir el conjunto de funciones del Algoritmo.
	 * 
	 * @param funciones Conjunto de funciones que tendra el algoritmo.
	 * @throws ArgsDistintosFuncionesException Nunca, pero estaba definido
	 * asi en la interfaz dada.
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
	
	/**
	 * Metodo inicializa la poblacion inicial de un algoritmo, 
	 * creando individuos aleatorios con las funciones, terminales
	 * y profundidad establecidos.
	 * 
	 * Si no se han establecido los terminales o las funciones
	 * simplemente lanza un mensaje de error. 
	 */
	public void crearPoblacion();
	
	/**
	 * Metodo que implementa el cruce aleatorio entre dos individuos.
	 * Elegimos un nodo al azar de cada uno de los individuos, los
	 * cambiamos, y devolvemos una copia. Asi, dos indiviuos generan
	 * otros dos descendientes, que son una mezcla de ambos.
	 * 
	 * Es el mismo metodo que el creado en PruebaCruce.
	 * 
	 * @param prog1 IIndividuo para cruzar
	 * @param prog2 IIndividuo para cruzar
	 * @return Lista con los dos individuos descendientes.
	 * @throws CruceNuloException Si los dos descendientes
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;
	
	/**
	 * Metodo que permite evolucionar a la poblacion.
	 * Usamos un algorimo basado en la seleccion natural, de esta forma,
	 * dada una generacion, solo la mitad de los individuos, aquellos
	 * con mejor fitness, sobreviven, y de estos, la primera mitad
	 * se reproduce con el resto. De esta forma, siempre se van a 
	 * reproducir los mejores entre si, y mantenemos el numero de la
	 * poblacion constante.
	 */
	public void crearNuevaPoblacion();
	
	/**
	 * Metodo que permite, una vez inicializadas las funciones,
	 * los terminales y la poblacion del Algoritmo, desarrollarlo,
	 * imprimiendo por pantalla el mejor algoritmo de cada generacion.
	 * 
	 * @param dominio IDominio sobre el que calculamos el fitness
	 * de los individuos.
	 */
	public void ejecutar(IDominio dominio);
}
