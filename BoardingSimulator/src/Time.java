import java.awt.Color;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/**
 * The timer class that keeps track of the time spent in the program, once run
 * 
 * @author primary author: Vamsee_Krishna_Vusuwandla
 * @version 5/19
 *
 */

import processing.core.PApplet;

public class Time {
	
	private int x,y;
	private int width;
	private int height;
	private int screenWidth;
	private int screenHeight;
	private long start;
	private long total = 0;
	
	private int count = 0;
	private int seconds = 0;
	private int minutes = 0;
	private boolean stopNow; 
	
	/**
	 * initializing values in timer
	 */
	public Time()
	{
		this.seconds=seconds;
		this.minutes=minutes;
		this.count=count;
		stopNow = true;
	}
	/**
	 * Draw method for the timer
	 * @param marker 
	 */
	public void draw(PApplet marker){
		String minutesString = String.format("%02d", getMinutes());
		String secondsString = String.format("%02d", getSeconds());
		
	     marker.fill(0);
	     marker.textSize(20);
		 marker.text(minutesString + ":" + secondsString, 35,40);
	}  
	
	/**
	 * Returns the time in seconds
	 * 
	 */
	public int getSeconds() {
		if(stopNow) {
			seconds++;
			count = seconds/60;
			
			if((seconds%3600)==0&seconds!=0){
				seconds=0;
				minutes++;
			}
		}
		
		return count;
	}
	
	/**
	 * Stops timer
	 * 
	 */
	public boolean stop() {
		stopNow = false;
		return stopNow;
	}
	/**
	 * Returns the time in minutes
	 * 
	 */
	public int getMinutes() {
		return minutes;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

}