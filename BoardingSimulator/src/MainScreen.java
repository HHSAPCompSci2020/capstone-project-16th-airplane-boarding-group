import java.awt.Color; 

import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;
import javax.swing.JFrame;
/**
@author Joshua Choi
@coauthor 
*/
//a
public class MainScreen extends Screen{
	
	// screen no 0
	
	private Aircraft boeing747;

	private Color[] boardingGroups;
	private Color[] trim;
	

	private boolean createQueueButtonPressed;
	private boolean createBoardingGroupPressed;
	int queueX = 40;
	int queueY = 40;
	int queueLength = 100;
	int queueHeight = 50;
	int currentColor =0;
	int maxColor = 0;
	

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
		surface.fill(255);
		surface.rect(400,40,100,50);
		surface.fill(255);
		surface.fill(0);
		surface.text("click here",425,60);
		surface.text("to change color",405,80);
		surface.text("- click here every time you want to change to the next boarding group",520,40);
		surface.text("- the first group is already set to red",520,60);
		surface.text("- simply click or DRAG each individual seat to assign them to a boarding group",520,80);
		surface.text("- the maximum boarding groups is 7, but less than the max is runnable",520,100);
		
		surface.fill(0);
		surface.text("current \nboarding \ngroup:",210,55);
		if(currentColor<boardingGroups.length)
		{
		surface.fill(boardingGroups[currentColor].getRed(),
				boardingGroups[currentColor].getGreen(),boardingGroups[currentColor].getBlue());
		}
		else {
			surface.text("that's all the boarding groups we have set for you",100,100+currentColor*10);
		}
		surface.rect(270,40,50,50);
		
		
		
		
		if(createQueueButtonPressed)
			surface.fill(255, 0, 0);
		else
			surface.noFill();
		
		surface.rect(40, 40, 100, 50);
		surface.fill(0);
		surface.text("create queue", 55, 70);
		
		
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
			if(hasUsedColor()) {
				
				createBoardingGroupPressed= true;
				if(currentColor<boardingGroups.length-1) {
					currentColor++;
					if(currentColor>maxColor)
					{
						maxColor= currentColor;
						System.out.println(maxColor);
					}
				}
				
				else {
					maxColor=currentColor;
					currentColor=0;
				}
				System.out.println("color changed");
				
			}
			
		}
		if(currentColor<boardingGroups.length)
		boeing747.seatClick(mouseX,mouseY,boardingGroups[currentColor]);
		
		
	}
	public void mouseDragged(int mouseX,int mouseY)
	{
		if(currentColor<boardingGroups.length)
			boeing747.seatClick(mouseX,mouseY,boardingGroups[currentColor]);
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
		Color [] trimmedGroups =Arrays.copyOfRange(boardingGroups,0,maxColor+1);
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
	
	private boolean hasUsedColor() {
		boolean hasUsedColor = false;
		Seats[][] aisle1 = boeing747.getaisle1();
		Seats[][] aisle2 = boeing747.getaisle2();
		for(int i = 0; i < aisle1.length; i++) {
			for(int n = 0; n < aisle1[i].length; n++) {
				Color color = aisle1[i][n].getColor();
				if(currentColor<boardingGroups.length)
				{
					
					if(boardingGroups[currentColor].equals(color)) 
					hasUsedColor = true;
				}
				else
				{
					surface.text("that's all the boarding groups we have set for you",100,100+currentColor*10);
				}
				
			}
		}
		
		for(int i = 0; i < aisle2.length; i++) 
		{
			for(int n = 0; n < aisle2[i].length; n++) {
				Color color = aisle2[i][n].getColor();
				if(currentColor<boardingGroups.length)
				{
				if(boardingGroups[currentColor].equals(color)) 
					hasUsedColor = true;
				}
				else
				{
					surface.text("that's all the boarding groups we have set for you",100,100+currentColor*10);
				}
			}
		}
		return hasUsedColor;
		
		}
	
	public Aircraft getAircraft() {
		return boeing747;
	}
	
}
