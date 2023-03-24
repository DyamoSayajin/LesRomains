package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
			villageois[nbVillageois] = gaulois;
			nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero]; 
	}
	public void afficherHabitant() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		Gaulois obelix = new Gaulois("Obélix",25);
		
		Village village = new Village("Village des Irréductibles",30);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		Chef abraracourcix = new Chef("Abraracourcix",8,village);
		village.chef = abraracourcix;
		
		village.afficherHabitant();
	}
}
