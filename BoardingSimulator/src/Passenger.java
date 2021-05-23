import java.awt.Color;
import processing.core.PApplet;
import java.util.concurrent.*;
public class Passenger {
	
	private int x, y;
	private final int RADIUS = 50;
	private int speed;
	private Color passengerColor;
	private boolean isSeated;
	private int seatX,seatY;
	
	private int i;
	
	public Passenger(int x, int y,Color passengerColor) {
		this.x = x;
		this.y = y;
		this.passengerColor=passengerColor;
		
		isSeated = false;
		i = 0;
		speed = 2;
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
			if(i == 0) {
				speed = 1;
				i++;
			}
			if(seatY > y) {
				y = y + speed;
				i++;
			}
			else if(seatY < y) {
				if(i == 0) {
					speed = 1;
				}
				y = y - speed;
			}
			else {
				isSeated = true;
			}
		}
		
	}
	public void act(int seatX, int seatY) {
		walk(seatX,  seatY);

	}
	
	
	private void locateSeat(int seatLocationX, int seatLocationY) {
		if(isSeated==false) {
			this.walk(seatLocationX,seatLocationY);
			isSeated = true;
		}
		
	}
	
	public boolean isColliding(Passenger other) {
		boolean isColliding = false;
		
		int extremeX = other.getX() + RADIUS;
		int extrmeY = other.getY() + RADIUS;
		
		int minX = other.getX() - RADIUS - 2;
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
	public int getSeatX() {
		return seatX;
	}
	public void setSeatX(int x) {
		seatX = x;
	}
	public int getSeatY() {
		return seatY;
	}
	public void setSeatY(int y) {
		seatY = y;
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public int getSpeed() {
		return speed;
	}
	
	public boolean getIsSeated() {
		return isSeated;
	}
}
