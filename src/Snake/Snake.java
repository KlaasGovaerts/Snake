package Snake;

/**
 * Describes the snake
 * @author Klaas Govaerts
 * 
 * 
 */
public class Snake{
private LinkedList<BodyPart> bodypartlist=new LinkedList<BodyPart>();
private Maze maze;
private boolean gameOver=false;

	/**
	 * Constructor for a new snake in the middle of the map.
	 * 
	 * @param maze A reference to the maze the snake will be part of.
	 */
	public Snake(Maze maze){
		this(maze,7,7);
	}
	
	/**
	 * Constructor for a snake with custom coordinates
	 * 
	 * @param maze A reference to the maze the snake will be part of.
	 * @param x The x coordinate of the spawn location
	 * @param y The y coordinate of the spawn location
	 */
	public Snake(Maze maze, int x, int y){
		this.maze=maze;
		BodyPart start=new BodyPart(x,y);
		bodypartlist.prepend(start);
	}
	
	/**
	 * Moves the snake in any given direction
	 * 
	 * @param direction The direction in which the snake will move. 1=up, 2=right, 3=down, 4=left
	 */
	private void move(int direction){
		BodyPart[] bodypartarray = bodypartlist.getElements(BodyPart[].class);
		int size=bodypartarray.length;
		BodyPart last=bodypartlist.last();
		int lastX=last.getX();
		int lastY=last.getY();
		for(int i=size-1;i>=1;i--){
			bodypartarray[i].setCoords(bodypartarray[i-1].getCoords());
		}
		BodyPart first=bodypartlist.first();
		int newX=first.getX();
		int newY=first.getY();
		switch(direction){
		case 1:newX=first.getX()-1;
		break;
		case 2:newY=first.getY()+1;
		break;
		case 3:newX=first.getX()+1;
		break;
		default:newY=first.getY()-1;
		}
		boolean foodFlag=false;
		if(maze.getFoodX()==newX&&maze.getFoodY()==newY){
			BodyPart newPart=new BodyPart(lastX,lastY);
			bodypartlist.append(newPart);
			foodFlag=true;
		}
		if(maze.collision(newX,newY)){
			System.out.println("Game Over");
			gameOver=true;
		}else{
		first.setX(newX);
		first.setY(newY);
		if(foodFlag){maze.generateFood();}
		maze.draw();
		}
	}
	
	/**
	 * Moves the snake up
	 */
	public void up(){
		move(1);
	}

	/**
	 * Moves the snake right
	 */
	public void right(){
		move(2);
	}
	
	/**
	 * Moves the snake down
	 */
	public void down(){
		move(3);
	}
	
	/**
	 * Moves the snake left
	 */
	public void left(){
		move(4);
	}
	
	public boolean isGameOver(){
		return gameOver;
	}
	
	/**
	 * 
	 * @return The LinkedList that contains the BodyParts of the snake.
	 */
	public LinkedList<BodyPart> getbodypartlist(){
		return bodypartlist;
	}
	
	/**
	 * 
	 * @return The first BodyPart of the snake
	 */
	public BodyPart getFirst(){
		return bodypartlist.first();
	}
}