package slider;

import java.util.ArrayList;

public class RangeSliderModel implements IRangeSliderModel{
	
	ArrayList<IRangeSliderListener> iRangeSliderListenerList ;
	
	int value;
	int upperValue;
	int minimum;
	int maximum;

	@Override
	public int getMaximum() {
		return maximum;
	}

	@Override
	public int getMinimum() {
		return minimum;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public int getUpperValue() {
		return upperValue;
	}

	@Override
	public void addListener(IRangeSliderListener iRangeSliderListener) {
		iRangeSliderListenerList.add(iRangeSliderListener);
		
	}

	@Override
	public void removeListener(IRangeSliderListener iRangeSliderListener) {
		if(iRangeSliderListenerList.contains(iRangeSliderListenerList)){
			iRangeSliderListenerList.remove(iRangeSliderListener);
		}
	}

	// Car on ne peut pas avoir un constructeur depuis l'interface
	@Override
	public void setModel(int min, int max, int value, int upperValue) {
		minimum=min;
		maximum=max;
		this.value=value;
		this.upperValue=upperValue;
	}

	@Override
	public void setValue(int value) {
		this.value=value;
		
	}

	@Override
	public void setUpperValue(int uppperValue) {
		this.upperValue=uppperValue;
	}

	@Override
	public int getRange() {
		return maximum-minimum;
	}

}
