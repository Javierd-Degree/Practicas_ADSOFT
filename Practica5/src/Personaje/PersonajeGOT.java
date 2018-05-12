package Personaje;

public class PersonajeGOT {
	private String nombre;
	private String casa;
	
	public PersonajeGOT(String nombre, String casa) {
		this.nombre = nombre;
		this.casa = casa;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getCasa() {
		return casa;
	}
	
	@Override 
	public String toString() {
		return nombre+", de la casa "+casa;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof PersonajeGOT)) {
			return false;
		}
		
		PersonajeGOT p = (PersonajeGOT) o;
		return p.casa.equals(this.casa) && p.nombre.equals(this.nombre);
	}
}
