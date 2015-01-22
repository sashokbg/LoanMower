package bg.alexander;

import static bg.alexander.Orientation.*;

import java.awt.Point;

public class Launcher {
	public static void main(String[] args) {
		int xSize = 5;
		int ySize = 5;
		
		GrassField field = new GrassField(ySize,xSize);
		
		field.visualize();
		
		Mower mower1 = new Mower(N,new Point(0,0));
		field.setObject(mower1);
		Mower mower2 = new Mower(S,new Point(1,3));
		field.setObject(mower2);
		Tree t = new Tree(new Point(2,2));
		field.setObject(t);
		
		System.out.println("---------------");
		
		field.visualize();
		
		mower1.move(null);
		mower2.move(null);
		
		System.out.println("---------------");
		
		field.visualize();
		
		mower1.move(null);
		mower2.move(null);
		
		System.out.println("---------------");
		
		field.visualize();
		
	}
}
