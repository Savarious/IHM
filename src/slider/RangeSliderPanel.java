package slider;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class RangeSliderPanel extends JPanel{
	
	private static final long serialVersionUID = 5490768304007301683L;

	private RangeSlider pRangeSlider;
	private JLabel pMinLabel;
	private JLabel pMaxLabel;
	private JLabel pRangeValuesLabel;
	
	
	public RangeSliderPanel(String label, int min, int max, int value, int upperValue) {

		setLayout(new BorderLayout());

		this.pRangeSlider = new RangeSlider(min, max, value, upperValue);
		this.pMinLabel = new JLabel();
		this.pMaxLabel = new JLabel();
		this.pRangeValuesLabel = new JLabel();
		
		updateLabels();


		JPanel wValuesPanel = new JPanel();
		wValuesPanel.setLayout(new FlowLayout());
		wValuesPanel.add(new JLabel(label + " : "));
		wValuesPanel.add(this.pRangeValuesLabel);

		add(wValuesPanel, BorderLayout.NORTH);
		add(this.pMinLabel, BorderLayout.WEST);
		add(this.pMaxLabel, BorderLayout.EAST);
		add(this.pRangeSlider, BorderLayout.CENTER);

		/*
		 * Update the label values when there is an interaction with the
		 * RangeSlider
		 */
		this.pRangeSlider.getRangeSliderModel().addListener(new IRangeSliderListener() {

			@Override
			public void valueChanged(int new_value) {
				RangeSliderPanel.this.updateLabels();
			}

			@Override
			public void upperValueChanged(int value) {
				RangeSliderPanel.this.updateLabels();
			}
		});

	}


	protected void updateLabels() {
		RangeSliderModel rangeSliderModel = pRangeSlider.getRangeSliderModel();
		pMinLabel.setText("" + rangeSliderModel.getMinimum());
		pMaxLabel.setText("" + rangeSliderModel.getMinimum());
		pRangeValuesLabel.setText(rangeSliderModel.getValue() + " - " +  rangeSliderModel.getUpperValue());
	}

}
