package Snake;
import java.util.Arrays;
import java.lang.Math;
//Math wordt geimporteerd wegens random
/**
 * Describes the map of the game (currently there are only walls).
 * @author Klaas Govaerts
 *
 * 
 */
public class Maze {
	private char[][] mazeMatrix;
	private Snake snake;
	private int rijen=15;
	private int kolommen=15;
	private int foodX=5;
	private int foodY=7;
	
	/**
	 * Constructor of a standard map with a wall on all sides.
	 */
	public Maze(){
		mazeMatrix=new char[rijen][kolommen];
		for(int i=0;i<rijen;i++){
			for(int j=0;j<kolommen;j++){
				mazeMatrix[i][j]=' ';
			}
			System.out.println("");
		}
		for(int i=0;i<rijen;i++){
			mazeMatrix[i][0]='#';
			mazeMatrix[i][kolommen-1]='#';
		}
		for(int i=0;i<kolommen;i++){
			mazeMatrix[0][i]='#';
			mazeMatrix[rijen-1][i]='#';
		}
	}
	
	/**
	 *
	 * @return string with the state of the board
	 */
	public String toString(){
		String output="";
		char [][] temporaryMatrix = new char[mazeMatrix.length][];
		for(int i = 0; i < mazeMatrix.length; i++){
			temporaryMatrix[i] = mazeMatrix[i].clone();			
		}
		BodyPart[] bodypartarray = snake.getbodypartlist().getElements(BodyPart[].class);
		for(BodyPart p:bodypartarray){
			temporaryMatrix[p.getX()][p.getY()]='*';
		}
		temporaryMatrix[foodX][foodY]='+';
		for(int i=0;i<rijen;i++){
			for(int j=0;j<kolommen;j++){
				output+=temporaryMatrix[i][j];
			}
			output+="\n";
		}
		return output;
	}

	/**
	 * Prints the maze and snakes to the console
	 */
	public void draw(){
		System.out.print(toString());
	}
	
	
	/**
	 * Creates a reference to the snake.
	 * 
	 * @param snake
	 */
	public void addSnake(Snake snake){
		this.snake=snake;
	}
	
	/**
	 * Generate food in a random location on the map (not in the wall or snake)
	 */
	public void generateFood(){
		do {
			foodX= (int) (Math.random()*rijen);
			foodY= (int) (Math.random()*kolommen);
			} while (collision(foodX,foodY));
		}
	
	/**
	 * 
	 * @return The x coordinate of the food
	 */
	public int getFoodX(){
		return foodX;
	}
	
	/**
	 * 
	 * @return The y coordinate of the food
	 */
	public int getFoodY(){
		return foodY;
	}
	
	/**
	 * Sets the x coordinate of the food
	 * 
	 * @param foodX
	 */
	public void setFoodX(int foodX){
		this.foodX=foodX;
	}
	
	/**
	 * Sets the Y coordinate of the food
	 * 
	 * @param foodY
	 */
	public void setFoodY(int foodY){
		this.foodY=foodY;
	}
	
	/**
	 * Checks if there is a collision with the snake or the wall
	 * 
	 * @param x The x coordinate to check
	 * @param y The y coordinate to check
	 * @return true if collision
	 */
	public boolean collision(int x,int y){
		boolean collision=true;
		BodyPart[] bodypartarray=snake.getbodypartlist().getElements(BodyPart[].class);
		if(mazeMatrix[x][y]==' '){
			collision=false;
			for(BodyPart p:bodypartarray){
				if(x==p.getX()&&y==p.getY()){
					collision=true;
				}
			}
		}
		return collision;
	}
}


/*
http://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java
*/