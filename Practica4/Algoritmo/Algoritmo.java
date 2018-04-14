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

public class Algoritmo implements IAlgoritmo{
	private List<Terminal> terminales;
	private List<Funcion> funciones;
	private List<IIndividuo> poblacion;
	
	private int numIndividuos;
	private int profundidad;
	private int numGeneraciones;
	private int porcentajeFijo = 20;
	
	public Algoritmo(int numIndividuos, int profundidad, int numGeneraciones) {
		this.numIndividuos = numIndividuos;
		this.profundidad = profundidad;
		this.numGeneraciones = numGeneraciones;
	}
	
	@Override
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		this.terminales = terminales;
	}

	@Override
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		this.funciones = funciones;
	}

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
	 * Segundo metodo de cruce que probamos, vamos a usar algo parecido a la seleccion
	 * natural. Nos quedamos con la mejor mitad de los individuos, y los cruzamos entre
	 * ellos.
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
	
	
	/* TODO Borrar
	 * Primer metodo de cruce que probamos, no funciona muy bien.*/
	public void crearNuevaPoblacion2() {
		/* Nos quedamos con los mejores individuos. Del resto, cruzamos la mitad, los mejores,
		 * y el resto los borramos.*/
		List<IIndividuo> poblacion2 = new ArrayList<>();
		int numFijos = (int) (poblacion.size()*((double)this.porcentajeFijo/100));
		int numBorrar = (int) (poblacion.size()*((double)(100 - this.porcentajeFijo)/200));
		/* Incluimos los mejores */
		poblacion2.addAll(this.poblacion.subList(0, numFijos));
		
		/* Incluimos la mitad del resto */
		poblacion2.addAll(this.poblacion.subList(numFijos, poblacion.size()-numBorrar-1));
		
		/* Incluimos los hijos de dicha mitad, juntandolos de forma aleatoria */
		List<IIndividuo> temp = poblacion.subList(numFijos, poblacion.size()-numBorrar);
		for(int i = 0; i< temp.size(); i++) {
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
		
		this.poblacion.clear();
		this.poblacion = poblacion2;
	}

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
				/*ind.writeIndividuo();
				System.out.println(": "+ind.getFitness());*/
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
			
			double fit = poblacion.get(0).getFitness(), n = 0;
			if(fit == 0.0) {
				break;
			}
			/**for(IIndividuo ind: poblacion) {
				if(ind.getFitness() != fit && fit < 1000) {
					System.out.println("Hay "+n+" individuos con fitness "+fit);
					fit = ind.getFitness();
					n = 0;
				}
				n++;
			}*/
			
			crearNuevaPoblacion();
		}
		
	}

}
