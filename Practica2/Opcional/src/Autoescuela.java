/**
 * Esta clase implementa una autoescuela, perteneciente a una cadena
 * tal y como se explica en la segunda practica.
 * Contiene los atributos minimos para ejecutarse como se 
 * pide en el ejercicio opcional.
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

	/** 
	 * Main que inicializa 2 Autoescuelas y 2 Profesores para probar el funcionamiento de las clases
   	 * @param args Array de strings que el usuario pasa por teclado (se ignora)
   	 */
	public static void main(String[] args) {
		Autoescuela a1 = new Autoescuela(1, "Arenal", "Juan Pedro Jimenez");
		Autoescuela a2 = new Autoescuela(2, "Cordoba", "Miguel Angel");
		EtapaTrabajo e1 = new EtapaTrabajo(new Fecha(2015, 12, 1), 
			new Fecha(2016, 3, 25), a1);

		Profesor p1 = new Profesor("3141243T","Carlos","Pascual", "666666666", "123456", 2.5,
			900, a1, null);
		Profesor p2 = new Profesor("9876543Q","Antonio","Perez Garcia", "777777777", "123456", 2.5,
			900, a1, new ArrayList<EtapaTrabajo>(Arrays.asList(e1)));
	
		System.out.println(p1.getHistorial());
		System.out.println(p2.getHistorial());	
	}
}


