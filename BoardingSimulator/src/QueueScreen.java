import java.awt.Color;

public class QueueScreen extends Screen{
	
	//screen no 1
	
	boolean playScreenButtonPressed;
	
	boolean backButton;
	private Color[] boardingGroup;
	
	public QueueScreen(DrawingSurface marker) {
		super(marker);
		
	}
	
	public void draw() {
		surface.fill(255);
		surface.rect(40, 40, 100, 50);
		surface.fill(255);
		surface.rect(150, 40, 100, 50);
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		
	}
	
	public int mouseRelased() {
		int index = 1;
		if(playScreenButtonPressed) {
			playScreenButtonPressed = false;
			index = 2;
		}
		if(backButton) {
			backButton = false;
			index = 0;
		}
		return index;
	}
	
	public void setboardingGroup(Color[] colors) {
		boardingGroup = colors;
		for(int i = 0; i < boardingGroup.length; i ++) {
			System.out.println(boardingGroup[i].getRed());
		}
	}

}
