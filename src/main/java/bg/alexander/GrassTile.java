package bg.alexander;

import org.apache.log4j.Logger;

/**
 * 
 * @author Alexander KIRILOV
 *
 */
public class GrassTile implements Visualizable{
	private final Logger log = Logger.getLogger(GrassTile.class);
	private YardObject object = null; 
	private boolean isCutDown;

	public GrassTile() {
		isCutDown = false;
	}
	
	public boolean isEmpty() {
		return object == null ? true : false;
	}

	public void setYardObject(YardObject object){
		this.object = object;
	}
	
	/**
	 * Gets the object and removes it from the current grass tile
	 * @return
	 */
	public YardObject retainYardObject(){
		YardObject toReturn = this.object;
		this.object = null;
		return toReturn;
	}
	
	public YardObject getYardObject(){
		return this.object;
	}
	
	/**
	 * Visualize an empty grass tile, or if any yard object is place on top - visualize it instead
	 */
	@Override
	public void visualize() {
		if(isEmpty()){
			if(isCutDown)
				System.out.print("| |");
			else
				System.out.print("|*|");
		}
		else{
			object.visualize();
		}
	}

	public boolean isCutDown() {
		return isCutDown;
	}

	public void cutGrass() {
		this.isCutDown = true;
	}
}
