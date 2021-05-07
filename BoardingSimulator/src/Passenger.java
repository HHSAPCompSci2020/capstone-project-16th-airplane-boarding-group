import java.awt.Color;
import processing.core.PApplet;

public class Passenger {
	
	private int x, y;
	private int radius;
	private Color boardingGroup;
	
	public Passenger(int x, int y, int radius, Color boardingGroup) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.boardingGroup = boardingGroup;
	}

}
