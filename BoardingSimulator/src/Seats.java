import java.awt.Color;
import processing.core.PApplet;
public class Seats 
{
	
	private Color BoardingColor;
	private float x,y;
	private float sideLength;
	private boolean seatTaken;
	public Seats(float x,float y,float sideLength)
	{
		this.x=x;
		this.y=y;
		this.sideLength=sideLength;
		seatTaken=false;
		BoardingColor=Color.WHITE;
		
	}
	public void draw(PApplet marker)
	{
		marker.fill(BoardingColor.getRed(),BoardingColor.getBlue(),BoardingColor.getGreen());
		marker.square(x,y,sideLength);
	}
	
	public void setBoardingGroupNames() {
		
	}
	
	public void setBoardingGroup() {
		
	}
	
	
	
}
