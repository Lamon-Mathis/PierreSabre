package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, int argent, String clan) {
		super(nom, "whisky", argent);
		this.clan = clan;

	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int butin = victime.seFaireExtorquer();
		this.argent += butin;
		StringBuilder phraseDeFin = new StringBuilder();
		phraseDeFin.append("J'ai piqué les ");
		phraseDeFin.append(butin);
		phraseDeFin.append(" sous de " + victime.getNom() + " , ce qui me fait ");
		phraseDeFin.append(this.getArgent());
		phraseDeFin.append(" sous dans ma poche. Hi ! Hi !");
		this.reputation++;
		parler(phraseDeFin.toString());

	}

	public void perdre() {

		this.reputation--;
		StringBuilder texte = new StringBuilder();
		texte.append("J'ai perdu mon duel et mes ");
		texte.append(this.getArgent());
		texte.append(" sous, snif... J'ai déshonoré le clan de " + this.clan);
		this.argent = 0;
		parler(texte.toString());

	}
	
	public void gagner(int gain) {
		
		this.reputation++;
		this.argent+=gain;
		StringBuilder texte = new StringBuilder();
		texte.append("Ce ronin pensait vraiment battre " + this.getNom() + " du clan de " + this.clan + " ?");
		texte.append(" Je l'ai dépouillé de ses ");
		texte.append(gain);
		texte.append(" sous.");
		parler(texte.toString());
	}

}
