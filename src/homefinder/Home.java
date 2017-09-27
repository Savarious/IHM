package homefinder;

public class Home {

	private Position position;
	
	private int nbPiece;
	
	private int prix;

	public Home(Position position, int nbPiece, int prix) {
		super();
		this.position = position;
		this.nbPiece = nbPiece;
		this.prix = prix;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	
}
