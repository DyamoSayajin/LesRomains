package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophees = 0;
	
	public Musee() {
		trophees = new Trophee[200];
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois,equipement);
		trophees[nbTrophees] = trophee;
		nbTrophees += 1;
	}
	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [" + '\n';
		for(int i=0; i<nbTrophees-1; i++) {
			texte += '"' + trophees[i].getGaulois().getNom() + '"' + ", " + '"' + trophees[i].getEquipement().toString() + '"' + ";\n";
		}
		texte += '"' +  trophees[nbTrophees-1].getGaulois().getNom() + '"' + ", " + '"' + trophees[nbTrophees-1].getEquipement().toString() + '"' + "\n";
		texte += "]";
		return texte;
	}
}
