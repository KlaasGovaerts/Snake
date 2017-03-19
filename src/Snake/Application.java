package Snake;

public class Application {
/**
 * A demonstration of the snake moving up, eating food and colliding into a wall.
 * Output will go to console.
 * @param args Has no effect
 * @author Klaas Govaerts
 */
	public static void main(String[] args) {
		Maze maze=new Maze();
		Snake snake=new Snake(maze);
		maze.addSnake(snake);
		maze.draw();
		for(int i=0;i<7;i++){
		snake.up();
		}
	}
}
