import java.awt.Color;
import processing.core.PApplet;

public class Passenger {
	
	private int x, y;
	private final int RADIUS = 20;
	private int speed;
	private Color passengerColor;
	private boolean isSeated;
	
	public Passenger(int x, int y,Color passengerColor) {
		this.x = x;
		this.y = y;
		this.passengerColor=passengerColor;
		
		isSeated = false;
		
		speed = 10;
	}
	
	public void draw(PApplet marker) {
		marker.fill(0);
		marker.circle(x, y, RADIUS);
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
	
	
	private void locateSeat(int seatLocationX, int seatLocationY) {
		if(isSeated==false) {
			this.walk(seatLocationX,seatLocationY);
			isSeated = true;
		}
		
	}
	
	private boolean isColliding(Passenger other) {
		boolean isColliding = false;
		
		int extremeX = other.getX() + RADIUS;
		int extrmeY = other.getY() + RADIUS;
		
		int minX = other.getX() - RADIUS;
		int minY = other.getY() - RADIUS;
		
		int maxThisX = x + RADIUS;
		int maxThisY = y + RADIUS;
		
		int minThisX = x - RADIUS;
		int minThisY = y - RADIUS;
		
		if(((maxThisX<=extremeX && maxThisX>=minX)
			||(minThisX<=extremeX && minThisX>=minX))
			&&((maxThisY<=extrmeY && maxThisY>=minY)
			||(minThisY<=extrmeY && minThisY>=minY))) {
			
			isColliding = true;
		}
		return isColliding;
	}
	
	private boolean isSpawning(Passenger next) {
		int passX = next.getX();
		int passY = next.getY();
		
		int distance = 70;
		
		
		
		return false;
		
	}
	
	public int getRadius() {
		return RADIUS;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Color getColor() {
		return passengerColor;
	}
}
