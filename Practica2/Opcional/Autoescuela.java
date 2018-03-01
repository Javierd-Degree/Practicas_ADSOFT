/**
 * Esta clase implementa una autoescuela, perteneciente a una cadena
 * tal y como se explica en la segunda practica.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

import java.util.*;

public class Autoescuela{
	private int codigo;
	private String direccion;
	private String encargado;
	private List<Profesor> profesores;

	
	/** 
	 * Constructor completo
   	 * @param codigo Numero de identificacion de la autoescuela
   	 * @param direccion Direccion de la autoescuela
   	 * @param encargado Nombre del encargado de la autoescuela
   	 */
	public Autoescuela(int codigo, String direccion, String encargado){
		this.codigo = codigo;
		this.direccion = direccion;
		this.encargado = encargado;
		this.profesores = new ArrayList<>();
	}

	/** 
	 * Añade un profesor a la lista de profesores de la autoescuela
   	 * @param p Profesor que se añade a la autoescuela
   	 */
	public void anadirProfesor(Profesor p){
		this.profesores.add(p);
	}

	/** 
	 * Getter de direccion
   	 * @return Dirección de la autoescuela
   	 */
	public String getNombre(){
		return direccion;
	}
}


