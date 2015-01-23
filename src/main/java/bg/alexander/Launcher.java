package bg.alexander;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Un launcher primitif, permettant d'exécuter l'application à partir d'un jar exécutable, en fournissant un fichier
 * de commandes à l'entrée.
 * 
 * Nécessite le chemin complet vers le fichier
 * 
 * <br />
 * Le syntax:
 * 
 * <br />
 * 
 * <ul>
 * <li>La première ligne correspond aux coordonnées du coin supérieur droit de la pelouse, celles 
 * du coin inférieur gauche sont supposées être (0,0)</li>
 * <li> La suite du fichier permet de piloter toutes les tondeuses qui ont été déployées. Chaque 
 * tondeuse a deux lignes la concernant :</li>
 * <li> la première ligne donne la position initiale de la tondeuse, ainsi que son orientation. La 
 * position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre, séparés par un espace</li>
 * <li> la seconde ligne est une série d'instructions ordonnant à la tondeuse d'explorer la 
 * pelouse. Les instructions sont une suite de caractères sans espaces.</li>
 * </ul>
 * 
 * 
 * @author Alexander KIRILOV
 */
public class Launcher {
	private static final Logger log = Logger.getLogger(Launcher.class);
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File(args[0]));
			String line = scan.nextLine();
			Scanner lineScan = new Scanner(line);
			
			int xSize = lineScan.nextInt();
			int ySize = lineScan.nextInt();
			
			GrassField field = new GrassField(ySize+1, xSize+1);
		
			//init mowers
			while(scan.hasNextLine()){
				String positionLine = scan.nextLine();
				String actionsLine = scan.nextLine();
				
				lineScan = new Scanner(positionLine);
				Point position = new Point(lineScan.nextInt(),lineScan.nextInt());
				Orientation orientation = Orientation.valueOf(lineScan.next());
				
				Mower mower = new Mower(orientation, position);
				field.addObject(mower);
				
				lineScan.close();
				lineScan = new Scanner(actionsLine);
				
				String commands = lineScan.next();
				for(char c: commands.toCharArray()){
					switch(c){
					case 'D': mower.turnRight() ; break;
					case 'G': mower.turnLeft() ; break;
					case 'A': mower.move(); break;
					}
				}
				
				log.info("All commands executed");
				log.info("Position: "+mower.getPosition());
				log.info("Orientation: "+mower.getOrientation());
				
				lineScan.close();
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
