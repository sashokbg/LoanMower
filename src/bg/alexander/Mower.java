package bg.alexander;

import java.awt.Point;

public class Mower extends YardObject {
	private Orientation orientation;
	private GrassField field;
	
	public Mower(Orientation orientation, Point point) {
		setOrientation(orientation);
		setPosition(point);
	}
	
	@Override
	public void visualize() {
		switch(orientation){
		case N: System.out.print("|\u2191|"); break;
		case E: System.out.print("|\u2192|"); break;
		case W: System.out.print("|\u2190|"); break;
		case S: System.out.print("|\u2193|"); break;
		}
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public boolean move(MoveAction action) {
		Point currentPosition = super.getPosition();
		currentPosition.x = currentPosition.x+1;
		super.setPosition(currentPosition);
		return true;
	}

	public GrassField getField() {
		return field;
	}

	public void setField(GrassField field) {
		this.field = field;
	}
}
