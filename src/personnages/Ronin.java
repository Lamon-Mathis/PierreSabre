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
	

}
