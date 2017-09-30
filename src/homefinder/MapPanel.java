package homefinder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import slider.IRangeSliderListener;
import slider.RangeSliderModel;


public class MapPanel extends JPanel{
	
	private List<Home> homes;
	
	private ControlPanel controlPanel;
	
	private BufferedImage image;

	public MapPanel(LinkedList<Home> homes, ControlPanel controlPanel) {
		this.homes=homes;
		this.controlPanel=controlPanel;
		try {
			image = ImageIO.read(new File("./map.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		RangeSliderModel prixModele = controlPanel.getPrixModele();
		RangeSliderModel pieceModele = controlPanel.getPieceModele();
		
		prixModele.addListener(new IRangeSliderListener() {
			
			@Override
			public void valueChanged(int value) {
				repaint();
				
			}
			
			@Override
			public void upperValueChanged(int value) {
				repaint();
				
			}
		});
		
			pieceModele.addListener(new IRangeSliderListener() {
			
			@Override
			public void valueChanged(int value) {
				repaint();
				
			}
			
			@Override
			public void upperValueChanged(int value) {
				repaint();
				
			}
		});

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		/* Draw the "map" */
		g2d.drawImage(this.image, 0, 0, null);

		RangeSliderModel wPriceModel = controlPanel.getPrixModele();
		RangeSliderModel wRoomModel = controlPanel.getPieceModele();

		/* Draw dots on the map to symbolize homes */
		g.setColor(Color.RED);
		for (Home home : homes) {
			/* Check wether we have to display this Home or not */
			if (wPriceModel.getValue() < home.getPrix() && home.getPrix() < wPriceModel.getUpperValue()
					&& wRoomModel.getValue() < home.getNbPiece() && home.getNbPiece() < wRoomModel.getUpperValue()) {
				Position position = home.getPosition();
				Ellipse2D.Double circle = new Ellipse2D.Double(position.getX(), position.getY(), 20,
						20);
				g2d.fill(circle);
			}
		}

	}

}
