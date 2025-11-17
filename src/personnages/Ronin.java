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
	
	public void provoquer(Yakuza adversaire) {
		int force = this.honneur*2;
		
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if(force>=adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza !");
			this.argent+=adversaire.getArgent();
			this.honneur++;
			adversaire.perdre();
			
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			this.honneur--;
			adversaire.gagner(this.argent);
			this.argent =0;
		}
	}
	

}
