import java.awt.Color;
import java.util.ArrayList;
import akeskar099.shapes.Rectangle;

public class QueueScreen extends Screen{
	
	//screen no 1
	private int buttonY  = 40;
	private int backX = 40;
	private int playX = 150;
	private int doneX = 260;
	private int buttonWidth = 100;
	private int buttonHeight = 50;
	
	private boolean playScreenButtonPressed;
	private boolean backButton;
	private boolean donePressed;
	
	private Color[] boardingGroups;
	private ArrayList<Rectangle> initialList;
	
	public QueueScreen(DrawingSurface marker) {
		super(marker);
		initialList = new ArrayList<Rectangle>();
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
		
		for(int i = 0; i < initialList.size(); i++) {
			surface.fill(initialList.get(i).getRed(), initialList.get(i).getGreen(), initialList.get(i).getBlue());
			int width = (int)(initialList.get(i).getExtent());
			surface.rect(initialList.get(i).getX(), initialList.get(i).getY(), width, width);
			
		}
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
		fillInitialList();
		for(int i = 0; i < boardingGroups.length; i ++) {
			System.out.println(boardingGroups[i].getRed());
		}
	}
	
	private void fillInitialList() {
		int positionX = 40;
		int positionY = 100;
		int width = 30;
		for(int i = 0; i < boardingGroups.length; i ++) {
			Rectangle rect = new Rectangle(positionX, positionY, width, width, 
					boardingGroups[i].getRed(), boardingGroups[i].getGreen(), boardingGroups[i].getBlue());
			initialList.add(rect);
			positionX = positionX + 20;
			if(positionX >= 600) {
				positionY = positionY + 40;
				positionX = 40;
			}
		}
	}
	
}
