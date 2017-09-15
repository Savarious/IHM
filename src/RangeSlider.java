import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.event.ChangeListener;


public interface RangeSlider {

	int getMax();
	int getMin();
	int getValueMax();
	int getValueMin();
	int getRange();
	int getExtent();
	
	void addChangeListener(javax.swing.event.ChangeListener e);
	
	void setMax(int max);
	void setMin(int min);
	void setValueMax(int valueMax);
	void setValueMin(int valueMin);
	void setExtent(int extent);
	
}
