package slider;

import java.util.ArrayList;

public class RangeSliderModel implements IRangeSliderModel{
	
	ArrayList<IRangeSliderListener> iRangeSliderListenerList = new ArrayList<IRangeSliderListener>();
	
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
		if(!this.iRangeSliderListenerList.contains(iRangeSliderListener)){
			iRangeSliderListenerList.add(iRangeSliderListener);
			
			System.out.println("Add listener");
		}
		
		System.out.println("Nb listeners : " + iRangeSliderListenerList.size());
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
		
		
		if (value != this.value) {
			this.value = value;
			for (int i = 0; i < this.iRangeSliderListenerList.size(); i++) {
				this.iRangeSliderListenerList.get(i).valueChanged(value);
				System.out.println("set value listener  " + this.iRangeSliderListenerList.get(i));
			}
		}
		
	}

	@Override
	public void setUpperValue(int upperValue) {

		
		if (upperValue != this.upperValue) {
			this.upperValue = upperValue;
			for (int i = 0; i < this.iRangeSliderListenerList.size(); i++) {
				this.iRangeSliderListenerList.get(i).upperValueChanged(upperValue);
				System.out.println("set upper value listener  " + this.iRangeSliderListenerList.get(i));
			}
		}
	}

	@Override
	public int getRange() {
		return maximum-minimum;
	}
	

	
}
