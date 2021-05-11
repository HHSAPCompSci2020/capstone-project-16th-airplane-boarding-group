import processing.core.PApplet;
import javax.swing.JPanel;
public class DrawingSurface extends PApplet 
{
	boolean playbuttonPressed=false;
	boolean createBoardingPressed=false;
	boolean presetsPressed=false;
	boolean queueButtonPressed = false;
	boolean windowDropDown = false;

	int playX=10,buttonY=10;
	
	int queueX = 100;
	
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
		rect(playX,buttonY,width,width/2); // play button
		
		if(queueButtonPressed)
		{
			fill(225,0,0);
		}
		
		else {
			fill(200);
		}
		rect(queueX, buttonY, width*2, width/2); // queue button
		
		fill(0);
		textSize(20);
		text("Play", 35,40);
		textSize(20);
		text("Create Queue", 110, 40);
		
		fill(255);
		
		if(windowDropDown) {
			rect(queueX, buttonY, 400, 100);
			fill(0);
			textSize(20);
			text("Order 1", 110, 40);
			textSize(20);
			text("Order 2", 110, 60);
			textSize(20);
			text("Back", 110, 80);
		}

		boeing747.draw(this);
		
	}
	public void mousePressed()
	{
		if(mouseX > playX && mouseX < (playX + width) && mouseY > buttonY && mouseY < buttonY + (width/2))
		{
			playbuttonPressed=true;
		}
		
		if(mouseX > queueX && mouseX < (queueX + width) && mouseY > buttonY && mouseY < buttonY + (width/2))
		{
			queueButtonPressed=true;
			windowDropDown = true;
		}

	}
	public void mouseReleased()
	{
		if(playbuttonPressed)
		{
			playbuttonPressed=false;
		}
		if(queueButtonPressed) {
			queueButtonPressed = false;
			
		}
	}
}
