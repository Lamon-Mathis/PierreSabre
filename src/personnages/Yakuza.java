package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, int argent, String clan) {
		super(nom, "whisky", argent);
		this.clan=clan;
		
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int butin = victime.seFaireExtorquer();
		this.argent+= butin;
		StringBuilder phraseDeFin = new StringBuilder();
		phraseDeFin.append("J'ai piqué les ");
		phraseDeFin.append(butin);
		phraseDeFin.append(" sous de " + victime.getNom() + " , ce qui me fait ");
		phraseDeFin.append(this.getArgent());
		phraseDeFin.append(" sous dans ma poche. Hi ! Hi !");
		this.reputation++;
		parler(phraseDeFin.toString());
		
		
		
	}

}
