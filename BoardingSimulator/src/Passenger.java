import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;

import processing.core.PApplet;

import java.util.concurrent.*;
public class Passenger extends PApplet{
	//a
	private int x, y;
	private final int RADIUS = 50;
	private int  speed;
	private Color passengerColor;
	private boolean isSeated;
	private int seatX,seatY;
	private int delay = 0;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	processing.core.PImage photo; 
	public Passenger(int x, int y,Color passengerColor) {
		this.x = x;
		this.y = y;
		this.passengerColor=passengerColor;
		
		setSeated(false);
	
		speed = 2;
	}
	
	public void draw(PApplet marker) {
		
		marker.fill(255,69,0);
		marker.circle(x, y, RADIUS);
		if(isSeated())
		{
			marker.fill(255,215,0);
			marker.circle(x,y,RADIUS/2);
		
		}
		
	}

	private void walk(int seatX, int seatY) 
	{		
		if(seatX - 5<= x && x <= seatX + 5) {
			x = seatX;
			if(delay == 0) delay = Time.count;
			
			if(delay + 1 <= Time.count) {
				
				if(seatY - 20 <= y && y <= seatY + 20) {
					
					y = seatY;
					setSpeed(0);
					setSeated(true);
				}
				else if (seatY > y) {
					y = y + speed;
					
				}
				else if(seatY < y) {
					y = y - speed;
				}
			}
		} else {
			x += speed;
		}
		
	}
	public void act(int seatX, int seatY) {
		walk(seatX,  seatY);
		

	}
	
	

	
	public boolean isColliding(Passenger other) {
		
		if(getX() - other.getX() < 70
			&& Math.abs(getY() - other.getY()) < 70) {
			return true;
		} else {
			return false;
		}
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

	public boolean isSeated() {
		return isSeated;
	}

	public void setSeated(boolean isSeated) {
		this.isSeated = isSeated;
	}
}
