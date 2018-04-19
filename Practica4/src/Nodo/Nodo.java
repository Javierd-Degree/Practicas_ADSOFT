package Nodo;

import java.util.ArrayList;
import java.util.List;

/**
* Clase abstracta Nodo que implemente la interfaz INodo, 
* permitiendonos asi crear implementaciones de algunas de
* las funciones que son exactamente iguales en todos los tipos
* de nodos.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public abstract class Nodo implements INodo{

	/**
	 * @param simbolo Simbolo del Nodo. 
	 * Usando un objeto como símbolo conseguimos que sea lo
	 * mas generico posible.*/
	protected Object simbolo;
	
	/**
	 * @param descendientes Lista de descencientes del Nodo.
	 */
	protected List<INodo> descendientes;
	
	/**
	 * @param etiqueta Etiqueta del nodo.
	 */
	protected int etiqueta = -1;
	
	/**
	 * Constructor por defecto de la clase Nodo.
	 * 
	 * @param simbolo simbolo del Nodo a crear
	 */
	public Nodo(Object simbolo) {
		this.simbolo = simbolo;
		descendientes = new ArrayList<>();
	}
	
	/**
	 * Metodo que devuelve la raiz de un INodo como
	 * un String.
	 * 
	 * @return String con la raiz del Nodo.
	 */
	@Override
	public String getRaiz() {
		return simbolo.toString();
	}
	
	/**
	 * Metodo que devuelve la lista de descendientes de un INodo.
	 * 
	 * @return List<INodo> con los descendientes del INodo.
	 */
	@Override
	public List<INodo> getDescendientes(){
		return this.descendientes;
	}
	
	/**
	 * Metodo que permite anadir un descenciente a un Nodo.
	 * 
	 * @param nodo INodo descenciente a anadir.
	 */
	@Override
	public void incluirDescendiente(INodo nodo) {
		this.descendientes.add(nodo);
	}
	
	/**
	 * Metodo que devuelve un String que nos permite
	 * reconocer a un Nodo.
	 * 
	 * @return String que describe al Nodo.
	 */
	@Override
	public String toString() {
		return ""+simbolo+" ";
	}
	
	/**
	 * Metodo que, dado un INodo, cuenta de forma recursiva el numero total 
	 * de nodos que hay, incluyendose a si mismo.
	 * 
	 * @return numero de nodos que hay, incluyendose a si mismo.
	 * */
	public int numNodos() {
		int total = 1;
		for(INodo hijo: descendientes) {
			total += hijo.numNodos();
		}
		return total;
	}
	
	/**
	 * Metodo que permite etiquetar a un Nodo y todos sus descendientes, con
	 * enteros del cero al numero total de nodos menos 1.
	 */
	public void etiquetaNodos() {
		etiquetar(0);
	}
	
	/**
	 * Metodo recursivo usado por etiquetarNodo que nos permite etiquetar
	 * todos los descendentes de un nodo sin repeticiones.
	 * 
	 * @param etiqueta etiqueta a asignar a dicho nodo.
	 * @return siguiente etiqueta que estaria disponible.
	 */
	public int etiquetar(int etiqueta) {
		this.etiqueta = etiqueta;
		int e = etiqueta;
		//System.out.println(e + " "+this);
		for(INodo hijo: descendientes) {
			e = hijo.etiquetar(e+1);
		}
		return e;
	}
	
	/**
	 * Getter de la etiqueta del nodo. Si no ha sido inicializada
	 * devuelve -1.
	 * 
	 * @return etiqueta del nodo o -1.
	 */
	public int getEtiqueta() {
		return this.etiqueta;
	}
	
	
	/**
	 * Metodo que permite encontrar un Nodo dentro de los
	 * descendientes de otro, de forma recursiva, usando su 
	 * etiqueta.
	 * 
	 * @param etiqueta etiqueta del nodo que estamos buscando.
	 * @return INodo buscado, o null si no se encuentra.
	 */
	public INodo buscarNodo(int etiqueta) {
		if(etiqueta == this.etiqueta) {
			return this;
		}
		
		INodo e;
		for(INodo hijo: descendientes) {
			if((e = hijo.buscarNodo(etiqueta)) != null) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Metodo recursivo que permite reemplazar el INodo cuya etiqueta se pasa
	 * como parametro, por el INodo pasado.
	 * 
	 * @param etiqueta int con la etiqueta del nodo a reemplazar.
	 * @param sustituto INodo que queremos poner en la posicion
	 * del anterior.
	 * @return parametro usado por la recursion que se puede ignorar.
	 */
	public boolean reemplazarNodo(int etiqueta, INodo sustituto) {
		if(etiqueta == this.etiqueta) {
			return true;
		}
		
		INodo hijo;
		int posicion = -1;
		for(int i = 0; i < descendientes.size(); i++) {
			hijo = descendientes.get(i);
			/* Si lo encontramos, lo reemplazamos y listo.*/
			if(hijo.reemplazarNodo(etiqueta, sustituto) == true) {
				//System.out.println("Hijo encontrado: "+ hijo);
				posicion = i;
				break;
			}
		}
		
		if(posicion != -1) {
			descendientes.remove(descendientes.get(posicion));
			descendientes.add(posicion, sustituto);
		}
		
		return false;
	}
	
}