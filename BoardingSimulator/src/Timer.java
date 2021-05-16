import java.awt.Color;
import processing.core.PApplet;
/**
 * The timer class that keeps track of the time spent in the program, once run
 * 
 * @author primary author: Vamsee_Krishna_Vusuwandla
 * @version 5/14
 *
 */
public class Timer {
	
	private int x,y;
	private int width;
	private int height;
	private int screenWidth;
	private int screenHeight;
	private double seconds;
	private double minutes;
	
	private boolean isRunning; 
	private long start;
	private long total = 0;
	
	/**
	 *
	 * initializing values in timer
	 * 
	 */
	public Timer(int x,int y,int width, int height, int screenWidth, int screenHeight, double seconds, double minutes)
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
		marker.text(start + ":" + total, 35,40);
		marker.rect(x, y, screenWidth, screenHeight);
	}
	/**
	 * starts timer constructor
	 *  
	 */
	public Timer()
	  {
	    start();
	  }
	/**
	 *
	 * starts timer to run 
	 */
	public void start()
	{
	    if (isRunning) return;
	    start = System.currentTimeMillis();
	    isRunning = true;
	  }
	/**
	 *
	 * stops timer 
	 */
	  public long stop()
	  {
	    if (isRunning) {
	      updateTotalTime();
	      isRunning = false;
	    }
	    return total;
	  }
	  /**
		 *
		 * resets timer
		 */
	  public void reset()
	  {
	    total = 0;
	    start = System.currentTimeMillis();
	  }
	  /**
		 *
		 * Uses the total time
		 */
	  public long split()
	  {
	    if (isRunning)
	      updateTotalTime();
	    return total;
	  }
	  /**
		 *
		 * Updates the total time
		 */
	  private void updateTotalTime()
	  {
	    long endTimestamp = System.currentTimeMillis();
	    long elapsedTime = endTimestamp - start;
	    start = endTimestamp;
	    total += elapsedTime;
	  }
	  /**
		 *
		 * gets time 
		 */
	  public long getTime()
	  {
	    updateTotalTime();
	    return total;
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
