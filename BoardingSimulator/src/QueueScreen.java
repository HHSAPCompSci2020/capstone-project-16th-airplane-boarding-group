import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import akeskar099.shapes.Rectangle;

public class QueueScreen extends Screen{
	//a
	/**
	@author Aryan Keskar
	*/
	
	//screen no 1
	private int buttonY  = 20;
	private int backX = 40;
	private int playX = 150;

	private int buttonWidth = 100;
	private int buttonHeight = 50;
	
	private boolean playScreenButtonPressed;
	private boolean backButton;

	private Color[] boardingGroups;
	private Rectangle[] initialList;
	private Color[] finalList;
	
	/**
	 * Constructor of QueScreen, makes a new screen with all boolean values false
	 * @param marker
	 */
	public QueueScreen(DrawingSurface marker) {
		super(marker);
		playScreenButtonPressed = false;
		backButton = false;
		
	}
	/**
	 * Draws the screen with buttons and boarding groups
	 */
	public void draw() {
		
		surface.fill(0);
		surface.text("In order to create a queue arrange all boardingGroups in a vertical line", 300, 50);
		surface.noFill();
		if(backButton)
			surface.fill(255,0,0);
		else 
			surface.fill(255);
		surface.rect(backX, buttonY, buttonWidth, buttonHeight);
		
		surface.fill(0);
		surface.text("go back", 65, 50);
		
		if(playScreenButtonPressed)
			surface.fill(255,0,0);
		else 
			surface.fill(255);
		surface.rect(playX, buttonY, buttonWidth+30, buttonHeight);
		
		surface.fill(0);
		surface.text("Go to simulation", 170, 50);
		
		

		for(int i = 0; i < initialList.length; i++) {
	
			surface.fill(initialList[i].getRed(), initialList[i].getGreen(), initialList[i].getBlue());
	
			int width = (int)(initialList[i].getExtent());
			surface.rect(initialList[i].getX(), initialList[i].getY(), width, width);

			surface.fill(255);
			
		}
	}
	/**
	 * called when mouse is pressed sets the boolean value of the field associated with the button to true. It is called in the DrawingSurface
	 * Class' draw method
	 * @param mouseX: x coordinate of the mouse
	 * @param mouseY: y coordinate of the mouse
	 */
	public void mousePressed(int mouseX, int mouseY) {
		if(mouseX > backX && mouseX < (backX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			backButton = true;
		if(mouseX > playX && mouseX < (playX+buttonWidth) && mouseY > buttonY && mouseY < (buttonY + buttonHeight))
			playScreenButtonPressed = true;
	}
	/**
	 * Called when the mouse is released sets boolean values to false and is responsible for choosing the next screen
	 * @return int: returns the index of the next screen.
	 */
	public int mouseReleased() {
		int index = 1;
		if(playScreenButtonPressed) {
			sortIntoFinal();
			playScreenButtonPressed = false;
			index = 2;
		}
		if(backButton) {
			backButton = false;
			index = 0;
		}

		return index;
	}
	
	/**
	 * sets the list of boarding groups in this class equal to list of boarding groups passed
	 * @param colors: the array of boarding groups
	 */
	public void setboardingGroup(Color[] colors) {
		boardingGroups = colors;
		initialList = new Rectangle[boardingGroups.length];
		fillInitialList();
		finalList = new Color[boardingGroups.length];
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
		boolean sort = false;
		ArrayList<Integer> ofYValues = new ArrayList<Integer>();
		int[] indices = new int[initialList.length];
		for(int i = 0; i < initialList.length; i++) {
			ofYValues.add(initialList[i].getY());
		}
		Collections.sort(ofYValues);
		
		for(int i = 0; i < ofYValues.size(); i++) {
			if((i+1) < ofYValues.size()) {
				if(ofYValues.get(i+1) == ofYValues.get(i)) {
					finalList = boardingGroups;
					sort = true;
					break;
				}
			}
		}
		if(!sort) {
			for(int i = 0; i < ofYValues.size(); i++) {
				for(int n = 0; n < initialList.length; n++) {
					if(ofYValues.get(i) == initialList[n].getY())
						indices[n] = i;
				}
			}
			for(int i = 0; i < indices.length; i++) {
				finalList[i] = new Color(initialList[indices[i]].getRed(), 
						initialList[indices[i]].getGreen(), initialList[indices[i]].getBlue());
			}
		}
	}
	
	/**
	 * moves the rectangles representing the boarding groups
	 * @param mouseX
	 * @param mouseY
	 */
	public void mouseDragged(int mouseX, int mouseY) {
		
		for(int i = 0; i < initialList.length; i ++) {
			int positionX = initialList[i].getX();
			int positionY = initialList[i].getY();
			int width = (int)(initialList[i].getExtent());
			if(mouseX > positionX && mouseX < (width + positionX)&& mouseY > positionY && mouseY < (width + positionY)) {
		
				//initialList[i].setX(mouseX - width/2);
				initialList[i].setY(mouseY - width/2);
				// && mouseY > positionY && mouseY < (width + positionY)
			}
		}
		//System.out.println(initialList.length);
	}
	/**
	 * Returns the final boarding order
	 * @return finalList
	 */
	public Color[] getFinalList() {
		System.out.println(finalList);
		return finalList;
	}
	
}
