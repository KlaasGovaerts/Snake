/**
 * 
 */
package Snake;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Klaas Govaerts
 *
 *Tests for Maze class
 */
public class MazeTest extends GenericTest{
	/**
	 * Test method for {@link Snake.Maze#Maze()}.
	 */
	@Test
	public void testMaze() {
		assertEquals(maze.getFoodX(),12);
		assertEquals(maze.getFoodY(),13);
	}

	/**
	 * Test method for {@link Snake.Maze#toString()}.
	 */
	@Test
	public void testToString() {
		snake.left();
		assertEquals(maze.toString(),"###############\n#             #\n#             #\n#             #\n#             #\n#             #\n#             #\n#             #\n#             #\n#             #\n#             #\n#             #\n#            +#\n#           * #\n###############\n");
	}
	
	//Omdat toString reeds getest word, moet de draw methode niet apart getest worden.

	//De generate food methode wordt niet getetst omdat het voedsel op een willekeurige locatie spawnt.

	/**
	 * Test method for {@link Snake.Maze#collision(int, int)}.
	 */
	@Test
	public void testCollision() {
		assertTrue(maze.collision(13, 13));
		assertTrue(maze.collision(0,0));
		assertTrue(maze.collision(0,10));
		assertFalse(maze.collision(5, 5));
	}

}
