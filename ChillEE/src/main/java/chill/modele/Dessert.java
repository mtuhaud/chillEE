package chill.modele;

import java.util.ArrayList;
import java.util.List;

public class Dessert {
	
	private int idDessert;
	private String nom;
	private String composition;
	private List<Dessert> listeDesserts;

	public Dessert(int idDessert, String nom, String composition) {
		this.idDessert = idDessert;
		this.nom = nom;
		this.composition = composition;
	}
	
	public Dessert(int idDessert, String nom) {
		this.idDessert = idDessert;
		this.nom = nom;
	}

	public Dessert() {
		creerListeDesserts();
	}
	
	public void creerListeDesserts() {
		listeDesserts = new ArrayList<Dessert>();
		listeDesserts.add(new Dessert(0, "Je ne veux pas de dessert"));
		listeDesserts.add(new Dessert(1, "Muffin"));
		listeDesserts.add(new Dessert(2, "Brownie"));
		listeDesserts.add(new Dessert(3, "Tiramisu"));
		listeDesserts.add(new Dessert(4, "Crumble aux pommes"));
		listeDesserts.add(new Dessert(5, "Fondant au chocolat"));

	}
	
	public List<Dessert> getListeDesserts() {
		return listeDesserts;
	}
	
	public Dessert getDessert(int numero) {
		for (Dessert dessert : listeDesserts) {
			if (dessert.getIdDessert() == numero) {
				return dessert;
			}
		}
		return null;
	}

	public int getIdDessert() {
		return idDessert;
	}

	public void setIdDessert(int idDessert) {
		this.idDessert = idDessert;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getComposition() {
		return composition;
	}

}
