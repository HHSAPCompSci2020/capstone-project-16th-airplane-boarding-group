import processing.core.PApplet;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingSurface extends PApplet {
	
	private MainScreen screen1; // 0
	private QueueScreen screen2; // 1
	private Play screen3;// 2
	
	private Screen activeScreen;
	ArrayList<Screen> screens = new ArrayList<Screen>();
	
	public DrawingSurface() {
		screen1 = new MainScreen(this);
		screens.add(screen1);
		
		screen2 = new QueueScreen(this);
		screens.add(screen2);
		
		screen3 = new Play(this);
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
	
	public void mouseDragged() {
		activeScreen.mouseDragged(mouseX, mouseY);
		
	}
	
	public void mouseReleased() {
		Color[] colors = null;
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
		else if(activeScreen instanceof Play && colors!= null)
			((Play)activeScreen).setBoardingGroup(colors);
	
	}
}
