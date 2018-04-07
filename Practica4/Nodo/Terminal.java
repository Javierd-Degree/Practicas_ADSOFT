package Nodo;

public class Terminal extends Nodo{

	public Terminal(Object simbolo) {
		super(simbolo);
	}

	@Override
	public double calcular() {
		/*TODO: Que devolvemos¿?*/
		return 0.0;
	}

	@Override
	public INodo copy() {
		INodo copia = new Terminal(simbolo);
		for(INodo nodo: this.descendientes) {
			copia.incluirDescendiente(nodo.copy());
		}
		
		return copia;
	}
	
}
