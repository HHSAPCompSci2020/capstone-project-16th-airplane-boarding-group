import java.awt.Color; 
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/**
 * The timer class that keeps track of the time spent in the program, once run
 * 
 * @author primary author: Vamsee_Krishna_Vusuwandla
 * @version 5/14
 *
 */

import processing.core.PApplet;

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

	/**
	 *
	 * initializing values in timer
	 * 
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
		this.isRunning = false;
	}
	/**
	 *
	 * Draw method for the timer
	 * @param marker 
	 * @throws InterruptedException 
	 */
	public void draw(PApplet marker) throws InterruptedException {
		marker.fill(0);
		marker.textSize(20);
		//marker.text(elapsedMinutes + ":" + elapsedSeconds, 35,40);
		marker.rect(x, y, screenWidth, screenHeight);
		boolean x=true;
	    long minutes=0;
	    long start=System.currentTimeMillis();
	    while(x)
	    {
	        TimeUnit.SECONDS.sleep(1);
	        long timepassed=System.currentTimeMillis()-start;
	        long seconds=timepassed/1000;
	        if(seconds==60)
	        {
	            seconds=0;
	            start=System.currentTimeMillis();
	        }
	        if((seconds%60)==0)
	        minutes++;

	        marker.fill(0);
			marker.textSize(20);
	        marker.text(minutes+":"+seconds, 35,40);
	    }
		Time clock = new Time();
		clock.start();
	}
	
	/**
	 * starts timer constructor
	 *  
	 */
	Timer tTimer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			for(int i = 60; i>seconds; ) {
				if(i==60) {
					minutes = seconds/60;
					seconds = 0;
				}
				seconds++;
			}
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
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}

}