package boardingGroupthe16th;
import java.awt.Color;

public class Screen {
	//a
	protected DrawingSurface surface;
	
	/**
	 * initializes parameters
	 * @param marker: used  for initializing variable
	 */
	public Screen(DrawingSurface marker) {
		surface = marker;
	}
	/**
	 * sets up the screen
	 */
	public void setup() {
		
	}
	/**
	 * draws the screen
	 */
	public void draw() {
	}
	/**
	 * called when mouse is pressed, reacts accordingly
	 * @param mouseX: x coordinate of the mouse
	 * @param mouseY: y coordinate of the mouse
	 */
	public void mousePressed(int mouseX, int mouseY) {
		
	}
	
	/**
	 * called when mouse is dragged, reacts accordingly
	 * @param mouseX: x coordinate of the mouse
	 * @param mouseY: y coordinate of the mouse
	 */
	public void mouseDragged(int mouseX, int mouseY) {
		
	}
	
	/**
	 * called when mouse is released, reacts accordingly
	 * @return: returns the index of the next screen
	 */
	public int mouseReleased() {
		return 0;
	}

	

}
