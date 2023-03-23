package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+texte);
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force>0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
	}
	public static void main(String[] args) {
		Romain lambda = new Romain("Lambda",8);
		lambda.parler("bonjour");
		lambda.recevoirCoup(7);
		lambda.recevoirCoup(1);
	}
}
