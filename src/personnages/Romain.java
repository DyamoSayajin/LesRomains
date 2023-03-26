package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
		assert force>0;
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
		assert force>0;
		
		int forceAvant = force;
		
		force -= forceCoup;
		if (force>0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		
		int forceApres = force;
		assert forceApres<forceAvant;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement){
			case 2 : 
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1 : 
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement);
					break;
				}
				else {
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement);
					equipements[nbEquipement] = equipement;
					nbEquipement += 1;
					break;
				}
			default :
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement);
				equipements[nbEquipement] = equipement;
				nbEquipement += 1;
				break;
		}
		
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
