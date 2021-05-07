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
	
	private void walk() {
		
	}
	public void act() {
	}
	
	private void sit() {
		
	}
	private void locateSeat() {
		
	}
	
	
}
