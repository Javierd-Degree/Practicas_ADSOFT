package Testers;

import java.io.FileNotFoundException;
import java.io.IOException;

import Algoritmo.Algoritmo;
import Algoritmo.IAlgoritmo;
import Dominio.DominioAritmetico;
import Dominio.IDominio;
import Excepciones.ArgsDistintosFuncionesException;

/**
* Clase que implementa el programa principal, probando asi la clase
* algoritmo para encontrar la funcion pedida en la practica.
* 
* @author Estuiante EPS Javier.delgadod@estudiante.uam.es
* @author Estuiante EPS Javier.lopezcano@estudiante.uam.es
*/
public class TesterAlgoritmo {
	
	/**
	 * Metodo main que nos permite probar el correcto funcionamiento
	 * de la clase algoritmo, y que funciona tambien como prueba de
	 * integracion, pues hace uso de todas clases programadas 
	 * anteriormente.
	 * 
	 * Cargamos los datos del archivo valores.txt y buscamos una funcion
	 * que cuadre con todos los puntos del fichero.
	 * 
	 * @param args Argumentos pasados a la funcion. No se utiliza.
	 * @throws FileNotFoundException Si el archivo de datos no existe.
	 * @throws IOException Si el archivo de datos no existe.
	 * @throws ArgsDistintosFuncionesException Si la longitud de
	 * los dos arrays que recibe domAritm.definirConjuntoFunciones
	 * no es la misma.
	 */
	public static void main(String... args) throws FileNotFoundException, IOException, ArgsDistintosFuncionesException {
		IDominio domAritm = new DominioAritmetico();
		domAritm.definirValoresPrueba("datos.txt");
		
		IAlgoritmo algoritmo = new Algoritmo(200, 4, 200);
		algoritmo.defineConjuntoFunciones(domAritm.definirConjuntoFunciones(new int[] {2, 2, 2}, new String[]{"*", "+", "-"}));
		algoritmo.defineConjuntoTerminales(domAritm.definirConjuntoTerminales(new String[] {"x"}));
		algoritmo.crearPoblacion();
		algoritmo.ejecutar(domAritm);
		
		/* Buscamos: ( + ( * ( * x x ) ( + x ( * x x ) ) ) ( + x ( * x x ) ) ) */
	}
}
