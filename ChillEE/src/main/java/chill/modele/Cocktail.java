package chill.modele;

import java.util.ArrayList;
import java.util.List;

public class Cocktail {

	private int id;
	private String nom;
	private String composition;
	private List<Cocktail> listeCocktails;

	public Cocktail(int id, String nom, String composition) {
		this.id = id;
		this.nom = nom;
		this.composition = composition;
	}
	
	public Cocktail() {
		creerListeCocktails();
	}
	
	
	public void creerListeCocktails() {
		listeCocktails = new ArrayList<Cocktail>();
		listeCocktails.add(new Cocktail(1, "Blue Lagoon", "Vodka, curaçao bleu, jus de citron"));
		listeCocktails.add(new Cocktail(2, "Caipirinha", "Cachaça, citron vert, sucre"));
		listeCocktails.add(new Cocktail(3, "Margarita", "Tequila, cointreau, jus de citrons verts"));
		listeCocktails.add(new Cocktail(4, "Mojito", "Rhum cubain, jus de citrons verts, feuilles de menthe, eau gazeuse, sirop de sucre de canne"));
		listeCocktails.add(new Cocktail(5, "Piña Colada", "Rhum blanc, rhum ambré, jus d'ananas, lait de coco"));
	}
	
	public List<Cocktail> getListeCocktails() {
		return listeCocktails;
	}
	
	public Cocktail getCocktail(int numero) {
		for (Cocktail cocktail : listeCocktails) {
			if (cocktail.getId() == numero) {
				return cocktail;
			}
		}
		return null;
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
	
	public String getComposition() {
		return composition;
	}

}
