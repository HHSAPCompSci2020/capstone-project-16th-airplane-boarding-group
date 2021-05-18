import java.awt.Color;

public class Play  extends Screen{
	
	Time time = new Time();

	private Aircraft airplane;
	private Color[] boardingGroups;
	private Passenger[] passengers;
	private final int  SPAWN_X = 12;
	private final int  SPAWN_Y = 12;
	
 
	public Play(DrawingSurface marker) {
		super(marker);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		airplane.draw(surface);
		for(int i = 0; i < passengers.length; i ++) {
			
		}
		try {
			time.draw(surface);
		} catch (InterruptedException e) {
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
		passengers = new Passenger[airplane.getOccupiedSeats()];
	}
	
	

}
