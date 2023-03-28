package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
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
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoi un grand coup dans la machoir de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci druide, je sens que ma force est " + forcePotion + " fois d√©cupl√©e !");
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m√¢choire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3)*effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees == 0) {
			parler("Je ne peux pas faire de don au musÈe car je n'ai pas de trophÈes.");
		} else {
			parler("Je donne au musÈe tous mes trophÈes : ");
			
			while (nbTrophees != 0) {
				System.out.println("- " + trophees[nbTrophees-1].toString());
				musee.donnerTrophees(this,trophees[nbTrophees-1]);
				nbTrophees -= 1;
			}

		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast√©rix",8);
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
