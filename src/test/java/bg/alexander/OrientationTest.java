package bg.alexander;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrientationTest {
	@Test
	public void testNextPrevious(){
		Orientation o = Orientation.N;
		
		assertTrue(o.next() == Orientation.E);
		assertTrue(o.next().next() == Orientation.S);
		assertTrue(o.next().next().next() == Orientation.W);
		assertTrue(o.next().next().next().next() == Orientation.N);
		assertTrue(o.next().next().next().next().next() == Orientation.E);
		
		assertTrue(o.previous() == Orientation.W);
		assertTrue(o.previous().previous() == Orientation.S);
		assertTrue(o.previous().previous().previous() == Orientation.E);
		assertTrue(o.previous().previous().previous().previous() == Orientation.N);
		assertTrue(o.previous().previous().previous().previous().previous() == Orientation.W);
	}
}
