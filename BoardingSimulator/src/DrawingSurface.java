import processing.core.PApplet;
public class DrawingSurface extends PApplet 
{
	boolean playbuttonPressed=false;
	boolean createBoardingPressed=false;
	boolean presetsPressed=false;
	boolean queueX=false;

	int playX=10,playY=10;
	//int createBoardingGroupX,createBoardingGroupY;
	//int presetsX,presetsY;
	//int queueX,queueY;
	int width=80;
	Aircraft boeing747 = new Aircraft();
	public void draw()
	{
		background(255,255,255);
		if(playbuttonPressed)
		{
			fill(225,0,0);
		}
		
		else {
			fill(200);
		}
		
		rect(playX,playY,width,width/2);
		fill(0);
		textSize(25);
		text("Play", 25,33);

		boeing747.draw(this);
		
	}
	public void mousePressed()
	{
		if(mouseX > playX && mouseX < (playX + width) && mouseY > playY && mouseY < playY + (width/2))
		{
			playbuttonPressed=true;
		}

	}
	public void mouseReleased()
	{
		if(mouseX > playX && mouseX < (playX + width) && mouseY > playY && mouseY < playY + (width/2))
		{
			playbuttonPressed=false;
		}
	}
}
