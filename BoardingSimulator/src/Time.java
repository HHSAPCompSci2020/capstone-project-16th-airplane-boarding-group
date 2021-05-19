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
	
	int count = 0;
	int seconds = 0;
	int minutes = 0;
	
	/**
	 * initializing values in timer
	 */
	public Time()
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.screenWidth=screenWidth;
		this.screenHeight=screenHeight;
		this.start=start;
		this.total=total;
		this.seconds=seconds;
	}
	/**
	 *
	 * Draw method for the timer
	 * @param marker 
	 * @throws InterruptedException 
	 */
	public void draw(PApplet marker){
		String minutesString = String.format("%02d", getMinutes());
		String secondsString = String.format("%02d", getSeconds());
		
	     marker.fill(0);
	     marker.textSize(20);
		 marker.text(minutesString + ":" + secondsString, 35,40);
	}  
	
	public int getSeconds() {
		seconds++;
		count = seconds/60;
		
		if((seconds%3600)==0&seconds!=0){
			seconds=0;
			minutes++;
		}
		
		return count;
	}
	
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