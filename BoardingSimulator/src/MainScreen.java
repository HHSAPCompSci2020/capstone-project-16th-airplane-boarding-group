import processing.core.PApplet;

public class MainScreen extends Screen{
	
	
	// screen no 0
	
	Aircraft boeing747;
	private boolean createQueueButtonPressed;
	
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
		surface.rect(40, 40, 25, 50);
		surface.fill(0);
		surface.text("create boarding groups", 40, 40);
		
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		if(mouseX > 40 && mouseX > 90 && mouseY > 40 && mouseY < 65 ) {
			createQueueButtonPressed = true;
		}
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
