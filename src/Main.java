import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public final static int FRAME_HEIGHT = 500;
	public final static int FRAME_WIDTH = 500;
	
	private JFrame frame;
	
	Main() {
		frame = new JFrame("Arpock");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//frame.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	}
}
