package Individuo;

import java.util.List;

import Nodo.Funcion;
import Nodo.INodo;
import Nodo.Terminal;

public class Individuo implements IIndividuo{
	private INodo expresion;
	
	
	public Individuo(INodo expresion) {
		this.expresion = expresion;
	}
	
	@Override
	public INodo getExpresion() {
		return expresion;
	}

	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;
		
	}

	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFitness(double fitness) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeIndividuo() {
		System.out.println(expresion.getRaiz());
	}

}
