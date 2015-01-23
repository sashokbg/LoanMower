package bg.alexander;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import bg.alexander.GrassTile;
import bg.alexander.YardObject;

/**
 * Cette classe represente un champ de pelouse, divisé en carrés de pelouse de type {@link GrassField}
 * Chaque carré de pelouse peut contenir un objet de type {@link YardObject}
 * 
 * Les coordonnées 0 0 (x,y) représentent le coin inférieur gauche du champ 
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
	 * Créer un nouveau champ de taille ySize,xSize. Si xSize = 5, xMax = 4 (on compte à partir de 0) 
	 * 
	 * @param ySize
	 * @param xSize
	 */
	public GrassField(int ySize,int xSize){
		setxSize(xSize);
		setySize(ySize);
		grassTiles = new HashMap<Point,GrassTile>();
		init();
		log.info("Created a new grass field with size: "+xSize+" - "+ySize);
	}
	
	/**
	 * Permet de remplir le chemps de carrés de pelouse vides
	 */
	private void init() {
		for(int i=0;i<ySize;i++){
			for(int j=0;j<xSize;j++){
				grassTiles.put(new Point(i,j), new GrassTile());
			}
		}
	}

	/**
	 * Ajouter un objet de type {@link YardObject} à ce champ
	 * 
	 * L'objet lui même est responsable de sa position
	 *  
	 * @param object
	 */
	public void addObject(YardObject object){
		//s'assurer que l'objet connait this champ
		object.setField(this);
		Point location = object.getPosition();
		if(location.x<xSize && location.y<ySize){
			grassTiles.get(location).setYardObject(object);;
		}
		log.info("Added a new object to field : "+object);
	}
	
	/**
	 * Enlever un objet. Pas encore implémenté
	 * 
	 * @param object
	 */
	public void removeObject(YardObject object){
		//TODO unregister the grass field from the removed object
	}
	
	/**
	 * Mettre à jour la position d'un objet {@link YardObject} de sa <b>currentPosition</b> à sa <b>newPosition</b>
	 * 
	 * @param position
	 * @param newPosition
	 * @return Le carré correspondant à <b>currentPosition</b>
	 */
	protected GrassTile updateObjectPosition(Point position, Point newPosition) {
		GrassTile grassTile = grassTiles.get(position);
		if(grassTile!=null){
			YardObject yardObject = grassTile.getYardObject();
			if(yardObject!=null){
				GrassTile newGrassTile = grassTiles.get(newPosition);
				if(newGrassTile!=null){
					newGrassTile.setYardObject(yardObject);
					//à ce point on peut mettre à jour la position de l'objet déplacé
					log.info("moving: "+yardObject+" to: "+newPosition);
					yardObject.setPosition(newPosition);
					grassTile.retainYardObject();
				}
			}
		}
		
		//return le carré de pelouse qu'on a quitté, donnant la possibilité de mener une action (couper la pelouse par exemple)
		return grassTile;
	}
	
	/**
	 * La méthode de visualisation est uniquement pour tester.
	 * 
	 * Sysout est une mauvaise pratique et ne devrait pas être utilisé
	 */
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
