import java.awt.Color;

public class Play  extends Screen{
	
	Time timer = new Time();
	
	int passengerRadius = 20;
	Aircraft airplane;
	Color[] boardingGroups;
	Passenger[] passengers;
	
	
	
 
	public Play(DrawingSurface marker) {
		super(marker);
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		airplane.draw(surface);
		try {
			timer.draw(surface);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBoardingGroup(Color[] colors) {
		boardingGroups = colors;
		//for()
	}
	public void mousePressed() {
		
	}
	
	public void setAirplane(Aircraft boeing) {
		airplane = boeing;
	}
	
	

}
