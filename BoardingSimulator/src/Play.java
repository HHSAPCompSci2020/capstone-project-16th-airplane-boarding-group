import java.awt.Color;
import java.util.concurrent.TimeUnit;

public class Play  extends Screen{
	
	private Time time = new Time();
	
	private static final int SPAWN_X = 100;
	private static final int SPAWN_Y = 440;
	private Aircraft airplane;
	private Color[] boardingGroups;
	private Passenger[] passengers;
 
	public Play(DrawingSurface marker) {
		super(marker);
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		airplane.draw(surface);
		time.draw(surface);
		
		for(int i = 0; i < passengers.length; i++) {
			if(passengers[i]!=null) {
			     try {
			    	 TimeUnit.SECONDS.sleep(2);
			        } catch (InterruptedException ie)
			        {
			            
			        }
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
					passengers[passengernumber]= new Passenger(SPAWN_X,SPAWN_Y,boardingGroups[i]);
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
