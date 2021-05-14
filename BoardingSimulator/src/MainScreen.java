import java.awt.Color;

import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MainScreen extends Screen{
	
	// screen no 0
	
	Aircraft boeing747;




	

	private Color[] boardingGroups;
	

	private boolean createQueueButtonPressed;
	private boolean createBoardingGroupPressed;
	int queueX = 40;
	int queueY = 40;
	int queueLength = 100;
	int queueHeight = 50;
	

	
	public MainScreen(DrawingSurface marker) {
		super(marker);
		boeing747 = new Aircraft();
		setBoardingColors();
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		boeing747.draw(surface);
		surface.rect(400,40,100,50);
		surface.fill(0);
		surface.text("click here to make the next boarding group",400,40);

		
		if(createQueueButtonPressed)
			surface.fill(255, 0, 0);
		else
			surface.fill(255);
		
		surface.rect(40, 40, 100, 50);
		surface.fill(0);
		surface.text("create queue", 40, 40);
		
	}
	/**
	 * @param x mouse X click
	 * @param y mouse Y click
	 * checks which part of the screen is clicked, mainly for assigning seats to the class
	 */
	public void mousePressed(int mouseX, int mouseY) {
		if(mouseX > queueX && mouseX < (queueLength + queueX) && mouseY > queueY && mouseY < (queueY + queueHeight)) {
			createQueueButtonPressed = true;
		}
		if(mouseX > 400 && mouseX < (500) && mouseY > 40 && mouseY < (90))
		{
			createBoardingGroupPressed= true;	
		}
			
		boeing747.seatClick(mouseX,mouseY);
		
		
	}
	
	public int mouseReleased() {
		int index = 0;
		if(createBoardingGroupPressed)
		{
			createBoardingGroupPressed = false;
		}
		if(createQueueButtonPressed) {
			createQueueButtonPressed = false;
			index = 1;
		}
		return index;
	}
	
	public Color[] getBoardingGroup() {
		return boardingGroups;
	}

	public void setBoardingColors()
	{
		boardingGroups = new Color[5];
		boardingGroups[0]= Color.RED;
		boardingGroups[1]= Color.GREEN;
		boardingGroups[2]= Color.BLUE;
		boardingGroups[3]= Color.ORANGE;
		boardingGroups[4]= Color.BLACK;
		boardingGroups[5]= Color.YELLOW;
		boardingGroups[6]= Color.DARK_GRAY;
		
	}
		



}
