package bg.alexander;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

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
			grassTiles.get(location).set(object);;
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
	
	void notifyMovement(YardObject object){
		
	}
	
	public void visualize(){
		for(int i=0;i<ySize;i++){
			for(int j=0;j<xSize;j++){
				grassTiles.get(new Point((ySize-1)-i,j)).visualize();
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
