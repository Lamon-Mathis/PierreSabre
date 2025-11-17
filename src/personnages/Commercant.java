package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public void recevoir(int argent) {
		isPriceValid(argent);
		this.gagnerArgent(argent);
		StringBuilder texte = new StringBuilder();
		texte.append(argent);
		texte.append(" sous ! Je te remercie généreux donnateur !");
		parler(texte.toString());
	}
	
	public int seFaireExtorquer() {
		int monnaiePerdue = this.getArgent();
		this.argent = 0;
		parler("J'ai tout perdu ! Le monde est trop injuste...");
		return monnaiePerdue;
	}
	

}
