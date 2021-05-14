import java.awt.Color;
import processing.core.PApplet;
public class Seats 
{
	
	private Color BoardingColor;
	private float x,y;
	private float sideLength;
	private boolean seatTaken;
	/**
	 * Initializes the seat object with given parameters
	 * @param x x location of the seat
	 * @param y y location of the seat
	 * @param sideLength the length of the seat(seat itself is a square)
	 */
	public Seats(float x,float y,float sideLength,boolean seatTaken)
	{
		this.x=x;
		this.y=y;
		this.sideLength=sideLength;
		seatTaken=false;
		BoardingColor=Color.WHITE;
		
	}
	/**
	 * Draws the seat to the given Processing PApplet
	 * @param marker Processing PApplet on which to draw the shape
	 */
	public void draw(PApplet marker)
	{
		marker.fill(BoardingColor.getRed(),BoardingColor.getBlue(),BoardingColor.getGreen());
		marker.square(x,y,sideLength);
	}

	/**
	 * when clicked on the boarding group menu, the value of boarding group color is updated accordingly to the user input
	 */
	public void setBoardingGroup() {
		
		
	}
	/**
	 * changes the value of seatTaken when the array is taken by a passenger
	 */
	public void setSeatTaken() {
		
		seatTaken=true;
	}
	/**
	 * 
	 * @return seatTaken: wheter the seat is taken or not
	 */
	public boolean getSeatTaken() {
		return seatTaken;
	}
	/**
	 * 
	 * @param mouseX: the x coordinate of where the mouse is clicked
	 * @param mouseY: the y coordinate of where the mouse is clicked
	 * @return returns true if the mouse clicked is inside the specific seat or not
	 */
	public boolean seatClicked(int mouseX,int mouseY)
	{
		if(mouseX > x&& mouseX < (sideLength + x) && mouseY > y && mouseY < (y+sideLength))
		{
			System.out.println("seat clicked");
			return true;
		}
		else
			return false;
	}
	
	
}
