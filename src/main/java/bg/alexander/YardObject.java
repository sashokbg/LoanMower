package bg.alexander;

import java.awt.Point;

/**
 * Abstract class representing a generic yard object that supports basic operations like moving and turning
 * 
 * @author Alexander KIRILOV
 * TODO If more complex commands are introduced a command pattern should be applied in order to better manage the commands
 */
public abstract class YardObject implements Visualizable{
	private Point position;
	private GrassField field;
	private Orientation orientatiaon;
	
	/**
	 * Perform a move operation on the object if it supports it
	 * @return
	 */
	public abstract YardObject move() throws UnsupportedOperationException;
	
	/**
	 * Perform a turnLeft operation on the object if it supports it
	 * @return
	 */
	public abstract YardObject turnLeft() throws UnsupportedOperationException;
	
	/**
	 * Perform a turnRight operation on the object if it supports it
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
