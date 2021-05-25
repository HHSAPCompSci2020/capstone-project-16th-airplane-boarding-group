package boardingGroupthe16th;
import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * 
 * @author Aryan Keskar
 *
 */
//a
public class DrawingSurface extends PApplet {
	
	private MainScreen screen1; // 0
	private QueueScreen screen2; // 1
	private Play screen3;// 2
	
	private Screen activeScreen;
	ArrayList<Screen> screens = new ArrayList<Screen>();
	
	/**
	 * Initializes the drawingSurface by loading all the screens in the program into an ArrayList
	 */
	public DrawingSurface() {
		screen1 = new MainScreen(this);
		screens.add(screen1);
		
		screen2 = new QueueScreen(this);
		screens.add(screen2);
		
		screen3 = new Play(this);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
	}
	/**
	 * Draws the active Screen
	 */
	public void draw() {
		background(255);
		activeScreen.draw();
		
	}
	/**
	 * Is called when the mouse is pressed, checks if any button was pressed and decides further actions accordingly
	 */
	public void mousePressed() {
		activeScreen.mousePressed(mouseX, mouseY);
		
	}
	
	/**
	 * Is called when the mouse is dragged, checks if any element was dragged and decides further actions accordingly
	 */
	public void mouseDragged() {
		activeScreen.mouseDragged(mouseX, mouseY);
		
	}
	/**
	 * Called when mouse is released, it is responisble for loading the next screen
	 */
	public void mouseReleased() {
		Color[] colors = null;
		int numSeats = 0;
		int index = activeScreen.mouseReleased();
		
		if(activeScreen instanceof MainScreen && index  == 1) {
			colors = ((MainScreen)activeScreen).getBoardingGroup();
			if(colors == null) {
				index--;
			}
		}
		else if(activeScreen instanceof QueueScreen && index == 2) {
			colors = ((QueueScreen)activeScreen).getFinalList();
			if(colors == null) {
				index--;
			}
		}
		activeScreen = screens.get(index);
		
		if(activeScreen instanceof QueueScreen && colors != null)
			((QueueScreen) activeScreen).setboardingGroup(colors);
		else if(activeScreen instanceof Play && colors!= null) {
			((Play)activeScreen).setBoardingGroup(colors);
			((Play)activeScreen).setAirplane(screen1.getAircraft());
		}		
	
	}
}
