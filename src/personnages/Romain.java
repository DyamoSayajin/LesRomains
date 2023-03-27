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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		
//		int forceAvant = force;
//		
//		force -= forceCoup;
//		if (force>0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		
//		int forceApres = force;
//		assert forceApres<forceAvant;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		
		// précondition
		
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		
		 if (force > 0) {
			 parler("Aïe");
		 } 
		 else {
			 equipementEjecte = ejecterEquipement();
			 parler("J'abandonne...");
		 }

		
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
					} 													
				else {
					System.out.println("Equipement casque");				
					resistanceEquipement += 5;
					}
				}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		
		//Correction du bug qui faisait augmenté la force du romain quand la résistance de l'équipement était supérieur à celle du coup.
		//N'ayant pas de consigne sur la correction du bug j'ai choisi de faire 1 de dégats au romain dans ce cas pour pas que sa force soit constante.
		//Néanmoins dans ce cas précis le texte afficher ne sera pas cohérent. 
		
		
		if (resistanceEquipement >= forceCoup) {
			forceCoup = 1;
		} else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}


	
	
	
	public int getForce() {
		return force;
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
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
		return equipementEjecte;
	}

	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
