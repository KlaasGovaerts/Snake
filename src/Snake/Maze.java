package Snake;
import java.util.Arrays;


public class Maze {
	private char[][] mazeMatrix;
	private Snake snake;
	int rijen=10;
	int kolommen=10;
	
	public Maze(){
		mazeMatrix=new char[rijen][kolommen];
		for(int i=0;i<rijen;i++){
			for(int j=0;j<kolommen;j++){
				mazeMatrix[i][j]=' ';
			}
			System.out.println("");
		}
	}
	
	public void draw(){
		char [][] temporaryMatrix = new char[mazeMatrix.length][];
		for(int i = 0; i < mazeMatrix.length; i++){
			temporaryMatrix[i] = mazeMatrix[i].clone();			
		}
		BodyPart[] bodypartarray = snake.getbodypartlist().getElements(BodyPart[].class);
		for(BodyPart p:bodypartarray){
			temporaryMatrix[p.getX()][p.getY()]='1';
		}
		for(int i=0;i<rijen;i++){
			for(int j=0;j<kolommen;j++){
				System.out.print(temporaryMatrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void addSnake(Snake snake){
		this.snake=snake;
	}
}


/*
http://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java
*/