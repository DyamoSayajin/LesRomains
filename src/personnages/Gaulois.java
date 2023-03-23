package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+texte);
	}
	
	public String prendreParole() {
		return "Le gaulois "+ nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoi un grand coup dans la machoir de " + romain.getNom());
		romain.recevoirCoup((force/3)*effetPotion);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci druide, je sens que ma force est " + forcePotion + " fois décuplée !");
	}
	
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Bonjour je suis asterix");
		Romain romain = new Romain("Lambda",6);
		asterix.frapper(romain);
		asterix.frapper(romain);
		asterix.frapper(romain);
		asterix.boirePotion(9);
	}
}
