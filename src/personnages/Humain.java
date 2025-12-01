package personnages;

public class Humain {

	private String nom;
	private String boissonFavorite;
	protected int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[30];

	public Humain(String nom, String boissonFavorite, int argent) {
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

	protected void gagnerArgent(int gain) {
		isPriceValid(gain);
		this.argent += gain;
	}

	protected void perdreArgent(int perte) {
		isPriceValid(perte);
		this.argent -= perte;
	}

	protected void parler(String texte) {
		System.out.println("(" + this.getNom() + ") - " + texte);
	}

	public void direBonjour() {
		StringBuilder texte = new StringBuilder();
		texte.append("Bonjour ! Je m'appelle ");
		texte.append(nom);
		texte.append(" et j'aime boire du ");
		texte.append(boissonFavorite + ".");


		parler(texte.toString());

	}

	public void boire() {
		StringBuilder texte = new StringBuilder();
		texte.append("Hmmm, un bon verre de ");
		texte.append(boissonFavorite);
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
	
	private void memoriser(Humain humain) {
		if(this.nbConnaissance<30) {
			this.memoire[nbConnaissance] = humain;
			this.nbConnaissance++;
		}
	}
	
	private void repondre(Humain humain) {
		this.direBonjour();
		this.memoriser(humain);
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		this.direBonjour();
		autreHumain.repondre(this);
		this.memoriser(autreHumain);
	}
	
	public void listerConnaissance() {
		StringBuilder texte = new StringBuilder();
		texte.append("Je connais beaucoup de monde dont : ");
		for (int i = 0; i < this.nbConnaissance-1; i++) {
			texte.append((this.memoire[i]).getNom() + ", ");
		}
		texte.append((this.memoire[this.nbConnaissance-1]).getNom() + ".");
		
		parler(texte.toString());
	}
	
	
}
