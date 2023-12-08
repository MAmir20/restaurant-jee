package tn.enis.model;

public class Commande {
	private String id;
	private float nom;
	private int prenom;
	private int adresse;
	private int prix_total;
	public Commande(String id, float nom, int prenom, int adresse, int prix_total) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.prix_total = prix_total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getNom() {
		return nom;
	}
	public void setNom(float nom) {
		this.nom = nom;
	}
	public int getPrenom() {
		return prenom;
	}
	public void setPrenom(int prenom) {
		this.prenom = prenom;
	}
	public int getAdresse() {
		return adresse;
	}
	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}
	public int getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}
	
	
}
