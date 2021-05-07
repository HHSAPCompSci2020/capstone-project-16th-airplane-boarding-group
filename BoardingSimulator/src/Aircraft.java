import processing.core.PApplet;
public class Aircraft {
	int length,width;
	int x,y;
	Seats [][]aisle1 = new Seats[3][7];
	Seats [][]aisle2 = new Seats[3][7];
	public Aircraft() {
		x=0;
		y=100;
		// later update this so it matches the size of the adjustable panel, so get the variable somehow from jpanel
		width= 1000;
		length = 400;
		this.fillValues();
	
	}
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
			
			
		
	}

	private void fillValues() {
		for (int i=0;i<aisle1.length;i++)
		{
			
			for(int j =0;j<aisle1[0].length;j++)
			{
				// L-2(l) - 6(5)/aisle1[0].length

				float widthSeat = (width-2*50-6*5)/(2*aisle1[0].length);
				float  rectX = x+50 +j* widthSeat+5*j;
				float rectY = y +50+ i*widthSeat+5*i;
				aisle1[i][j]=new Seats(rectX,rectY,widthSeat);
				

				
			}
		}

	}
}