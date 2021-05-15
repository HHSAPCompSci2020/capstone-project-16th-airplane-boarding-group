import java.awt.Color;
import java.util.ArrayList;
import akeskar099.shapes.Rectangle;

public class QueueScreen extends Screen{
	
	//screen no 1
	private int buttonY  = 20;
	private int backX = 40;
	private int playX = 150;
	private int doneX = 260;
	private int buttonWidth = 100;
	private int buttonHeight = 50;
	
	private boolean playScreenButtonPressed;
	private boolean backButton;
	private boolean donePressed;
	
	private Color[] boardingGroups;
	private Rectangle[] initialList;
	private Color[] finalList;
	
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
		
		if(donePressed)
			surface.fill(255,0,0);
		else 
			surface.fill(255);
		surface.rect(doneX, buttonY, buttonWidth, buttonHeight);
		
		for(int i = 0; i < initialList.length; i++) {
	
			surface.fill(initialList[i].getRed(), initialList[i].getGreen(), initialList[i].getBlue());
	
			int width = (int)(initialList[i].getExtent());
			surface.rect(initialList[i].getX(), initialList[i].getY(), width, width);

			surface.fill(255);
			
		}
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		if(mouseX > backX && mouseX < (backX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			backButton = true;
		if(mouseX > playX && mouseX < (playX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			playScreenButtonPressed = true;
		if(mouseX > doneX && mouseX < (doneX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			donePressed = true;
	}
	
	public int mouseReleased() {
		int index = 1;
		if(playScreenButtonPressed && donePressed) {
			sortIntoFinal();
			playScreenButtonPressed = false;
			donePressed = false;
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
		initialList = new Rectangle[boardingGroups.length];
		fillInitialList();
		finalList = new Color[boardingGroups.length];
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
			initialList[i] = rect;
			positionX = positionX + 40;
			if(positionX >= 600) {
				positionY = positionY + 40;
				positionX = 40;
			}
		}
	}
	
	private void sortIntoFinal() {
		int minIndex = 0;
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int minValue = 20000;
		for(int i = 0; i < initialList.length; i++) {
			if(initialList[i].getY() < minValue && !hasElement(indices, initialList[i].getY())) {
				minValue = initialList[i].getY();
				minIndex = i;
				indices.add(i);
			}
		}
		
		for(int i = 0; i < indices.size(); i ++) {
			finalList[i] = new Color(initialList[indices.get(i)].getRed(), 
					initialList[indices.get(i)].getGreen(), initialList[indices.get(i)].getBlue());
		}
	}
	
	private boolean hasElement(ArrayList<Integer> indices, int num) {
		boolean hasElement = false;
		for(int i = 0; i < indices.size(); i++) {
			if(indices.get(i) == num) {
				hasElement = true;
			}
		}
		return hasElement;
	}
	
	public void mouseDragged(int mouseX, int mouseY) {
		for(int i = 0; i < initialList.length; i ++) {
			int positionX = initialList[i].getX();
			int positionY = initialList[i].getY();
			int width = (int)(initialList[i].getExtent());
			if(mouseX > positionX && mouseX < (width + positionX)&& mouseY > positionY && mouseY < (width + positionY)) {
		
				initialList[i].setX(mouseX - width/2);
				initialList[i].setY(mouseY - width/2);
				// && mouseY > positionY && mouseY < (width + positionY)
			}
		}
		//System.out.println(initialList.length);
	}
	
	public Color[] getFinalList() {
		return finalList;
	}
	
}
