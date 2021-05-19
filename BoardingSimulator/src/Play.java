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
	/**
	 * sets the boardingGroups array equal to the colors array
	 * @param colors: the color array and order of the bording groups
	 */
	public void setBoardingGroup(Color[] colors) {
		
		boardingGroups = colors;
		for(int i= 0;i<colors.length;i++)
		{
			boardingGroups[i]=colors[i];
			
			
		}
	}
	public void mousePressed() {
		
	}
	/**
	 * called upon in the drawing surface sets basic methods
	 * @param boeing
	 */
	public void setAirplane(Aircraft boeing) {
		airplane = boeing;
		passengers = new Passenger[airplane.getOccupiedSeats()];
		System.out.println("red number of seats: " + airplane.getOccupiedGroups(boardingGroups[0]));
		setPassengerToGroups();

	
		
		
	}
	/**
	 * creates new passenger objects, gives different values according to the color of the boarding group. 
	 */
	public void setPassengerToGroups()
	
	{
	int passengernumber=0;
	for(int i=0; i<boardingGroups.length;i++)
		{
			for(int j=0; j<airplane.getOccupiedGroups(boardingGroups[i]);j++)
			{
				passengers[passengernumber]= new Passenger(100,100,boardingGroups[i]);
				passengernumber++;
				System.out.println("j");
			}
		}

		System.out.println("this boarding group has" + passengernumber + " members");
	}

	
	

}
