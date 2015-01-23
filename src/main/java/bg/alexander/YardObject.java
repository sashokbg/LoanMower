package bg.alexander;

import java.awt.Point;

/**
 * Classe abstraite qui représente un objet de "cour" générique. Peut être placé sur un carré de pelouse {@link GrassTile}
 * 
 * @author Alexander KIRILOV
 * TODO If more complex commands are introduced a command pattern should be applied in order to better manage the commands
 */
public abstract class YardObject implements Visualizable{
	private Point position;
	private GrassField field;
	private Orientation orientatiaon;
	
	/**
	 * Mener une opération de déplecement (A) si la classe l'implémente
	 * @return
	 */
	public abstract YardObject move() throws UnsupportedOperationException;
	
	/**
	 * Mener une opération de tourner à gauche (G) si la classe l'implémente
	 * @return
	 */
	public abstract YardObject turnLeft() throws UnsupportedOperationException;
	
	/**
	 * Mener une opération de tourner à droite (D) si la classe l'implémente
	 * @return
	 */
	public abstract YardObject turnRight() throws UnsupportedOperationException;
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public GrassField getField() {
		return field;
	}
	public void setField(GrassField field) {
		this.field = field;
	}
	public Orientation getOrientatiaon() {
		return orientatiaon;
	}
	public void setOrientatiaon(Orientation orientatiaon) {
		this.orientatiaon = orientatiaon;
	}
}
