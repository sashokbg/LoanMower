package bg.alexander;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import bg.alexander.GrassTile;
import bg.alexander.YardObject;

/**
 * 
 * @author Alexander KIRILOV
 *
 */
public class GrassField {
	private static Map<Point,GrassTile> grassTiles;
	private int xSize;
	private int ySize;
	private final Logger log = Logger.getLogger(GrassField.class);

	/**
	 * Initiate a new square grass field, given size
	 * @param size
	 */
	public GrassField(int ySize,int xSize){
		setxSize(xSize);
		setySize(ySize);
		grassTiles = new HashMap<Point,GrassTile>();
		init();
		log.info("Created a new grass field with size: "+xSize+" - "+ySize);
	}
	
	private void init() {
		for(int i=0;i<ySize;i++){
			for(int j=0;j<xSize;j++){
				grassTiles.put(new Point(i,j), new GrassTile());
			}
		}
	}

	/**
	 * Add a yard object to the field
	 * 
	 * 0:0 corresponds to bottom left corner
	 * @param object (containing its coordinates {@link YardObject})
	 */
	public void addObject(YardObject object){
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
	 * @return The grassTile. Can be null
	 * 
	 * @param yardObject
	 * @param newPosition
	 */
	public GrassTile updatePosition(Point position, Point newPosition) {
		GrassTile grassTile = grassTiles.get(position);
		if(grassTile!=null){
			YardObject yardObject = grassTile.getYardObject();
			if(yardObject!=null){
				GrassTile newGrassTile = grassTiles.get(newPosition);
				if(newGrassTile!=null){
					newGrassTile.setYardObject(yardObject);
					//at this point we can safly update the position of the yardObject
					yardObject.setPosition(newPosition);
					grassTile.retainYardObject();
				}
			}
		}
		
		//return the grass tile that we left, giving the possibility to perform an action on the tile (cut the grass)
		return grassTile;
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
