import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

public class Play  extends Screen{
	
	private Time time = new Time();
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int SPAWN_X = 100;
	private static final int SPAWN_Y = (int) (screenSize.getHeight()*(37.0/72));
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
			if(passengers[i]!=null ) {
				
			    passengers[i].draw(surface);
//			    if(i!= (passengers.length-1)) {
//			    	if(passengers[i].isColliding(passengers[i+1])) {
//			    		passengers[i].setSpeed(passengers[i].getSpeed()/2);
//			    	}
//			    }
			    if((i+1)< passengers.length-1) {
				    if(passengers[i].isColliding(passengers[i+1])) {
				    	passengers[i].setSpeed(1);
				    }
				    else {
				    	passengers[i].setSpeed(2);
				    }
			    }
			    passengers[i].act(passengers[i].getSeatX(),passengers[i].getSeatY());
			    
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
					// allows the passengers to spawn without worrying about having a certain condition when the previous or the next one spawns
					passengers[passengernumber]= new Passenger(SPAWN_X-100*passengernumber,SPAWN_Y,boardingGroups[i]);
					Seats tempSeat = airplane.getLastSeatofBoardingGroup(boardingGroups[i]);
					passengers[passengernumber].setSeatX(tempSeat.getX());
					passengers[passengernumber].setSeatY(tempSeat.getY());
					passengernumber++;
				}
			}
		
			
	}

	public int mouseReleased() {
		return 2;
	}

}
