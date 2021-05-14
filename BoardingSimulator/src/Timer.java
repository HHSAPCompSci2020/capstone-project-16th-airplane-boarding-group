import java.awt.Color;
import processing.core.PApplet;
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
	
	public Timer(int x,int y,int width, int height, int screenWidth, int screenHeight, double seconds, double minutes)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.screenWidth=screenWidth;
		this.screenHeight=screenHeight;
		this.seconds=seconds;
		minutes = (int) (seconds/60);
	}
	
	public void draw(PApplet marker) {
		marker.fill(0);
		marker.textSize(20);
		marker.text(minutes + ":" + seconds, 35,40);
		marker.rect(x, y, screenWidth, screenHeight);
	}
	public Timer()
	  {
	    start();
	  }

	public void start()
	{
	    if (isRunning) return;
	    start = System.currentTimeMillis();
	    isRunning = true;
	  }

	  public long stop()
	  {
	    if (isRunning) {
	      updateTotalTime();
	      isRunning = false;
	    }
	    return total;
	  }

	  public void reset()
	  {
	    total = 0;
	    start = System.currentTimeMillis();
	  }

	  public long split()
	  {
	    if (isRunning)
	      updateTotalTime();
	    return total;
	  }

	  private void updateTotalTime()
	  {
	    long endTimestamp = System.currentTimeMillis();
	    long elapsedTime = endTimestamp - start;
	    start = endTimestamp;
	    total += elapsedTime;
	  }

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
