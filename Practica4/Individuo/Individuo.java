package Individuo;

import java.util.List;

import Nodo.Funcion.Funcion;
import Nodo.INodo;
import Nodo.Terminal;

public class Individuo implements IIndividuo{
	private INodo expresion;
	public double fitness;
	
	@Override
	public INodo getExpresion() {
		return this.expresion;
	}

	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
		
	}

	@Override
	public double getFitness() {
		return this.fitness;
	}

	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;
		
	}

	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularExpresion() {
		return expresion.calcular();
	}

	@Override
	public int getNumeroNodos() {
		if(expresion == null) {
			return 0;
		}
		return expresion.numNodos();
	}

	@Override
	public void writeIndividuo() {
		System.out.println(expresion);
	}

}
