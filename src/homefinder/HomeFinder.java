package homefinder;

import java.util.LinkedList;

import javax.swing.JFrame;


public class HomeFinder extends JFrame{
	
	private static final int Y_SIZE = 800;
	private static final int X_SIZE = 800;

	public HomeFinder(LinkedList<Home> wHomes) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		LinkedList<Home> homes = new LinkedList<>();
		int x, y, piece, prix;
		for (int i = 0; i < 42; i++) {
		
			x = (int) (Math.random() * 10000 % 800) + 1; // 1 < x < 800
			y = (int) (Math.random() * 10000 % 800) + 1; // 1 < y < 800
			piece = (int) (Math.random() * 10000 % 20) + 1; // 1 < rooms < 20
			prix = (int) (Math.random() * 10000 % 10000); // 1 < price < 10000
			homes.add(new Home(new Position(x, y), piece, prix));
		}

		HomeFinder homeFinder = new HomeFinder(homes);
		homeFinder.setSize(X_SIZE, Y_SIZE);
		homeFinder.setVisible(true);
		homeFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
