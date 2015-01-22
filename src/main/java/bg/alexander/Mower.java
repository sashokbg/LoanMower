package bg.alexander;

import java.awt.Point;

import org.apache.log4j.Logger;

public class Mower extends YardObject implements Visualizable{
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
		Point newPosition = null;
		
		switch(orientation){
		case N: newPosition = new Point(currentPosition.x,currentPosition.y+1); break;
		case E: newPosition = new Point(currentPosition.x+1, currentPosition.y); break;
		case W: newPosition = new Point(currentPosition.x-1, currentPosition.y); break;
		case S: newPosition = new Point(currentPosition.x, currentPosition.y-1); break;
		default: newPosition = currentPosition;
		}

		//update the position of the YardObject only if the GrassField returns true (valid move)
		GrassTile tile = field.notifyMovement(currentPosition, newPosition);
		if(null!=tile){
			super.setPosition(newPosition);
			tile.cutGrass();
			return true;
		}
		//Move operation failed
		return false;
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
