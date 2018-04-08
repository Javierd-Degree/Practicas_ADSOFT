package Nodo.Funcion;

import Nodo.INodo;
import Nodo.Nodo;

public class Funcion extends Nodo{
	private int nDescendientes;
	
	public Funcion(Object simbolo, int nDescendientes) {
		super(simbolo);
		this.nDescendientes = nDescendientes;
	}
	
	@Override
	public INodo copy() {
		INodo copia = new Funcion(simbolo, nDescendientes);
		for(INodo nodo: this.descendientes) {
			copia.incluirDescendiente(nodo.copy());
		}
		
		return copia;
	}
	
	@Override
	public double calcular() {
		double result = 0.0;
		for(INodo descendiente: this.descendientes) {
			result += descendiente.calcular();
		}
		return result;
	}
	
	@Override
	public void incluirDescendiente(INodo nodo) {
		if(this.descendientes.size() == nDescendientes) {
			return;
		}
		
		this.descendientes.add(nodo);
	}
	
	@Override
	public String toString() {
		String result = "( "+this.simbolo+" ";
		for(INodo nodo: this.descendientes) {
			result += nodo;
		}
		return result + ") ";
	}
}
