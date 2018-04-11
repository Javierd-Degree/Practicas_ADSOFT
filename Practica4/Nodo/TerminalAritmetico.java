package Nodo;

public class TerminalAritmetico extends Terminal{

	public TerminalAritmetico(Object simbolo) {
		super(simbolo);
	}
	
	@Override
	public INodo copy() {
		/*Un terminal no puede tener hijos.*/
		INodo copia = new TerminalAritmetico(simbolo);
		
		return copia;
	}
}
