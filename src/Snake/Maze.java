package Snake;
import java.util.Arrays;
import java.lang.Math;
//Math wordt geimporteerd wegens random

public class Maze {
	private char[][] mazeMatrix;
	private Snake snake;
	int rijen=15;
	int kolommen=15;
	int foodX=5;
	int foodY=7;
	
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
	
	public void draw(){
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
				System.out.print(temporaryMatrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void addSnake(Snake snake){
		this.snake=snake;
	}
	
	public void removeFood(){
		foodX=0;
		foodY=0;
	}
	
	public void generateFood(){
		boolean collision=true;
		BodyPart[] bodypartarray=snake.getbodypartlist().getElements(BodyPart[].class);
		while(collision){
			int x= (int) Math.random()*rijen;
			int y= (int) Math.random()*kolommen;
			if(mazeMatrix[x][y]==' '){
				collision=false;
				/*for(BodyPart p:bodypartarray){
					if(x==p.getX()&&y==p.getY()){
						collision=true;
					}
				}*/
			}
		}
	}
	
	public int getFoodX(){
		return foodX;
	}
	
	public int getFoodY(){
		return foodY;
	}
	
	public boolean collision(int x,int y){
		return mazeMatrix[x][y]=='#';
	}
}


/*
http://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java
*/