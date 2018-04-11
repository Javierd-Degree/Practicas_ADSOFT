package Nodo;

public abstract class Terminal extends Nodo{
	private static Double valor;
	
	public Terminal(Object simbolo) {
		super(simbolo);
	}
	
	public static void setValor(double valor) {
		Terminal.valor = valor;
	}
	
	@Override
	public double calcular() {
		return valor;
	}
}
