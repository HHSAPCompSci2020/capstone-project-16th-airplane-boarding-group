import java.awt.Dimension;
import java.awt.Color;
/**
 * The aircraft class represents the airplane of the class, it's responsible for drawing the seats 
 * as a whole and passing on the seats to individual seats objects using 2d arrays
 * 
 * 
 *
 * 
 * @author primary author: joshua_choi
 * @version 5/9
 *
 */
import java.awt.Toolkit;
import java.util.ArrayList;

import processing.core.PApplet;
public class Aircraft {
	//a
	int length,width;
	int x,y;
	Seats [][]aisle1 = new Seats[3][7];
	Seats [][]aisle2 = new Seats[3][7];
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * initializes the aircraft with a default setting 
	 */
	public Aircraft() {
		
		x=0;
		y=(int) screenSize.getHeight()/8;
		// later update this so it matches the size of the adjustable panel, so get the variable somehow from jpanel
		width= (int) screenSize.getWidth();
		length = (int) (screenSize.getHeight()*1.5)/2;
		this.fillValues();
		System.out.println("Use Full Screen for maximum experience");

	}
	/** 
	 * Calls the given Processing PApplet to the draw method in the Seats classes for individual seats
	 * @param marker
	 * 	
	 * 
	 * 
	 */
	public void draw(PApplet marker)
	{
		marker.fill(153);
		marker.rect(x,y,width,length);
		marker.fill(255,255,255);
		for(int i=0;i<aisle1.length;i++) {
			for(int j=0;j<aisle1[0].length;j++)
			{
				aisle1[i][j].draw(marker);
			}
		}
		for(int i=0;i<aisle2.length;i++) {
			for(int j=0;j<aisle2[0].length;j++)
			{
				aisle2[i][j].draw(marker);
			}
		}
			
			
		
	}
	/**
	 * Creates a Seats object in the given location inside the aircraft
	 */
	private void fillValues() {
		for (int i=0;i<aisle1.length;i++)
		{
			
			for(int j =0;j<aisle1[0].length;j++)
			{
		

				float widthSeat = (float)screenSize.getHeight()/12;
				float  rectX = x+(float)screenSize.getHeight()/3 +j* widthSeat+((float)screenSize.getHeight()/12)*j;
				float rectY = y + i*widthSeat+((float)screenSize.getHeight()/36)*i;
				aisle1[i][j]=new Seats(rectX,rectY,widthSeat,false);
				

				
			}
		}
		for (int i=0;i<aisle2.length;i++)
		{
			
			for(int j =0;j<aisle2[0].length;j++)
			{
				

				float widthSeat = (float)screenSize.getHeight()/12;
				float  rectX = x+(float)screenSize.getHeight()/3 +j* widthSeat+((float)screenSize.getHeight()/12)*j;
				float rectY = (float)(screenSize.getHeight()*(41.0/72)) + i*widthSeat+((float)screenSize.getHeight()/36)*i;
				aisle2[i][j]=new Seats(rectX,rectY,widthSeat,false);
				

				
			}
		}
	}
	/**
	 * 
	 * @param mouseX
	 * @param mouseY
	 * passes the method to the specific method of seat through arrays
	 */
	public void seatClick(int mouseX,int mouseY,Color color)
	{
		for(int i=0;i<aisle1.length;i++) {
			for(int j=0;j<aisle1[0].length;j++)
			{
				if(aisle1[i][j].seatClicked(mouseX,mouseY))
				{
					aisle1[i][j].setBoardingColor(color);
				}
				
			}
		}
		for(int i=0;i<aisle2.length;i++) {
			for(int j=0;j<aisle2[0].length;j++)
			{
				if(aisle2[i][j].seatClicked(mouseX,mouseY))
				{
					aisle2[i][j].setBoardingColor(color);
				}
			}
		}
	}
	
	public Seats[][] getaisle1() {
		return aisle1;
	}
	public Seats[][] getaisle2() {
		return aisle2;
	}
	
	
	public int getOccupiedSeats() {
		int occupied = 0;
		for(int i = 0;i<aisle1.length;i++)
		{
			for(int j=0;j<aisle1[0].length;j++)
			{
				if(aisle1[i][j].getColor()!=Color.WHITE)
				{
					occupied++;
				}
			}
			
		}
		for(int i = 0;i<aisle2.length;i++)
		{
			for(int j=0;j<aisle2[0].length;j++)
			{
				if(aisle2[i][j].getColor()!=Color.WHITE)
				{
					occupied++;
				}
			}
			
		}
		return occupied;
	}
	
	public int getOccupiedGroups(Color color)
	{
		int occupied= 0;
		for(int i = 0;i<aisle1.length;i++)
		{
			for(int j=0;j<aisle1[0].length;j++)
			{
				if(aisle1[i][j].getColor().equals(color))
				{
					
					occupied++;
				}
			}	
		}
		for(int i = 0;i<aisle2.length;i++)
		{
			for(int j=0;j<aisle2[0].length;j++)
			{
				//System.out.println("yo");
				if(aisle2[i][j].getColor().equals(color))
				{
				
					occupied++;
				}
			}
	}
		return occupied;
	
	}
	/**
	 * *important* before passenger starts moving, they have an assigned seat they know they go to
	 * the logic is that within the boarding group color passenger is in, they try to go to the 
	 * furthest seat(the biggest x value) when there is still seats to choose from within those x values
	 * the method randomly picks a seat
	 * @param color specific boarding color of the passenger finding a seat
	 * @return returns the seat the passenger is assigned to
	 * @post the seat that was chosen becomes taken 
	 */
	public Seats getLastSeatofBoardingGroup(Color color)
	{
		ArrayList<Integer> potentialSeats = new ArrayList<Integer>();
		int furthest = 0;
		for(int i = 0;i<aisle1.length;i++)
		{
			for(int j=0;j<aisle1[0].length;j++)
			{
				if(aisle1[i][j].getColor().equals(color)&& ! aisle1[i][j].getSeatTaken())
				{
					if(j>furthest)
						furthest = j;
					
				}
			}	
		}
		for(int i = 0;i<aisle2.length;i++)
		{
			for(int j=0;j<aisle2[0].length;j++)
			{
				//System.out.println("yo");
				if(aisle2[i][j].getColor().equals(color)&& ! aisle2[i][j].getSeatTaken())
				{
					if(j>furthest)
						furthest = j;	
				}
			}
		}
		
		for(int i=0;i<aisle1.length;i++)
		{
			if(aisle1[i][furthest].getColor().equals(color) && ! aisle1[i][furthest].getSeatTaken())
			{
				potentialSeats.add(i);
			
			}
		}
		for(int i=0;i<aisle2.length;i++)
		{
			if(aisle2[i][furthest].getColor().equals(color) && ! aisle2[i][furthest].getSeatTaken())
			{
				potentialSeats.add(i+3);
				
			}
		}
		
		int index = (int)(Math.random()*potentialSeats.size());
		int chosenRow = potentialSeats.get(index);
		if(chosenRow>=3)
		{
			aisle2[chosenRow-3][furthest].setSeatTaken();
			return aisle2[chosenRow-3][furthest];
		}
		else {
			aisle1[chosenRow][furthest].setSeatTaken();
			return aisle1[chosenRow][furthest];
		}
		
		
	}
}