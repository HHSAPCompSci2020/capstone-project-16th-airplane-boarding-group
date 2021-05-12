import processing.core.PApplet;

public class MainScreen extends Screen{
	
	
	// screen no 0
	
	private DrawingSurface surface;
	Aircraft boeing747;
	boolean makeBoardingGroupPressed;
	
	public MainScreen(int width, int height, DrawingSurface marker) {
		super();
		surface = marker;
		boeing747 = new Aircraft();
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		boeing747.draw(surface);
		surface.fill(0);
		surface.text("create barding groups", 40, 40);
		if(makeBoardingGroupPressed)
			surface.fill(255, 0, 0);
		else
			surface.fill(255);
		surface.rect(40, 40, 200, 100);
		
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		makeBoardingGroupPressed = true;
	}
	
	public int mouseReleased() {
		if(makeBoardingGroupPressed)
			makeBoardingGroupPressed = false;
		return 1;
	}

}
