package bg.alexander;

import java.awt.Point;

/**
 * 
 * @author Alexander KIRILOV
 *
 */
public class Tree extends YardObject implements Visualizable{

	public Tree(Point position) {
		setPosition(position);
	}
	
	@Override
	public void visualize() {
		System.out.print("|T|");
	}

	@Override
	public YardObject move() {
		throw new UnsupportedOperationException("Trees cannot move. Unless Tree is an Ent");
	}

	@Override
	public YardObject turnLeft() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Trees cannot turn. Unless Tree is an Ent");
	}

	@Override
	public YardObject turnRight() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Trees cannot turn. Unless Tree is an Ent");
	}
}
