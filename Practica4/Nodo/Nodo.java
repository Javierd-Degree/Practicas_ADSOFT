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
}