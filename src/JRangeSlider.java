import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

public class JRangeSlider extends JComponent implements RangeSlider, SwingConstants {

	private int min; // borne min
	private int max; // borne max
	private int valueMax; // curseur max
	private int valueMin; // curseur min
	private int extent; // pas 
	
	@Override
	public int getMax() {
		
		return max;
	}

	@Override
	public int getMin() {
		return min;
	}

	@Override
	public int getValueMax() {
		return valueMax;
	}

	@Override
	public int getValueMin() {
		return valueMin;
	}

	@Override
	public int getRange() {
		return max-min;
	}

	@Override
	public int getExtent() {
		return extent;
	}

	@Override
	public void addChangeListener(ChangeListener e) {
		
	}

	@Override
	public void setMax(int max) {
		if(max > min)
		{
			this.max = max;
		}
	}

	@Override
	public void setMin(int min) {
		if(max < min)
		{
			this.min = min;
		}
		
	}

	@Override
	public void setValueMax(int valueMax) {
		if(valueMax <= this.getMax() && valueMax > this.getMin() && valueMax > getValueMin()) 
		{
			this.valueMax = valueMax;
		}
		
	}

	@Override
	public void setValueMin(int valueMin) {
		if(valueMin >= this.getMin() && valueMin < this.getMax() && valueMin < getValueMax()) 
		{
			this.valueMin = valueMin;
		}
	}

	@Override
	public void setExtent(int extent) {
		if(extent > 0 && extent < this.getMax() - this.getMin())
		{
			this.extent = extent;
		}
	}

}
