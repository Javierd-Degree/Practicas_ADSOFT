/**
 * Esta aplicacion calcula el triangulo de tartaglia de n filas.
 *
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
*/

public class Tartaglia{
	private Combinatoria c;
	private int n;

	public Tartaglia(Combinatoria c, int n){
		this.c = c;
		this.n = n;
	}

	/**
	 * Devuelve el triangulo de tartaglia de n filas como un string
	 * @return valor del coeficiente binomial (n, k)
	*/
	public String toString(){
		String result = "";
		for(int i = 0; i < this.n; i++){
			for(int j = 0; j <= i; j++){
				result += c.combinaciones(i, j) + "\t";
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Punto de entrada a la aplicacion.
	 * 
	 * <p>Este metodo imprime el valor del coeficiente binomial de los 2 parametros de entrada</p>
	 *
	 * @param args Los argumentos de la linea de comando. Se esperan dos numeros enteros, como cadenas
	*/
   public static void main(String[] args) {
      if (args.length!=1) {
    	  System.out.println("Se espera un numero como parametro, n.");
    	  System.out.println("  n = Numero de filas del triangulo.");
    	  System.out.println("Devuelve el triangulo de tartaglia de n filas.");
      }
      else {
    	  int n  = Integer.parseInt(args[0]);   // convertimos String a int
    	  Combinatoria c = new Combinatoria();  // Creamos un objeto c de tipo Combinatoria
    	  Tartaglia t = new Tartaglia(c, n); 	// Creamos un objeto t de tipo tartaglia
    	  System.out.println(t); // Imprimimos una linea por salida estandar
      }
   }
}