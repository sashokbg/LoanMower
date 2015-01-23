package bg.alexander;

import org.apache.log4j.Logger;

/**
 * Cette classe represente un carré de peleuse qui peut contenir un objet de type {@link YardObject}
 * 
 * @author Alexander KIRILOV
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
	 * Renvoie l'objet et le set à null. (get and remove)
	 * 
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
	 * Visualiser un champ de peleuse. Si le champ contient un objet - le visualiser à ça place 
	 * Sysout est une mauvaise pratique est ne devrait pas être utilisé
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
		log.info("Cutting down grass");
		this.isCutDown = true;
	}
}
