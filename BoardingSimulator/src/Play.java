import java.awt.Color;

public class Play  extends Screen{
	
	//Timer timer = new Timer();
	
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
	}
	
	public void setBoardingGroup(Color[] colors) {
		boardingGroups = colors;
		//for()
	}
	public void mousePressed() {
		
	}
	
	

}
