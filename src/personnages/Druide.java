package personnages;
import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour je suis le druide "+ nom +" et ma potion peut aller de " + effetPotionMin + " à " + effetPotionMax +".");
	}
	
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax);
		
		while (forcePotion<effetPotionMin) {
			forcePotion = random.nextInt(effetPotionMax+1);
		}
		
		if (forcePotion>7) {
			parler("J'ai préparer une super potion de force ! Elle est de force : " + forcePotion);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients pour ma potion, elle est seulement de force : " + forcePotion);
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}


	public void parler(String texte) {
		System.out.println(prendreParole()+texte);
	}
	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
	}
}
