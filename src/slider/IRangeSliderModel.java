package slider;

import java.util.List;

public interface IRangeSliderModel {
	
	public void addListener(IRangeSliderListener iRangeSliderListener);
	
	public void removeListener(IRangeSliderListener iRangeSliderListener);
	
	public int getMaximum();
	
	public int getMinimum();
	
	public int getValue();
	
	public int getUpperValue();
	
	public void setModel(int min, int max, int value, int upperValue);
	
	public void setValue(int value);
	
	public void setUpperValue(int uppperValue);
	
	public int getRange();
}
