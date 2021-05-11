import java.awt.Color;
import processing.core.PApplet;

public class Passenger {
	
	private int x, y;
	private int radius;
	private int speed;
	private int seatLocationX;
	private int seatLocationY;
	
	private boolean isSeated;
	
	public Passenger(int x, int y, int radius, Color boardingGroup, int seatLocationX, int seatLocationY) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.seatLocationX = seatLocationX;
		this.seatLocationY = seatLocationY;
		isSeated = false;
		
		speed = (int)((Math.random() * 10) +1);
	}
	
	public void draw(PApplet marker) {
		marker.fill(0);
		marker.circle(x, y, radius);
	}
	
	private void walk(int seatX, int seatY) 
	{
		if(seatX> x) {
			x = x + speed;
		}
		
		if(seatX == x) {
			if(seatY > y) {
				y = y + speed;
			}
			else if(seatY < y) {
				y = y - speed;
			}
			else {
				isSeated = true;
			}
		}
		
	}
	public void act(int seatX, int seatY, Passenger other) {
		if(!isColliding(other))
			walk(seatX,  seatY);

	}
	
	
	private void locateSeat() {
		if(isSeated==false) {
			this.walk(seatLocationX,seatLocationY);
			isSeated = true;
		}
		
	}
	
	private boolean isColliding(Passenger other) {
		boolean isColliding = false;
		int sideOther = 2 * other.getRadius();
		int xOther = other.getX() -  other.getRadius();
		int yOther = other.getY() -  other.getRadius();
		
		int side = 2 * radius;
		int rectX = x -radius;
		int rectY =  y - radius;
		
		
		return isColliding;
	}
	
	public int getRadius() {
		return radius;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
