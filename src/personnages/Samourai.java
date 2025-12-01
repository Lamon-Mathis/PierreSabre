package personnages;

public class Samourai extends Humain {

	private String seigneur;

	public Samourai(String seigneur, String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
		this.seigneur = seigneur;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		StringBuilder texte = new StringBuilder();
		texte.append("Je suis fier de servir le seigneur ");
		texte.append(this.seigneur);
		parler(texte.toString());
	}

	public void boire(String boisson) {
		StringBuilder texte = new StringBuilder();
		texte.append("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du ");
		texte.append(boisson + ".");
		parler(texte.toString());

	}

}
