package personnages;

public class Ronin extends Humain {

	private int honneur = 1;
	
	public Ronin(String nom, int argent) {
		super(nom, "Sochu", argent);
	}
	
	
	public void donner(Commercant beneficiaire) {
		int don = this.argent/10;
		
		this.perdreArgent(don);
		StringBuilder texte = new StringBuilder();
		texte.append(beneficiaire.getNom() + " prend ces ");
		texte.append(don);
		texte.append(" sous.");
		parler(texte.toString());
		
		beneficiaire.recevoir(don);
		
		
	}
	
	public void gagner(int gain) {
		parler("Je t'ai eu petit Yakuza !");
		this.gagnerArgent(gain);
		this.honneur++;
		
	}
	
	public void perdre() {
		this.honneur--;
		this.argent=0;
		parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup");
	}
	
	
	public void provoquer(Yakuza adversaire) {
		int force = this.honneur*2;
		
		if (force>=adversaire.getReputation()) {
			int butin = adversaire.getArgent();
			this.gagner(butin);
			
		}
		else {
			this.perdre();
		}
		
	}
	

}
