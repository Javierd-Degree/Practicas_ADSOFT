package Nodo.Funcion;

import Nodo.INodo;

public class FuncionSuma extends Funcion{
	
	public FuncionSuma(int nDescendientes) {
		super("+", nDescendientes);
	}
	
	@Override
	public INodo copy() {
		INodo copia = new FuncionSuma(this.nDescendientes);
		super.copiarDescendientes();
		
		return copia;
	}
	
	@Override
	public double calcular() {
		double a = this.getDescendientes().get(0).calcular();
		for(int i = 1; i < this.getDescendientes().size(); i++) {
			a += this.getDescendientes().get(i).calcular(); 
		}
		return a;
	}

}
