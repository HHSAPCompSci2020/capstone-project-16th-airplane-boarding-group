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
		
		int extremeX = other.getX() + radius;
		int extrmeY = other.getY() + radius;
		
		int minX = other.getX() - radius;
		int minY = other.getY() - radius;
		
		int maxThisX = x + radius;
		int maxThisY = y + radius;
		
		int minThisX = x - radius;
		int minThisY = y - radius;
		
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
		
		
		return false;
		
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
