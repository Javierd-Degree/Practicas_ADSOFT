import java.io.FileNotFoundException;
import java.io.IOException;

import Algoritmo.Algoritmo;
import Algoritmo.IAlgoritmo;
import Dominio.DominioAritmetico;
import Dominio.IDominio;
import Excepciones.ArgsDistintosFuncionesException;

public class TesterAlgoritmo {
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
