package Nodo.Funcion;

public class FuncionSuma extends Funcion{
	
	public FuncionSuma() {
		super("+", 2);
	}
	
	@Override
	public double calcular() {
		double a = Double.parseDouble(this.getDescendientes().get(0).getRaiz());
		double b = Double.parseDouble(this.getDescendientes().get(1).getRaiz());
		return a+b;
	}

}
