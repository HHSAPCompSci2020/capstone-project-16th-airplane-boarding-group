import java.awt.Color; 
import java.util.Timer;
import java.util.TimerTask;

import processing.core.PApplet;
/**
 * The timer class that keeps track of the time spent in the program, once run
 * 
 * @author primary author: Vamsee_Krishna_Vusuwandla
 * @version 5/14
 *
 */
public class Time {
	
	private int x,y;
	private int width;
	private int height;
	private int screenWidth;
	private int screenHeight;
	//private double seconds;
	//private double minutes;
	private boolean isRunning; 
	private long start;
	private long total = 0;
	
	int seconds = 0;
	int minutes = 0;
	Timer tTimer = new Timer();
	
	/**
	 *
	 * initializing values in timer
	 * 
	 */
	public Time(int x,int y,int width, int height, int screenWidth, int screenHeight, double seconds, double minutes)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.screenWidth=screenWidth;
		this.screenHeight=screenHeight;
		this.start=start;
		this.total=total;
		this.isRunning = false;
	}
	/**
	 *
	 * Draw method for the timer
	 * @param marker 
	 */
	public void draw(PApplet marker) {
		marker.fill(0);
		marker.textSize(20);
		marker.text(minutes + ":" + seconds, 35,40);
		marker.rect(x, y, screenWidth, screenHeight);
	}
	
	/**
	 * starts timer constructor
	 *  
	 */

	  TimerTask task = new TimerTask() {
			public void run() {
				seconds++;
				minutes = seconds/60;
				System.out.println(minutes + ":" + seconds);
			}
		};
		
		public void start() {
			tTimer.scheduleAtFixedRate(task, 1000, 1000);
		};

	  
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