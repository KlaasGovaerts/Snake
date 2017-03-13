package Snake;

public class Application {

	public static void main(String[] args) {
		Maze maze=new Maze();
		Snake snake=new Snake(maze);
		maze.addSnake(snake);
		maze.draw();
		//snake.up();
	}
}
