import java.awt.Dimension;
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

import processing.core.PApplet;
public class Aircraft {
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
	public void seatClick(int mouseX,int mouseY)
	{
		for(int i=0;i<aisle1.length;i++) {
			for(int j=0;j<aisle1[0].length;j++)
			{
				if(aisle1[i][j].seatClicked(mouseX,mouseY))
				{
					
				}
				
			}
		}
		for(int i=0;i<aisle2.length;i++) {
			for(int j=0;j<aisle2[0].length;j++)
			{
				if(aisle2[i][j].seatClicked(mouseX,mouseY))
				{
					
				}
			}
		}
	}
}