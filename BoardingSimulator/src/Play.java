import java.awt.Color;

public class Play  extends Screen{
	
	Timer timer = new Timer();
	
	

	public Play(DrawingSurface marker) {
		super(marker);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		timer.draw(surface);
	}
	
	public void setBoardingGroup(Color[] colors) {
		
	}

}
