package bg.alexander;

import java.awt.Point;

public abstract class YardObject {
	private Point position;
	private GrassField field;
	
	/**
	 * Primitive ASCII visualization
	 */
	public abstract void visualize();
	/**
	 * Perform a move operation on the object if it supports it
	 * @param action
	 * @return
	 */
	public abstract boolean move(MoveAction action) throws UnsupportedOperationException;
	
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
}
