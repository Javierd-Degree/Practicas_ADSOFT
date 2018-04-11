package Nodo;

import java.util.List;

public interface INodo {
	public String getRaiz();
	public List<INodo> getDescendientes();
	public void incluirDescendiente(INodo nodo);
	public double calcular();
	public INodo copy();
	/* Metodo anadido por nosotros que
	 * nos permite contar el numero
	 * de nodos de un INodo.*/
	public int numNodos();
}