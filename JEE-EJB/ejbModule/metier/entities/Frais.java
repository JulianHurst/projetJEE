package metier.entities;

public class Frais {
	private String designation;
	private double montant;
	private byte justificatif;
	private Projet p;
	
	public Frais(String designation,double montant,byte justificatif){
		this.designation=designation;
		this.montant=montant;
		this.justificatif=justificatif;
	}
	
	public Frais(String designation,double montant,byte justificatif,Projet p){
		this.designation=designation;
		this.montant=montant;
		this.justificatif=justificatif;
		this.p=p;
	}
	
	public Frais(){}
}