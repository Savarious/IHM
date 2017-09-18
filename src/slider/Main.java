package slider;
import slider.RangeSliderPanel;

public class Main {

	public final static int FRAME_HEIGHT = 500;
	public final static int FRAME_WIDTH = 500;
	
	public static void main(String[] args) {
		RangeSliderPanel rangeSliderPanel = new RangeSliderPanel("Arpock", 0, 10, 5, 10);
		rangeSliderPanel.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		rangeSliderPanel.setVisible(true);
	
	}
}
