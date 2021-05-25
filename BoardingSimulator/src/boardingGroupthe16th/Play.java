package boardingGroupthe16th;
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
 
	/**
	 * calls the super constructor
	 * @param marker is a parameter of the constructor
	 */
	public Play(DrawingSurface marker) {
		super(marker);
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * draws according to the setPaseengerToGroups and is responsible for the move methods calling the passenger method
	 */
	public void draw() {
		airplane.draw(surface);
		time.draw(surface);
	
		for(int i = 0; i < passengers.length; i++) {
			if(passengers[i]!=null ) {
				
			    passengers[i].draw(surface);

			    
			    }
			    passengers[i].act(passengers[i].getSeatX(),passengers[i].getSeatY());
			    
			    for(int j=0;j<passengers.length;j++)
			    {
			    	if(passengers[i].isColliding(passengers[j])) {
			    		if(passengers[i].isSeated()) {
			    			passengers[j].setSpeed(1);
			    		} else {
			    			passengers[j].setSpeed(0);
			    		}
			    	} else {
			    		passengers[j].setSpeed(2);
			    	}
			    	if(passengers[0].getSpeed() == 0) {
			    		passengers[0].setSpeed(2);
			    	}
			    
			    }
			    
			    
			}
		
			int passengersseatedtotal=0;
			for(int i=0; i<passengers.length;i++)
			{
				
				if(passengers[i].isSeated())
				{
					passengersseatedtotal++;
				}
				
			}
			
			// current progress bar
			surface.fill(0);
			surface.text("Progress bar current status",425,15);
			surface.fill(255);
			surface.rect(425, 19, 300, 50);
			surface.fill(0,255,0);
			surface.rect(425,19,(int)(300*((double)passengersseatedtotal/passengers.length)),50);
			surface.fill(250,0,0);
			surface.text("current progress : "+ Math.floor(100*(double)passengersseatedtotal/passengers.length) + " %",800,19);
			surface.fill(0);
			surface.text("seats filled "+ passengersseatedtotal+" / seats in total" + passengers.length,425,50);

			if (passengersseatedtotal == passengers.length)
			{
			time.allSeated();
			
			
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
	/**
	 * @return the index of the current screen, since this is the last screen
	 */
	public int mouseReleased() {
		return 2;
	}

}
