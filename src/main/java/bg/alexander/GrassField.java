package bg.alexander;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import bg.alexander.GrassTile;
import bg.alexander.YardObject;

public class GrassField {
	private static Map<Point,GrassTile> grassTiles;
	private int xSize;
	private int ySize;

	/**
	 * Initiate a new square grass field, given size
	 * @param size
	 */
	public GrassField(int ySize,int xSize){
		setxSize(xSize);
		setySize(ySize);
		grassTiles = new HashMap<Point,GrassTile>();
		init();
	}
	
	private void init() {
		for(int i=0;i<ySize;i++){
			for(int j=0;j<xSize;j++){
				grassTiles.put(new Point(i,j), new GrassTile());
			}
		}
	}

	/**
	 * Will actually subscribe an object
	 * 
	 * 0:0 corresponds to bottom left corner
	 * @param object (containing its coordinates {@link YardObject})
	 */
	public void setObject(YardObject object){
		//register the field with the given yard object
		object.setField(this);
		Point location = object.getPosition();
		if(location.x<xSize && location.y<ySize){
			grassTiles.get(location).setYardObject(object);;
		}
	}
	
	/**
	 * Un-suscribe object *not yet implemented
	 * 
	 * @param object
	 */
	public void removeObject(YardObject object){
		//TODO unregister the grass field from the removed object
	}
	
	/**
	 * Updates the position of any {@link YardObject} from position currentPosition to newPosition
	 * 
	 * @return
	 * 
	 * false : If the tile at currentPosition is empty, then no movement is performed and the method returns false
	 * true : If the tile at currentPosition contains a movable yard object then it is moved (if no obstacles) and returns true
	 * 
	 * @param currentPosition
	 * @param newPosition
	 */
	public GrassTile notifyMovement(Point currentPosition, Point newPosition) {
		//TODO validations for out of range and obstacles
		YardObject objectToMove = grassTiles.get(currentPosition).retainYardObject();
		grassTiles.get(newPosition).setYardObject(objectToMove);
		
		//return the grass tile that we left, giving the possibility to perform an action on the tile (cut the grass)
		return grassTiles.get(currentPosition);
	}
	
	public void visualize(){
		for(int i=0;i<ySize;i++){
			for(int j=0;j<xSize;j++){
				grassTiles.get(new Point(j,(ySize-1)-i)).visualize();
			}
			System.out.println();
		}
	}
	
	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}
	
	@Override
	public String toString(){
		return "Grass Field : "+ySize+" by "+xSize;
	}
}
