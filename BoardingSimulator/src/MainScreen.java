import java.awt.Color;

import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MainScreen extends Screen{
	
	// screen no 0
	
	Aircraft boeing747;

	private Color[] boardingGroups;
	private Color[] trim;
	

	private boolean createQueueButtonPressed;
	private boolean createBoardingGroupPressed;
	int queueX = 40;
	int queueY = 40;
	int queueLength = 100;
	int queueHeight = 50;
	int i=0;
	

	/**
	 * 
	 * @param marker constructor creates the aircraft with the drawing surface
	 */
	public MainScreen(DrawingSurface marker) {
		super(marker);
		boeing747 = new Aircraft();
		setBoardingColors();
		// TODO Auto-generated constructor stub
	}
	/**
	 * drawing the main screen with buttons
	 */
	public void draw() {
		boeing747.draw(surface);
		surface.rect(400,40,100,50);
		surface.fill(0);
		surface.text("click here",430,60);
		surface.text("click here to every time you want to make each boarding group, the first group is already set for red",350,40);
		surface.text("you simply have to click individual seats to assign them to a boarding group",400,30);
		surface.text("keep in mind that the maximum of groups you can use is 7, but you can use fewer to your liking",600,60);
		
		surface.fill(0);
		surface.text("current boarding group:",200,40);
		if(i<boardingGroups.length)
		surface.fill(boardingGroups[i].getRed(),boardingGroups[i].getGreen(),boardingGroups[i].getBlue());
		else {
			surface.text("that's all the boarding groups we have set for you",100,100+i*10);
		}
		surface.rect(200,50,50,50);
		
		
		
		
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
		
			i++;
			
			System.out.println("color changed");
		}
		if(i<boardingGroups.length)
		boeing747.seatClick(mouseX,mouseY,boardingGroups[i]);
		
		
	}
	/**
	 * changes boolean value depending on where the user clicks on the main screen
	 */
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
		Color [] trimmedGroups =Arrays.copyOfRange(boardingGroups,0,i+1);
		return trimmedGroups;
	}
/**
 * sets boarding colors into some arbitrary order of colors
 */
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
