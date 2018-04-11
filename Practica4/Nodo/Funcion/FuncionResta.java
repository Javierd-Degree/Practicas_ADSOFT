package Nodo.Funcion;

import Nodo.INodo;

public class FuncionResta extends Funcion{
	
	public FuncionResta(int nDescendientes) {
		super("-", nDescendientes);
	}
	
	@Override
	public INodo copy() {
		INodo copia = new FuncionResta(this.nDescendientes);
		super.copiarDescendientes();
		
		return copia;
	}
	
	@Override
	public double calcular() {
		double a = this.getDescendientes().get(0).calcular();
		for(int i = 1; i < this.getDescendientes().size(); i++) {
			a -= this.getDescendientes().get(i).calcular(); 
		}
		return a;
	}

}
