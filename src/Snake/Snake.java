package Snake;


public class Snake{
private LinkedList<BodyPart> bodypartlist=new LinkedList<BodyPart>();
private Maze maze;

	public Snake(Maze maze){
		this.maze=maze;
		BodyPart start=new BodyPart(7,7);
		bodypartlist.prepend(start);
	}
	
	public void up(){
		BodyPart[] bodypartarray = bodypartlist.getElements(BodyPart[].class);
		int size=bodypartarray.length;
		BodyPart last=bodypartlist.last();
		int lastX=last.getX();
		int lastY=last.getY();
		for(int i=size-1;i>=1;i--){
			bodypartarray[i].setCoords(bodypartarray[i-1].getCoords());
		}
		BodyPart first=bodypartlist.first();
		first.setX(first.getX()-1);
		int firstX=first.getX();
		int firstY=first.getY();
		if(maze.getFoodX()==firstX&&maze.getFoodY()==firstY){
			BodyPart newPart=new BodyPart(lastX,lastY);
			bodypartlist.append(newPart);
			maze.removeFood();
		}
		if(maze.collision(firstX,firstY)){
			System.out.println("Game Over");
		}else{
		maze.draw();
		}
	}
	
	public void move(){
		
	}
	
	public LinkedList<BodyPart> getbodypartlist(){
		return bodypartlist;
	}
}

/*
Sources used:
http://stackoverflow.com/questions/4522090/how-can-i-detect-arrow-keys-in-java

*/