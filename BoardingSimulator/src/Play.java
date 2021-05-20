import java.awt.Color;

public class Play  extends Screen{
	
	Time time = new Time();
	
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
		time.draw(surface);
		
		for(int i = 0; i < passengers.length; i++) {
			if(passengers[i]!=null) {
				passengers[i].draw(surface);
			}
		}
		
	}
	
	/**
	 * sets the boardingGroups array equal to the colors array
	 * @param colors: the color array and order of the bording groups
	 */
	public void setBoardingGroup(Color[] colors) {
		
		boardingGroups = colors;
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
		//System.out.println("red number of seats: " + airplane.getOccupiedGroups(boardingGroups[0]));
		setPassengerToGroups();
		
	}
	/**
	 * creates new passenger objects, gives different values according to the color of the boarding group. 
	 */
	private void setPassengerToGroups() {
		
		int passengernumber=0;
		for(int i=0; i<boardingGroups.length;i++) {
			
				for(int j=0; j<airplane.getOccupiedGroups(boardingGroups[i]); j++) {
					passengers[passengernumber]= new Passenger(100,100,boardingGroups[i]);
					passengernumber++;
				}
			}
		for(int i = 0; i < passengers.length; i++) {
		}
			
	}

	public int mouseReleased() {
		return 2;
	}

}
