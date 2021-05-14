
public class Play  extends Screen{
	
	Timer timer = new Timer();
	
	

	public Play(DrawingSurface marker) {
		super(marker);
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		timer.draw(surface);
	}

}
