/**
 * Esta clase implementa una fecha.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class Fecha{
	private int anyo;
	private int mes;
	private int dia;

	/** 
	 * Constructor completo
   	 * @param anyo Año de la fecha
   	 * @param mes Mes de la fecha
   	 * @param dia Dia de la fecha
   	 */
	public Fecha(int anyo, int mes, int dia){
		this.anyo = anyo;
		this.mes = mes;
		this.dia = dia;

	}

	/** 
	 * Función que comprueba si la fecha existe o no (incluyendo años bisiestos)
   	 * @return Un boolean que si es true indica que la fecha es valida y si es false indica que la fecha es erronea
   	 */
	public boolean isFechaValida(){
		/*Comprobamos que el mes es válido*/
		if(mes > 12 || mes < 1) return false;
		if(dia < 1) return false;

		/*Meses con 31 días*/
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
			if(dia > 31) return false;
		}

		/*Meses con 31 días*/
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
			if(dia > 30) return false;
		}

		/*Febrero, teniendo en cuenta años bisiestos*/
		if(mes == 2 && anyo % 4 == 0){
			if(dia > 29) return false;
		}else if( mes == 2){
			if(dia > 28) return false;
		}

		return true;
	}

	/** 
	 * Crea un string con la fecha
   	 * @return String con la fecha
   	 */
	public String toString(){
		return anyo+"-"+mes+"-"+dia;
	}
}