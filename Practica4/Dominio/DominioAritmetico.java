package Dominio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Excepciones.ArgsDistintosFuncionesException;
import Individuo.IIndividuo;
import Nodo.Terminal;
import Nodo.Funcion.Funcion;

public class DominioAritmetico implements IDominio{
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private Map<Double, Double> valores;

	public List<Terminal> definirConjuntoTerminales(String... terminales){
		this.terminales = new ArrayList<>();
		
		return this.terminales;
	}
	
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws
	ArgsDistintosFuncionesException{
		if(argumentos.length != funciones.length) {
			throw new ArgsDistintosFuncionesException();
		}
		
		this.funciones = new ArrayList<Funcion>();
		
		return this.funciones;
	}
	
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(ficheroDatos)));
		valores = new HashMap<>();
		String line;
		while((line = reader.readLine()) != null) {
			String value[] = line.split("\t");
			valores.put(Double.valueOf(value[0]), Double.valueOf(value[1]));
		}
		reader.close();
	}
	
	public double calcularFitness(IIndividuo individuo) {
		double fitness = 0;
		/*Recorremos la lista de valores y los vamos calculando*/
		for(Map.Entry<Double, Double> entry: this.valores.entrySet()) {
			/*TODO Calculamos el valor, que no se como se hace*/
			double resultado = -9999999.1;
			System.out.printf("Valor %.1f <-> Rdo estimado: %.1f <-> Rdo real: %.1f", entry.getKey(), entry.getValue(), resultado);
			if(Math.abs(resultado-entry.getValue()) <= 1) {
				fitness ++;
			}
		}
		return fitness;
	}
}
