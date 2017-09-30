package homefinder;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import slider.RangeSlider;
import slider.RangeSliderModel;
import slider.RangeSliderPanel;

public class ControlPanel extends JPanel{

	private RangeSliderPanel sliderPieces;
	
	private RangeSliderPanel sliderPrix;
	
	public ControlPanel() {
		sliderPieces= new RangeSliderPanel("Pieces", 1, 10, 2, 4);
		sliderPrix=new RangeSliderPanel("Prix", 0, 10000, 300, 1000);
		
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(sliderPieces);
		panel.add(sliderPrix);
		
		add(panel, BorderLayout.NORTH);
	}
	
	public RangeSliderModel getPrixModele(){
		return sliderPrix.getRangeSlider().getRangeSliderModel();
	}
	
	public RangeSliderModel getPieceModele(){
		return sliderPieces.getRangeSlider().getRangeSliderModel();
	}
}
