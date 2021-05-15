import java.awt.Color;

public class QueueScreen extends Screen{
	
	//screen no 1
	private int buttonY  = 40;
	private int backX = 40;
	private int playX = 150;
	private int buttonWidth = 100;
	private int buttonHeight = 50;
	
	boolean playScreenButtonPressed;
	boolean backButton;
	
	private Color[] boardingGroups;
	
	public QueueScreen(DrawingSurface marker) {
		super(marker);
		playScreenButtonPressed = false;
		backButton = false;
	}
	
	public void draw() {
		
		if(backButton)
			surface.fill(255,0,0);
		else 
			surface.fill(255);
		surface.rect(backX, buttonY, buttonWidth, buttonHeight);
		
		if(playScreenButtonPressed)
			surface.fill(255,0,0);
		else 
			surface.fill(255);
		surface.rect(playX, buttonY, buttonWidth, buttonHeight);
		
		
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		if(mouseX > backX && mouseX < (backX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			backButton = true;
		if(mouseX > playX && mouseX < (playX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			playScreenButtonPressed = true;
	}
	
	public int mouseReleased() {
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
		boardingGroups = colors;
		for(int i = 0; i < boardingGroups.length; i ++) {
			System.out.println(boardingGroups[i].getRed());
		}
	}

}
