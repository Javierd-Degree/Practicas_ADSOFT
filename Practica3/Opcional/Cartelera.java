import java.util.List;
import java.util.ArrayList;

public class Cartelera {
	private List<Pelicula> peliculas;
	
	public Cartelera() {
		peliculas = new ArrayList<>();
	}
	
	public boolean anadirPelicula(Pelicula p) {
		if(this.peliculas.contains(p)) {
			return false;
		}
		
		this.peliculas.add(p);
		return true;
	}
	
	public boolean quitarPelicula(Pelicula p) {
		if(this.peliculas.contains(p)) {
			this.peliculas.remove(p);
			return true;
		}
		return false;
	}
	
	public String toString() {
		String text = "";
		for(Pelicula pelicula : this.peliculas){
			text += pelicula + "\n\n";
		}
		return text;
	}
}
