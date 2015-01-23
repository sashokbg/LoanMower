package bg.alexander;

/**
 * Interface marquant des objets qui peuvent être visualisés
 * 
 * @author Alexander KIRILOV
 */
public interface Visualizable {
	/**
	 * Primitive ASCII visualization using System.out
	 * 
	 * Note that this is a bad practice and this method should be implemented properly,
	 * depending on the visualization technology
	 */
	public void visualize();
}
