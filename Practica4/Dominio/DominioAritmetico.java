package Dominio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.processing.FilerException;

import Excepciones.ArgsDistintosFuncionesException;
import Individuo.IIndividuo;
import Nodo.Terminal;
import Nodo.TerminalAritmetico;
import Nodo.Funcion.Funcion;
import Nodo.Funcion.FuncionMultiplicacion;
import Nodo.Funcion.FuncionResta;
import Nodo.Funcion.FuncionSuma;

/**
* Clase DominioAritmetico que implementa la interfaz IDominio.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class DominioAritmetico implements IDominio{
	/**
	 * @param valores Conjunto de valores sobre los que
	 * probar un IIndividuo para calcular su fitness.
	 */
	private Map<Double, Double> valores;

	/**
	 * Define el conjunto de terminales de un IDominio
	 * 
	 * @param terminales terminales a anadir IDominio.
	 * @return Lista de terminales anadidos.
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales){
		List<Terminal>  lter = new ArrayList<>();
		for(String s: terminales) {
			Terminal t = new TerminalAritmetico(s);
			lter.add(t);
		}
		
		return lter;
	}
	
	/**
	 * Crea un conjunto de funciones a partir de los simbolos y el numero
	 * de argumentos de cada funcion. Acualmente las funciones solo pueden
	 * ser suma, resta y multiplicacion.
	 * 
	 * @param argumentos array del numero de arumentos que tiene cada funcion.
	 * @param funciones array con el simbolo de las funciones. Puede ser *, + o -.
	 * @return Lista con las funciones creadas.
	 * @throws ArgsDistintosFuncionesException si hay el numero de argumentos y
	 * de funciones no es el mismo.
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws
		ArgsDistintosFuncionesException{
		List<Funcion> lfun = new ArrayList<>();
		if(argumentos.length != funciones.length) {
			throw new ArgsDistintosFuncionesException();
		}
		
		for(int i = 0; i < funciones.length; i++) {
			Funcion fun;
			if(funciones[i].equals("+")) {
				fun = new FuncionSuma(argumentos[i]);
			}else if(funciones[i].equals("-")) {
				fun = new FuncionResta(argumentos[i]);
			}else {
				fun = new FuncionMultiplicacion(argumentos[i]);
			}
			
			lfun.add(fun);
		}
		
		return lfun;
	}
	
	/**
	 * Metodo que lee de fichero los valores que queremos dar a la funcion, junto
	 * con el valor esperado que deberia devolver.
	 * 
	 * @param ficheroDatos Localizacion del fichero del que leer los datos.
	 * @throws FilerException Si hay un problema con el fichero.
	 * @throws IOException Si el fichero no existe.
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(ficheroDatos)));
		valores = new TreeMap<>();
		String line;
		while((line = reader.readLine()) != null) {
			String value[] = line.split("\t");
			valores.put(Double.valueOf(value[0]), Double.valueOf(value[1]));
		}
		reader.close();
	}
	
	/**
	 * Dado un individuo, calcula su nivel de fitness usando los valores cargados
	 * mediante definirValoresPrueba.
	 * Evalua el IIndividuo en los puntos dados, si la diferencia en un punto
	 * con respecto al valor esperado, es menor que uno en valor absoluto,
	 * sumamos uno al fitness del individuo.
	 * 
	 * @param individuo IIndividuo cuyo nivel de fitness queremos calcular.
	 * @return double con el valor de fitness del individuo.
	 */
	public double calcularFitness(IIndividuo individuo) {
		double fitness = 0;
		if(valores == null) {
			System.out.println("Es necesario cargar los valores llamando a definirValoresPrueba para calcular el fitness.");
			return 0.0;
		}
		/*Recorremos la lista de valores y los vamos calculando*/
		for(Map.Entry<Double, Double> entry: this.valores.entrySet()) {
			Terminal.setValor(entry.getKey());
			double resultado = individuo.calcularExpresion();
			//TODO Descomentar para probar el TesterFitness
			//System.out.printf("Valor %.1f <-> Rdo estimado: %.1f <-> Rdo real: %.1f\n", entry.getKey(), resultado, entry.getValue());
			if(Math.abs(resultado-entry.getValue()) <= 1) {
				fitness ++;
			}
		}
		/*Aunque no se indica en el enunciado, actualizamos el individuo.*/
		individuo.setFitness(fitness);
		return fitness;
	}
	
	/**
	 * Funcion fitness ideada por nosotros.
	 * Dado un individuo, calcula su nivel de fitness usando los valores cargados
	 * mediante definirValoresPrueba. 
	 * Evalua el IIndividuo en los puntos dados y devuelve la media de la distancia
	 * entre la evaluacion del IIndividuo y la funcion pedida. De esta forma,
	 * permite analizar con mayor precision la validez del IIndividuo.
	 * 
	 * @param individuo IIndividuo cuyo nivel de fitness queremos calcular.
	 * @return double con el valor de fitness del individuo.
	 */
	public double calcularFitnessAvanzado(IIndividuo individuo) {
		double fitness = 0;
		int n = 0;
		if(valores == null) {
			System.out.println("Es necesario cargar los valores llamando a definirValoresPrueba para calcular el fitness.");
			return 0.0;
		}
		/*Recorremos la lista de valores y los vamos calculando*/
		for(Map.Entry<Double, Double> entry: this.valores.entrySet()) {
			Terminal.setValor(entry.getKey());
			double resultado = individuo.calcularExpresion();
			//TODO Descomentar para probar el TesterFitness
			//System.out.printf("Valor %.1f <-> Rdo estimado: %.1f <-> Rdo real: %.1f\n", entry.getKey(), resultado, entry.getValue());
			fitness += Math.abs(resultado-entry.getValue());
			n ++;
		}
		/*Aunque no se indica en el enunciado, actualizamos el individuo.*/
		individuo.setFitness(fitness/n);
		return fitness/n;
	}
}
