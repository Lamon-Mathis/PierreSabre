package personnages;

import java.util.Random;


public class Traitre extends Samourai {

	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		StringBuilder texte = new StringBuilder();
		texte.append("Mais je suis un traître et mon niveau de traîtrise est : ");
		texte.append(this.niveauTraitrise + ". Chut !");
		parler(texte.toString());
	}

	public void ranconner(Commercant victime) {
		if (niveauTraitrise < 3) {
			int argentCommercant = victime.getArgent();
			int argentRanconner = argentCommercant * 2 / 10;

			victime.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			this.niveauTraitrise++;
			StringBuilder texte = new StringBuilder();
			texte.append("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi ");
			texte.append(argentRanconner + " sous ou gare à toi !");
			parler(texte.toString());
			victime.parler("Tout de suite grand " + getNom() + ("."));

		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");

		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif");
			
		} else {
			Random pick = new Random();
			Humain ami = memoire[pick.nextInt(nbConnaissance)];
			int don = argent * 1 /20;
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			StringBuilder texte = new StringBuilder();
			texte.append("Bonjour l'ami ! Je voudrais t'aider en te donnant ");
			texte.append(don + " sous.");
			parler(texte.toString());
			ami.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			ami.parler("Merci " + nom + ", vous êtes quelqu'un de bien ");
			if (niveauTraitrise>1) {
				niveauTraitrise--;
			}

		}
	}

}
