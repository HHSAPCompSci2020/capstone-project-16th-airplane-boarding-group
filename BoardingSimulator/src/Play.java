import java.awt.Color; 
import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Play  extends Screen{
	
	Aircraft boeing747;
	Passenger passengers;
	Timer timer = new Timer();
	private Color[] boardingGroups;
	private boolean createQueueButtonPressed;
	private boolean createBoardingGroupPressed;
	int queueX = 40;
	int queueY = 40;
	int queueLength = 100;
	int queueHeight = 50;
	int i=0;
	
	

	public Play(DrawingSurface marker) {
		super(marker);
		boeing747 = new Aircraft();
		setBoardingColors();
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		boeing747.draw(surface);
		surface.rect(400,40,100,50);
		surface.fill(0);
		surface.rect(200,50,50,50);
		timer.draw(surface);
		if(createQueueButtonPressed)
			surface.fill(255, 0, 0);
		else
			surface.fill(255);
		
		surface.rect(40, 40, 100, 50);
		surface.fill(0);
		surface.text("create queue", 40, 40);
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		if(mouseX > queueX && mouseX < (queueLength + queueX) && mouseY > queueY && mouseY < (queueY + queueHeight)) {
			createQueueButtonPressed = true;
			
		}
		if(mouseX > 400 && mouseX < (500) && mouseY > 40 && mouseY < (90))
		{
			createBoardingGroupPressed= true;
			i++;
			System.out.println("color changed");
		}
		if(i<boardingGroups.length)
		boeing747.seatClick(mouseX,mouseY,boardingGroups[i]);
		
		
	}
	
	public int mouseReleased() {
		return 0;
	}
	
	public Color[] getBoardingGroup() {
		Color [] trimmedGroups =Arrays.copyOfRange(boardingGroups,0,i);
		return trimmedGroups;
	}

	public void setBoardingColors()
	{
		boardingGroups = new Color[7];
		boardingGroups[0]= Color.RED;
		boardingGroups[1]= Color.GREEN;
		boardingGroups[2]= Color.BLUE;
		boardingGroups[3]= Color.BLACK;
		boardingGroups[4]= Color.CYAN;
		boardingGroups[5]= Color.YELLOW;
		boardingGroups[6]= Color.LIGHT_GRAY;
		
	}

}
