package Algoritmo;

import java.util.List;

import Dominio.IDominio;
import Excepciones.ArgsDistintosFuncionesException;
import Excepciones.CruceNuloException;
import Individuo.IIndividuo;
import Nodo.Terminal;
import Nodo.Funcion.Funcion;

public interface IAlgoritmo {
	public void defineConjuntoTerminales(List<Terminal> terminales);
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
	public void crearPoblacion();
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;
	public void crearNuevaPoblacion();
	public void ejecutar(IDominio dominio);
}
