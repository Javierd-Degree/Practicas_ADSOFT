package Simulador;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public abstract class Subject {
	private List<Observer> observer = new ArrayList<>();
	
	public void addObserver(Observer o) {
		this.observer.add(o);
	}
	
	public void notificar() {
		this.observer.forEach(o -> o.actualizar());
	}
}
