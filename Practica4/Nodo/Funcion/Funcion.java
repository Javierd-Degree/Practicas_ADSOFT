package Nodo.Funcion;

import Nodo.INodo;
import Nodo.Nodo;

public abstract class Funcion extends Nodo{
	protected int nDescendientes;
	
	public Funcion(Object simbolo, int nDescendientes) {
		super(simbolo);
		this.nDescendientes = nDescendientes;
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
	
	public void copiarDescendientes() {
		for(INodo nodo: this.descendientes) {
			this.incluirDescendiente(nodo.copy());
		}
	}
}
