package personnages;

public class Humain {

	private String nom;
	private String boissonFavorite;
	protected int argent;

	public Humain(String nom, String boissonFavorite, int argent) {
		super();
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void isPriceValid(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("Prix invalide :" + price);
		}
	}

	public void gagnerArgent(int gain) {
		isPriceValid(gain);
		this.argent += gain;
	}

	public void perdreArgent(int perte) {
		isPriceValid(perte);
		this.argent -= perte;
	}

	protected void parler(String texte) {
		System.out.println("(" + this.getNom() + ") - " + texte);
	}

	public void direBonjour() {
		StringBuilder texte = new StringBuilder();
		texte.append("Bonjour ! Je m'appelle ");
		texte.append(this.getNom());
		texte.append(" et j'aime boire du ");
		texte.append(this.boissonFavorite + ".");


		parler(texte.toString());

	}

	public void boire() {
		StringBuilder texte = new StringBuilder();
		texte.append("Hmmm, un bon verre de ");
		texte.append(this.boissonFavorite);
		texte.append(" ! GLOUPS !");
		parler(texte.toString());
	}

	public void acheter(String bien, int prix) {
		isPriceValid(prix);
		StringBuilder texte = new StringBuilder();
		if (this.getArgent() >= prix) {
			texte.append("J'ai ");
			texte.append(this.getArgent());
			texte.append(" sous en poche. ");
			texte.append("Je vais pouvoir m'offrir ");
			texte.append(bien);
			texte.append(" à ");
			texte.append(prix);
			texte.append(" sous.");
			this.perdreArgent(prix);
		} else {
			texte.append("Je n'ai plus que ");
			texte.append(this.getArgent());
			texte.append(" sous en poche. ");
			texte.append("Je ne peux même pas m'offrir ");
			texte.append(bien);
			texte.append(" à ");
			texte.append(prix);
			texte.append(" sous.");
		}

		parler(texte.toString());

	}
}
