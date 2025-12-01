package personnages;

import java.util.Random;

public class GrandMere extends Humain {

	private Random pick = new Random();

	public GrandMere(String nom, int argent) {
		super(nom, "Tisane", argent);

	}

	@Override
	protected void memoriser(Humain humain) {

		if (this.nbConnaissance >= 5) {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");

		}
		super.memoriser(humain);

	}

	private String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		return (types[pick.nextInt(types.length)]).toString();
	}

	public void ragoter() {
		for (int i = 0; i < nbConnaissance - 1; i++) {
			StringBuilder texte = new StringBuilder();
			texte.append("Je crois que ");
			texte.append(memoire[i].getNom());
			texte.append(" est ");
			if (memoire[i] instanceof Traitre) {
				texte.append("un traitre");
				texte.append(".");
				texte.append(" Petit chenapan !");
			} else {
				texte.append(humainHasard());
				texte.append(".");
			}
			parler(texte.toString());

		}
	}

}
