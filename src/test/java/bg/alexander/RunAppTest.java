package bg.alexander;

import java.awt.Point;
import org.junit.Test;

import static bg.alexander.Orientation.*;

public class RunAppTest {
	
	@Test
	public void runApplication(){
		int xSize = 5;
		int ySize = 5;
		
		GrassField field = new GrassField(ySize,xSize);
		
		field.visualize();
		
		Mower mower1 = new Mower(N,new Point(0,0));
		field.setObject(mower1);
		Mower mower2 = new Mower(S,new Point(3,1));
		field.setObject(mower2);
		
		System.out.println("---------------");
		
		field.visualize();
		
		mower1.move(null);
		
		System.out.println("---------------");
		
		field.visualize();
	}
	
}
