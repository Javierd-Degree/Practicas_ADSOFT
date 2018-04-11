package Nodo;

import java.util.ArrayList;
import java.util.List;

public abstract class Nodo implements INodo{

	/*Usando un objeto como símbolo conseguimos que sea lo
	 * mas generico posible.*/
	protected Object simbolo;
	protected List<INodo> descendientes;
	
	public Nodo(Object simbolo) {
		this.simbolo = simbolo;
		descendientes = new ArrayList<>();
	}
	
	@Override
	public String getRaiz() {
		return simbolo.toString();
	}
	
	@Override
	public List<INodo> getDescendientes(){
		return this.descendientes;
	}
	
	@Override
	public void incluirDescendiente(INodo nodo) {
		this.descendientes.add(nodo);
	}
	
	@Override
	public String toString() {
		return ""+simbolo+" ";
	}
	
	/**
	 * Metodo que, dado un INodo, cuenta de forma recursiva el numero total 
	 * de nodos que hay, incluyendose a si mismo.
	 * 
	 * @return numero de nodos que hay.
	 * */
	public int numNodos() {
		int total = 1;
		for(INodo hijo: descendientes) {
			total += hijo.numNodos();
		}
		return total;
	}
}