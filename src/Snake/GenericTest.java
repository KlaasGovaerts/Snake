/**
 * 
 */
package Snake;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * @author Klaas Govaerts
 *
 *Both test classes extend this one
 */
public class GenericTest {
	protected Maze maze;
	protected Snake snake;
	protected BodyPart first;
	protected LinkedList<BodyPart> bodypartlist;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		maze=new Maze();
		snake=new Snake(maze,13,13);
		maze.addSnake(snake);
		first=snake.getbodypartlist().first();
		bodypartlist=snake.getbodypartlist();
		maze.setFoodX(12);
		maze.setFoodY(13);
	}
}
