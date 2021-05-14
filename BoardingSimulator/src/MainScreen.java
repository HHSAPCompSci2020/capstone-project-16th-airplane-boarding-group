import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MainScreen extends Screen{
	
	// screen no 0
	
	Aircraft boeing747;
	private boolean createQueueButtonPressed;
	private boolean createBoardingGroup;
	int queueX = 40;
	int queueY = 40;
	int queueLength = 100;
	int queueHeight = 50;
	

	
	public MainScreen(DrawingSurface marker) {
		super(marker);
		boeing747 = new Aircraft();
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		boeing747.draw(surface);
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
		boeing747.seatClick(mouseX,mouseY);
		
		
	}
	
	public int mouseReleased() {
		int index = 0;
		
		if(createQueueButtonPressed) {
			createQueueButtonPressed = false;
			index = 1;
		}
		return index;
	}

}
