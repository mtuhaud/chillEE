package chill.modele;

import java.util.ArrayList;
import java.util.List;

public class Boisson {
	
	private int idBoisson;
	private String nom;
	private String composition;
	private List<Boisson> listeBoissons;
	
	
	
	public Boisson(int idBoisson, String nom, String composition) {
		this.idBoisson = idBoisson;
		this.nom = nom;
		this.composition = composition;
	}
		
	public Boisson(int idBoisson, String nom) {
		this.idBoisson = idBoisson;
		this.nom = nom;
	}
	
	public Boisson() {
		creerListeBoissons();
	}

	public void creerListeBoissons() {
		listeBoissons = new ArrayList<Boisson>();
		listeBoissons.add(new Boisson(0, "Je ne veux pas de boisson"));
		listeBoissons.add(new Boisson(1, "Coca Cola"));
		listeBoissons.add(new Boisson(2, "Ice Tea"));
		listeBoissons.add(new Boisson(3, "Fanta"));
		listeBoissons.add(new Boisson(4, "Jus d'orange BIO"));
		listeBoissons.add(new Boisson(5, "Jus de pomme BIO"));
		listeBoissons.add(new Boisson(6, "Bouteille d'eau"));
	}

	public List<Boisson> getListeBoissons() {
		return listeBoissons;
	}
	
	public Boisson getBoisson(int numero) {
		for (Boisson boisson : listeBoissons) {
			if (boisson.getIdBoisson() == numero) {
				return boisson;
			}
		}
		return null;
	}

	public int getIdBoisson() {
		return idBoisson;
	}
	public void setIdBoisson(int idBoisson) {
		this.idBoisson = idBoisson;
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
	public void setComposition(String composition) {
		this.composition = composition;
	}
	
	

}
