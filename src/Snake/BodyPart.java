package Snake;

//Een testklasse leek hier niet nuttig gezien deze klasse enkel set en get methoden bevat.

/**
 * Describes a part of the snake's body, with 2 coordinates.
 * @author Klaas Govaerts
 *
 */
public class BodyPart{
	private int x;
	private int y;
	
	/**
	 *  Constructor of a new BodyPart
	 * @param x the x coordinate of the BodyPart
	 * @param y the y coordinate of the BodyPart
	 */
	public BodyPart(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	/**
	 * 
	 * @return the x coordinate of the BodyPart
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * 
	 * @return the y coordinate of the BodyPart
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * 
	 * @return an array with both the x and y coordinate of the BodyPart
	 */
	public int[] getCoords(){
		int[] coords={x,y};
		return coords;
	}
	
	/**
	 * Sets the x coordinate
	 * 
	 * @param x
	 */
	public void setX(int x){
		this.x=x;
	}
	
	/**
	 * Sets the y coordinate
	 * 
	 * @param y
	 */
	public void setY(int y){
		this.y=y;
	}
	
	/**
	 * Sets both coordinates
	 * 
	 * @param coords an array with respectively the x and y coordinate
	 */
	public void setCoords(int[] coords){
		x=coords[0];
		y=coords[1];
	}
}
