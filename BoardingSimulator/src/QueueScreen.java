
public class QueueScreen extends Screen{
	
	//screen no 1
	
	
	
	boolean playScreenButtonPressed;
	
	boolean backButton;
	
	public QueueScreen(DrawingSurface marker) {
		super(marker);
	}
	
	public void draw() {
		
		surface.rect(40, 40, 100, 50);
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

}
