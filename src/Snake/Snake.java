package Snake;


public class Snake {

	public static void main(String[] args) {
		LinkedList<BodyPart> snake=new LinkedList<BodyPart>();
		BodyPart start=new BodyPart(5,5);
		snake.prepend(start);
		Snake.draw(snake);
		}


	public static void draw(LinkedList<BodyPart> snake){
		int rijen=10;
		int kolommen=10;
		int[][] spelbord=new int[rijen][kolommen];
		BodyPart[] bodyparts = snake.getElements(BodyPart[].class);
		for(BodyPart p:bodyparts){
			spelbord[p.getX()][p.getY()]=1;
		}
		for(int i=0;i<rijen;i++){
			for(int j=0;j<kolommen;j++){
				System.out.print(spelbord[i][j]);
			}
			System.out.println("");
		}
	}
}