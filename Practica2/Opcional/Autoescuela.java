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

	
	/*Constructor completo*/
	/*TODO Completar con @params etc*/
	public Autoescuela(int codigo, String direccion, String encargado){
		this.codigo = codigo;
		this.direccion = direccion;
		this.encargado = encargado;
		this.profesores = new ArrayList<>();
	}

	public void anadirProfesor(Profesor p){
		this.profesores.add(p);
	}

	public String getNombre(){
		return direccion;
	}
}


