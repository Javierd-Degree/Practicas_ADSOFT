package Dominio;

import java.io.IOException;
import java.util.List;

import javax.annotation.processing.FilerException;

import Excepciones.ArgsDistintosFuncionesException;
import Individuo.IIndividuo;
import Nodo.Funcion.*;
import Nodo.Terminal;

/**
* Interfaz dada con las operaciones necesarias de un IDominio.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public interface IDominio {
	
	/**
	 * Crea el conjunto de terminales de un IDominio
	 * 
	 * @param terminales terminales a anadir IDominio.
	 * @return Lista de terminales anadidos.
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	
	/**
	 * Crea el conjunto de funciones de un IDominio dados los simbolos
	 * de las funciones, y el numero de elementos de entrada de cada una.
	 * 
	 * @param argumentos array de int que tienen las funciones como argumentos.
	 * @param funciones Simbolos de las funciones a definir.
	 * @return Lista con las funciones creadas.
	 * @throws ArgsDistintosFuncionesException si la longitud de argumentos
	 * y la de funciones difiere.
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws
	ArgsDistintosFuncionesException;
	
	/**
	 * Metodo que lee de fichero los valores que queremos dar a la funcion, junto
	 * con el valor esperado que deberia devolver.
	 * 
	 * @param ficheroDatos Localizacion del fichero del que leer los datos.
	 * @throws FilerException Si hay un problema con el fichero.
	 * @throws IOException Si el fichero no existe.
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FilerException, IOException;
	
	/**
	 * Dado un individuo, calcula su nivel de fitness usando los valores cargados
	 * mediante definirValoresPrueba. 
	 * 
	 * @param individuo IIndividuo cuyo nivel de fitness queremos calcular.
	 * @return double con el valor de fitness del individuo, que oscila entre 0
	 * y el numero de puntos del archivo usado en definirValoresPrueba.
	 * Cuando mayor sea, mejor es el individuo.
	 */
	public double calcularFitness(IIndividuo individuo);
	
	/**
	 * Funcion fitness ideada por nosotros.
	 * Dado un individuo, calcula su nivel de fitness usando los valores cargados
	 * mediante definirValoresPrueba. 
	 * Evalua el IIndividuo en los puntos dados y devuelve la media de la distancia
	 * entre la evaluacion del IIndividuo y la funcion pedida. De esta forma,
	 * permite analizar con mayor precision la validez del IIndividuo.
	 * 
	 * @param individuo IIndividuo cuyo nivel de fitness queremos calcular.
	 * @return double con el valor de fitness del individuo, que oscila entre
	 * cero e infinito. Cuanto menor sea, menor es la funcion.
	 */
	public double calcularFitnessAvanzado(IIndividuo individuo);
}
