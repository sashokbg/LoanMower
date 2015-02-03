package bg.alexander;

import static bg.alexander.Orientation.*;
import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;


public class RunAppTest {
	private int xSize = 6;
	private int ySize = 6;
	private GrassField field = null;
	
	@Before
    public void setUp() throws Exception {
		field = new GrassField(ySize,xSize);
    }
	
	@Test
	public void runMainTest(){
		//1 2 N
		Mower mower1 = new Mower(N,new Point(1,2));
		field.addObject(mower1);
		
		//GA GA GA GA A
		mower1.turnLeft().move()
			.turnLeft().move()
			.turnLeft().move()
			.turnLeft().move()
			.move();
		
		//1 3 N
		assertEquals(new Point(1,3),mower1.getPosition());
		assertEquals(N,mower1.getOrientation());
		
		//3 3 E
		Mower mower2 = new Mower(E, new Point(3,3));
		field.addObject(mower2);
		
		//AA DA AD AD DA
		mower2.move().move()
			.turnRight().move()
			.move().turnRight()
			.move().turnRight()
			.turnRight().move();
		
		//5 1 E
		assertEquals(new Point(5,1),mower2.getPosition());
		assertEquals(E,mower2.getOrientation());
	}

	@Test
	public void runOutOfMapTest(){
		Mower mower1 = new Mower(N,new Point(0,ySize-2));
		field.addObject(mower1);
		
		mower1.move();
		mower1.move();
		mower1.move();
		
		assertEquals(new Point(0,ySize-1), mower1.getPosition());
	}
	
	@Test
	public void runApplicationTest(){
		Mower mower1 = new Mower(N,new Point(0,0));
		field.addObject(mower1);
		Mower mower2 = new Mower(N,new Point(3,1));
		field.addObject(mower2);
		
		mower1.move();
		mower1.turnLeft();
		mower2.move();
		mower2.turnRight();
		
		mower1.move();
		mower1.turnLeft();
		mower2.move();
		mower2.turnRight();
		
		assertEquals(new Point(0,1),mower1.getPosition());
		assertEquals(new Point(4,2),mower2.getPosition());
	}
	
	@Test
	public void testVisualization(){
		field.visualize();
	}
	
	@Test 
	public void testObjectCollisionTeset(){
		field.visualize();
		Mower mower1 = new Mower(N,new Point(0,0));
		field.addObject(mower1);
		YardObject tree = new Tree(new Point(0,1));
		field.addObject(tree);
		
		mower1.move().move();
		field.visualize();
		mower1.turnRight().move();
		
		mower1.move();
		mower1.turnLeft();
		
		field.visualize();
	}
}
