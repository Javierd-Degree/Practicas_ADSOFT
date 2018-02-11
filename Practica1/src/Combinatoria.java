import java.util.*;

/**
 * Esta aplicacion calcula el numero de combinaciones sin repeticion de n elementos
 * tomados de k en k.
 * <p>La implementacion es recursiva, basada en c(n, k) = c(n-1, k-1) + c(n-1, k) 
 * Los casos base son c(n, 0) = 1 = c(n, n)  y c(n, k) = 0 para todo k mayor que n</p> 
 * <p><b>Nota</b>: Hemos implementado una cache como se pedia en el apartado cinco
 * para que el caculo sea mas eficiente.</p>
 * 
 * @author Estudiante EPS Javier.delgadod@estudiante.uam.es
 * @author Estudiante EPS Javier.lopezcano@estudiante.uam.es
 *
 */
public class Combinatoria {  
  
  private Map<Integer, Long> cache = new HashMap<>();
  /* 
   * Si la clase tuviera atributos, los declarariamos aqui, como
   * private Tipo1 atributo1;
   * private Tipo2 atributo2;
   * ...
   * Tambien se pueden inicializar al declararlos, por ejemplo
   * private int contador= 0;
   * El valor inicial tambien se puede asignar en el constructor
   */ 
	
  /**
   * Ejemplo de constructor, en esta clase seria innecesario, ya que no tiene argumentos
   * ni inicializa atributos. El compilador crea uno igual si no existe.
   * Es importante que no devuelva nada (tampoco void), y que se llame como la clase.
   * Si fuese privado impediria crear objetos de este tipo desde otras clases.
   */
  public Combinatoria(/* Argumentos para construir el objeto, si los hubiera */) {
	  /* Esta clase no tiene atributos, por lo que este constructor vacio lo crearia
	   * automaticamente el compilado, y no es necesario
	   * Si tenemos un atributo (atributo1) con el mismo nombre que un argumento, podemos usar
	   * "this.atributo1" para referirnos al atributo, y "atributo1" para el argumento
	   * Por ejemplo podemos asignar el valor inicial con:
	   * this.atributo1 = atributo1; 
	   */
  }

  /**
   * Devuelve el numero de combinaciones posibles de n elementos tomados de k en k
   * @param n Numero de elementos totales
   * @param k Numero de elementos, sin repeticion, en cada combinacion
   * @return valor del coeficiente binomial (n, k)
   */
  public long combinaciones(int n, int k){
    long result;
    //Primero comprobamos si los argumentos son validos
    if (n<0 || k <0) throw new IllegalArgumentException("n y k han de ser positivos");

    //Comprobamos si esta o no calculado
    if(cache.containsKey(posicion(n, k))){
      return cache.get(posicion(n, k));
    }

    //No esta calculado, usamos la definicion recursiva
    //Casos base
    else if (k == 0 || n==k ) result =  1; //Caso base para 1
    else if (k > n) result = 0; //Caso base para 0
    //Caso general
    else result =  combinaciones(n-1, k-1) + combinaciones (n-1, k);
      
    cache.put(posicion(n, k), result);
    return result;
  }
 
  /**
   * Devuelve la posicion en triangulo de tartaglia del numero combinatorio (n k)
   * @param n Numero de elementos totales
   * @param k Numero de elementos, sin repeticion, en cada combinacion
   * @return posicion en triangulo de tartaglia del numero combinatorio (n k)
   */
  private int posicion(int n, int k){
    if(n < 0) return -1;
    if(k < 0 || k > n) return -1;

    return n*(n+1)/2 + k;

  }
  
  /**
   * Punto de entrada a la aplicacion.
   * 
   * <p>Este metodo imprime el valor del coeficiente binomial de los 2 parametros de entrada</p>
   *
   * @param args Los argumentos de la linea de comando. Se esperan dos numeros enteros, como cadenas
   */
   public static void main(String[] args) {
      if (args.length!=2) {
    	  System.out.println("Se espera dos numero como parametro, n y k.");
    	  System.out.println("  n = Numero total de elementos ");
    	  System.out.println("  k = Elementos en cada combinacion");
    	  System.out.println("Devuelve el coeficiente binomial(n, k)");
      }
      else {
    	  int n  = Integer.parseInt(args[0]);   // convertimos String a int
    	  int k  = Integer.parseInt(args[1]);   // convertimos String a int
    	  Combinatoria c = new Combinatoria();  // Creamos un objeto c de tipo Combinatoria
    	  System.out.println(c.combinaciones(n, k)); // Imprimimos una linea por salida estandar
    	  // En java la destruccion de objetos es automatica
      }
   }
}