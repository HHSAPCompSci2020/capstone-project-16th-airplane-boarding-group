import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
//a
public class NewMainScreen extends Screen{
	
	//private QueueScreen queue;
	private Aircraft aircraft;//
	
	private int topPanelX = 0;//
	private int topPanelY = 0;
	private int topPanelLength;
	private int topPanelWidth;
	
	private int queuePanelX = 0;//
	private int queuePanelY;
	private int queuePanelLength;
	private int queuePanelWidth;
	
	private int playButtobX = 0;//
	private int playButtonY;
	private int playLength;
	private int playWidth;
	
	private int currentX;
	private int currentY;
	private int currentLength;
	private int currentWidth;
	
	private int newGroupX;
	private int newGroupY;
	private int newGroupLength;
	private int newGfoupWidth;
	
	private Color[] boardingGroupColors;
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public NewMainScreen(DrawingSurface marker) {
		super(marker);
		
		// initialized boardingGroupColors
		boardingGroupColors = new Color[7];
		
		// initialized aircraft
		int x = (int) (screenSize.getWidth()*0.2);
		int y = (int)(screenSize.getHeight()*0.1);
		int width = (int)(screenSize.getHeight()- (2*y));
		int length = (int)(screenSize.getWidth() - x);
		
		aircraft = new Aircraft(x, y, length, width);
		
		// initializing top panels
		topPanelLength = (int)(screenSize.getWidth());
		topPanelWidth = (int)(screenSize.getHeight());
		
		//initializing queue panel
		queuePanelY = y;
		queuePanelLength = (int)(screenSize.getWidth()*0.2);
		queuePanelWidth = width;
		
		//initializing play button
		playButtonY = (int)(screenSize.getHeight()*0.9);
		playLength = (int)(screenSize.getWidth());
		playWidth = (int)(screenSize.getHeight()*0.1);
		
		//initializing current color
		currentX = 
				
	}
	
	public void draw() {
		aircraft.draw(surface);
	}
	
	public int mouseReleased() {
		return 2;
	}

}
