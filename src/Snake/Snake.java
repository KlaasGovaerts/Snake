package Snake;


public class Snake{
private LinkedList<BodyPart> bodypartlist=new LinkedList<BodyPart>();
private Maze maze;

	public Snake(Maze maze){
		this.maze=maze;
		BodyPart start=new BodyPart(9,5);
		bodypartlist.prepend(start);
	}
	
	public void up(){
		BodyPart[] bodypartarray = bodypartlist.getElements(BodyPart[].class);
		int size=bodypartarray.length;
		for(int i=size-1;i>=1;i--){
			bodypartarray[i].setCoords(bodypartarray[i-1].getCoords());
		}
		BodyPart first=bodypartlist.first();
		first.setX(first.getX()-1);
		maze.draw();
	}
	
	public void move(){
		
	}
	
	public LinkedList<BodyPart> getbodypartlist(){
		return bodypartlist;
	}
	
	public void generateFood(){
		
	}
}

/*
Sources used:
http://stackoverflow.com/questions/4522090/how-can-i-detect-arrow-keys-in-java

*/