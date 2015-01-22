package bg.alexander;

import java.awt.Point;

import org.apache.log4j.Logger;

public class Mower extends YardObject {
	private final Logger log = Logger.getLogger(Mower.class);
	
	private Orientation orientation;
	private GrassField field;
	
	public Mower(Orientation orientation, Point point) {
		log.info("Created a new mower");
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
	
	@Override
	public String toString(){
		return "Mower at "+super.getPosition();
	}
}
