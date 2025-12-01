package personnages;

public enum TypeHumain {
	COMMERCANT("un commercant"), YAKUZA("un yakuza"), RONIN("un ronin"), SAMOURAI("un samourai"),
	HABITANT("un habitant"), GRANDMERE("une grand-mere");

	private String nom;

	private TypeHumain(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}
