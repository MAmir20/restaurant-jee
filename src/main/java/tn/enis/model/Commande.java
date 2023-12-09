package tn.enis.model;

import java.util.Vector;

public class Commande {
	private static int counter = 0;
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private Vector<Pizza> pizzas;
	private Vector<Boisson> boissons;
	private int prix_total;
	public Commande(String nom, String prenom, String adresse, Vector<Pizza> pizzas, Vector<Boisson> boissons, int prix_total) {
		this.id = counter;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.pizzas = pizzas;
		this.boissons = boissons;
		this.prix_total = prix_total;
		counter++;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Commande.counter = counter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}
	public Vector<Boisson> getBoissons() {
		return boissons;
	}
	public void setBoissons(Vector<Boisson> boissons) {
		this.boissons = boissons;
	}
	public Vector<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Vector<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
}
