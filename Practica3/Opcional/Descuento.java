/**
* Enumeracion con los tipos de descuentos disponibles para una entrada.
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/

public enum Descuento{
	DIA_ESPECTADOR("Día del espectador", 0.2), ESTUDIANTE("Estudiante", 0.3),
	TERCERA_EDAD("Tercera edad", 0.40), FIESTA("Día festivo", 0.1);

	Descuento(String n, double v){
		nombre = n;
		valor = v;
	}

	private final String nombre;
	private final double valor;
	
	public double getValor() {
		return this.valor;
	}
	
	public String toString() {
		return this.nombre;
	}
}

