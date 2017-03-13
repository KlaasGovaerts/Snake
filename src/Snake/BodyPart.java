package Snake;

public class BodyPart{
	private int x;
	private int y;
	
	public BodyPart(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int[] getCoords(){
		int[] coords={x,y};
		return coords;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public void setCoords(int[] coords){
		x=coords[0];
		y=coords[1];
	}
}
