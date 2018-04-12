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
import Nodo.Funcion.Funcion;

/**
* Clase DominioAritmetico que implementa la interfaz IDominio.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class DominioAritmetico implements IDominio{
	/**
	 * @param terminales Lista de terminales del dominio.
	 */
	private List<Terminal> terminales;
	
	/**
	 * @param funciones Lista de funciones del Dominio.
	 */
	private List<Funcion> funciones;
	
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
		this.terminales = new ArrayList<>();
		
		return this.terminales;
	}
	
	/**
	 * Define el conjunto de funciones de un IDominio.
	 * 
	 * TODO Completar
	 * 
	 * @param argumentos array de int que tienen las funciones como argumentos.
	 * @param 
	 * @return
	 * @throws ArgsDistintosFuncionesException
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws
	ArgsDistintosFuncionesException{
		if(argumentos.length != funciones.length) {
			throw new ArgsDistintosFuncionesException();
		}
		
		this.funciones = new ArrayList<Funcion>();
		
		return this.funciones;
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
			System.out.printf("Valor %.1f <-> Rdo estimado: %.1f <-> Rdo real: %.1f\n", entry.getKey(), resultado, entry.getValue());
			if(Math.abs(resultado-entry.getValue()) <= 1) {
				fitness ++;
			}
		}
		/*Aunque no se indica en el enunciado, actualizamos el individuo.*/
		individuo.setFitness(fitness);
		return fitness;
	}
}
