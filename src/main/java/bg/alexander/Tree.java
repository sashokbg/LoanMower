package bg.alexander;

import java.awt.Point;

public class Tree extends YardObject implements Visualizable{

	public Tree(Point position) {
		setPosition(position);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void visualize() {
		System.out.print("|T|");
	}

	@Override
	public boolean move(MoveAction action) {
		throw new UnsupportedOperationException("Trees cannot move. Unless Tree is Ent");
	}
}
