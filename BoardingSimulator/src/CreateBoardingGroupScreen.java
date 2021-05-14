
public class CreateBoardingGroupScreen extends Screen{
	
	// screen no 1
	
	
	private boolean backButtonPressed;
	private boolean createQueueButtonPressed;

	public CreateBoardingGroupScreen(DrawingSurface marker) {
		super(marker);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		surface.fill(0);
		surface.text("back", 40, 20);
		if(backButtonPressed)
			surface.fill(255, 0, 0);
		else
			surface.fill(255);
		surface.rect(40, 40, 100, 200);
		
		if(createQueueButtonPressed)
			surface.fill(255, 0, 0);
		else
			surface.fill(255);
		surface.rect(50, 40, 100, 200);
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		
	}
	public int mouseReleased() {
		int num = 1;
		
		if(createQueueButtonPressed) {
			createQueueButtonPressed = false;
			num = 2;
		}
		else if(backButtonPressed) {
			backButtonPressed = false;
			num = 0;
		}
		return num;
	}

}
