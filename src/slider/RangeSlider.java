package slider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class RangeSlider extends JComponent implements MouseMotionListener, MouseListener, IRangeSliderListener  {

	private static final long serialVersionUID = -3450970077155082201L;
	
	private boolean draggingValue;
	private boolean draggingUpperValue;
	
	private Rectangle rectangleValue;
	private Rectangle rectangleUpperValue;
	
	private RangeSliderModel rangeSliderModel;
	
	static final int _rsize = 11;
	static final int _half_rsize = _rsize / 2;
	
	public RangeSlider(int min, int max, int value, int upperValue ) {
		draggingUpperValue=false;
		draggingValue=false;
		
		rectangleValue=new Rectangle(0,0,_rsize,_rsize);
		rectangleUpperValue=new Rectangle(0,0,_rsize,_rsize);
		
		rangeSliderModel = new RangeSliderModel();
		rangeSliderModel.setModel(min, max, value, upperValue);
		rangeSliderModel.addListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setSize(300, _rsize +1);
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("Pressed");
		
		if(rectangleValue.contains(e.getPoint())){
			draggingValue=true;
		}else if(rectangleUpperValue.contains(e.getPoint())){
			draggingUpperValue=true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		System.out.println("Released");
		
		draggingUpperValue=false;
		draggingValue=false;		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		System.out.println(this.rangeSliderModel.value);
		System.out.println(this.rangeSliderModel.upperValue);
		
		double left_pos = _half_rsize;
		double right_pos = getWidth() - _half_rsize - 2; // -2 for symmetry
		double width = right_pos - left_pos;

		if (this.draggingValue) {
			int result = (int) ((e.getX() / width) * (this.rangeSliderModel.getMaximum() - this.rangeSliderModel.getMinimum())
					+ this.rangeSliderModel.getMinimum());

			if (this.rangeSliderModel.getValue() != result && this.rangeSliderModel.getUpperValue() != result) {
				this.rangeSliderModel.setValue(result);
				checkValues();
			}
		} else if (this.draggingUpperValue) {
			int result = (int) ((e.getX() / width) * (this.rangeSliderModel.getMaximum() - this.rangeSliderModel.getMinimum())
					+ this.rangeSliderModel.getMinimum());

			if (this.rangeSliderModel.getUpperValue() != result && this.rangeSliderModel.getValue() != result) {
				this.rangeSliderModel.setUpperValue(result);
				checkValues();
			}
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		
		paintRange(graphics2d);
		paintThumb(graphics2d, rectangleUpperValue);
		paintThumb(graphics2d, rectangleValue);
		
		// Pourquoi ?
		graphics2d.dispose();
	}

	private void paintThumb(Graphics2D graphics2d, Rectangle rectangle) {
		Shape thumb = new Ellipse2D.Double(rectangle.getLocation().x, rectangle.getLocation().y, rectangle.getWidth(),
				rectangle.getHeight());
		
		graphics2d.setColor(Color.GRAY);
		graphics2d.fill(thumb);
		graphics2d.setColor(Color.BLACK);
		graphics2d.draw(thumb);
		
		System.out.println("Paint thumb");
		
	}


	private void paintRange(Graphics2D graphics2d) {
		
		double left_pos = _half_rsize;
		double top_pos = getHeight() % 2 == 0 ? getHeight() / 2 - 1 : getHeight() / 2;
		double right_pos = getWidth() - _half_rsize - 2; // - 2 for pretty
															// drawing (tested
															// on Windows)
		double width = right_pos - left_pos;

		double delta = this.rangeSliderModel.getMaximum() - this.rangeSliderModel.getMinimum();

		double lright_pos = left_pos + width * ((this.rangeSliderModel.getValue() - this.rangeSliderModel.getMinimum()) / delta);
		Shape left = new Line2D.Double(left_pos, top_pos, lright_pos, top_pos);
		double mright_pos = left_pos + width * ((this.rangeSliderModel.getUpperValue() - this.rangeSliderModel.getMinimum()) / delta);
		Shape middle = new Line2D.Double(lright_pos, top_pos, mright_pos, top_pos);
		Shape right = new Line2D.Double(mright_pos, top_pos, left_pos + width, top_pos);

		// Set thumbs location
		this.rectangleValue.setLocation((int) (lright_pos - _half_rsize), (int) (top_pos - _half_rsize));
		this.rectangleUpperValue.setLocation((int) (mright_pos - _half_rsize), (int) (top_pos - _half_rsize));

		graphics2d.setColor(Color.GRAY);
		graphics2d.draw(left);
		graphics2d.setColor(Color.BLUE);
		graphics2d.draw(middle);
		graphics2d.setColor(Color.GRAY);
		graphics2d.draw(right);
		
		
	}
	
	private void checkValues() {
		if (this.rangeSliderModel.getUpperValue() < this.rangeSliderModel.getValue()) {
			int temp = this.rangeSliderModel.getUpperValue();
			this.rangeSliderModel.setUpperValue(this.rangeSliderModel.getValue());
			this.rangeSliderModel.setValue(temp);

			boolean b_temp = this.draggingUpperValue;
			this.draggingUpperValue = this.draggingValue;
			this.draggingValue = b_temp;
		}
	}


	@Override
	public void valueChanged(int value) {
		repaint();		
	}

	@Override
	public void upperValueChanged(int value) {
		repaint();			
	}
	
	public RangeSliderModel getRangeSliderModel(){
		return rangeSliderModel;
	}

}
