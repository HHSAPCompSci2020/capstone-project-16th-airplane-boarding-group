import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;

import processing.core.PApplet;

import java.util.concurrent.*;

/**
 * @author Joshua 
 * @author Aryan
 *
 */
public class Passenger extends PApplet{
	
	private int x, y;
	private final int RADIUS = 50;
	private int  speed;
	private Color passengerColor;
	private boolean isSeated;
	private int seatX,seatY;
	private int delay = 0;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	processing.core.PImage photo; 
	
	/**
	 * Initializes all the variables in passenger to the given values and their defaults
	 * @param x x coordinate of the passenger
	 * @param y y coordinate of the passenger
	 * @param passengerColor boarding group color of the passenger
	 */
	public Passenger(int x, int y,Color passengerColor) {
		this.x = x;
		this.y = y;
		this.passengerColor=passengerColor;
		
		setSeated(false);
	
		speed = 2;
	}
	/**
	 * Draws the passenger
	 * @param marker
	 */
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
	
	/**
	 * makes the passenger walk up to the seat, it also makes the passenger pause at the right moments
	 * @param seatX: x coordinate of the seat
	 * @param seatY: y coordinate of the seat
	 */

	public void act(int seatX, int seatY) {
		walk(seatX,  seatY);
		

	}
	
	
	/**
	 * checks if the passenger is colliding with another
	 * @param other: another passenger
	 * @return false if passenger is not colliding true otherwise
	 */
	
	public boolean isColliding(Passenger other) {
		
		if(getX() - other.getX() < 70
			&& Math.abs(getY() - other.getY()) < 70) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * gets the radius
	 * @return Radius
	 */
	public int getRadius() {
		return RADIUS;
	}
	/**
	 * gets the x coordinate
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * gets the y coordinate
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * gets the color of the boarding group
	 * @return color of the boarding group
	 */
	public Color getColor() {
		return passengerColor;
	}
	/**
	 * gets the x coordinate of the seat
	 * @return x coordinate of the seat
	 */
	public int getSeatX() {
		return seatX;
	}
	/**
	 * sets the x coordinate of the seat
	 * @param x: x coordinate of the seat
	 */
	public void setSeatX(int x) {
		seatX = x;
	}
	/**
	 * gets the y coordinate of the seat
	 * @return y coordinate of the seat
	 */
	public int getSeatY() {
		return seatY;
	}
	/**
	 * sets the y coordinate of the seat
	 * @param y: x coordinate of the seat
	 */
	public void setSeatY(int y) {
		seatY = y;
	}
	/**
	 * sets the speed of the seat
	 * @param newSpeed: speed of the passenger
	 */
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	/**
	 * gets the speed of the passenger
	 * @return speed: returns the speed of the passenger
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * returns whether the passenger is seated or not
	 * @return isSeated: whether the passenger is seated or not
	 */
	public boolean isSeated() {
		return isSeated;
	}
	/**
	 * sets  the isSeated value to the parameter
	 */
	public void setSeated(boolean isSeated) {
		this.isSeated = isSeated;
	}
}
