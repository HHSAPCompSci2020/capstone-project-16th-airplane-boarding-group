import processing.core.PApplet;

import java.util.ArrayList;

import javax.swing.JPanel;
public class DrawingSurface extends PApplet {
	
	private MainScreen screen1;
	private CreateBoardingGroupScreen screen2;
	private QueueScreen screen3;
	
	private Screen activeScreen;
	ArrayList<Screen> screens = new ArrayList<Screen>();
	
	public DrawingSurface() {
		screen1 = new MainScreen(this);
		screens.add(screen1);
		
		screen2 = new CreateBoardingGroupScreen(this);
		screens.add(screen2);
		
		screen3 = new QueueScreen(this);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
	}
	
	public void draw() {
		background(255);
		activeScreen.draw();
		
	}
	
	public void mousePressed() {
		activeScreen.mousePressed(mouseX, mouseY);
		
	}
	
	public void mouseReleased() {
		int index = activeScreen.mouseReleased();
		activeScreen = screens.get(index);
	}
	
}
