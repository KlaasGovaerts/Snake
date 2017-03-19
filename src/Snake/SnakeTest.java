package Snake;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.lang.Object;

public class SnakeTest extends GenericTest{
	@Test
	public void testSnake() {
		assertEquals(first.getX(),13);
		assertEquals(first.getY(),13);
		
	}

	@Test
	public void testUp() {
		snake.up();
		assertEquals(first.getX(),12);
		assertEquals(first.getY(),13);
		assertEquals(bodypartlist.size(),2);
		assertFalse(maze.getFoodX()==12);
		assertFalse(maze.getFoodY()==13);
	}

	@Test
	public void testRight() {
		snake.right();
		assertTrue(snake.isGameOver());
	}

	@Test
	public void testDown() {
		snake.down();
		assertTrue(snake.isGameOver());
	}

	@Test
	public void testLeft() {
		snake.left();
		assertEquals(first.getX(),13);
		assertEquals(first.getY(),12);
		assertFalse(snake.isGameOver());
		
	}

}
