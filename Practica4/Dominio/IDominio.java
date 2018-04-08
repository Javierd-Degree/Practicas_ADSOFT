package Dominio;

import java.io.IOException;
import java.util.List;

import javax.annotation.processing.FilerException;

import Excepciones.ArgsDistintosFuncionesException;
import Individuo.IIndividuo;
import Nodo.Funcion.*;
import Nodo.Terminal;

public interface IDominio {
	
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws
	ArgsDistintosFuncionesException;
	public void definirValoresPrueba(String ficheroDatos) throws FilerException, IOException;
	public double calcularFitness(IIndividuo individuo);
}
