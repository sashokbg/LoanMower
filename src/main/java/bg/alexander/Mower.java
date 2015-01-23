package bg.alexander;

import java.awt.Point;

import org.apache.log4j.Logger;

/**
 * Cette classe représente une tondeuse de peleuse qui implémente des movements basiques
 *  
 * @see YardObject
 * @author Alexander KIRILOV
 */
public class Mower extends YardObject implements Visualizable{
	private final Logger log = Logger.getLogger(Mower.class);
	private GrassField field;
	
	public Mower(Orientation orientation, Point point) {
		log.info("Created a new mower");
		setOrientation(orientation);
		setPosition(point);
	}
	
	/**
	 * Méthode primitive de visualisation.
	 * 
	 * Sysout est une mauvaise pratique et ne devrait pas être utilisé
	 */
	@Override
	public void visualize() {
		switch(super.getOrientatiaon()){
		case N: System.out.print("|\u2191|"); break;
		case E: System.out.print("|\u2192|"); break;
		case S: System.out.print("|\u2193|"); break;
		case W: System.out.print("|\u2190|"); break;
		}
	}

	public Orientation getOrientation() {
		return super.getOrientatiaon();
	}

	public void setOrientation(Orientation orientation) {
		super.setOrientatiaon(orientation);
	}

	@Override
	public YardObject turnLeft() throws UnsupportedOperationException {
		log.info("executing turn left command");
		super.setOrientatiaon(super.getOrientatiaon().previous());
		
		return this;
	}

	@Override
	public YardObject turnRight() throws UnsupportedOperationException {
		log.info("executing turn right command");
		super.setOrientatiaon(super.getOrientatiaon().next());
		
		return this;
	}
	
	@Override
	public YardObject move() {
		log.info("executing move command");
		Point currentPosition = super.getPosition();
		Point newPosition = null;
		
		switch(super.getOrientatiaon()){
		case N: newPosition = new Point(currentPosition.x,currentPosition.y+1); break;
		case E: newPosition = new Point(currentPosition.x+1, currentPosition.y); break;
		case W: newPosition = new Point(currentPosition.x-1, currentPosition.y); break;
		case S: newPosition = new Point(currentPosition.x, currentPosition.y-1); break;
		default: newPosition = currentPosition;
		}

		/*
		 * invoquer la méthode de mise à jour de position. C'est la responsabilité au champ
		 * de mettre à jour la position d'objet qui fait l'appel, uniquement si l'action est valide
		 */
		GrassTile tile = field.updateObjectPosition(currentPosition, newPosition);
		
		//car c'est une tondeuse, on coupe la peleuse
		if(null!=tile){
			tile.cutGrass();
		}
		
		//permet d'enchaîner des commandes
		return this;
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
