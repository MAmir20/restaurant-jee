package tn.enis.model;

public class Pizza {
	private String nom;
	private float prix;
	private int qte = 1;
	public Pizza(String nom, float prix, int qte) {
		this.nom = nom;
		this.prix = prix;
		this.qte = qte;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
}
