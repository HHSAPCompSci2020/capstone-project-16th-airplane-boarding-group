package boardingGroupthe16th;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 * main method of the program sets the window
 * @author joshua choi
 *
 */
//a
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1280, 720);
		window.setMinimumSize(new Dimension(200,200));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}

}
