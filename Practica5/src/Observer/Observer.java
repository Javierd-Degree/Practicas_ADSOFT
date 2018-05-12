package Observer;

import Simulador.Subject;

public abstract class Observer {
	protected Subject subject;
	
	public Observer(Subject s) {
		this.subject = s;
		this.subject.addObserver(this);
	}
	
	public abstract void actualizar();
	
	public Subject getSubject() {
		return this.subject;
	}
	
	public abstract String toString();
}
