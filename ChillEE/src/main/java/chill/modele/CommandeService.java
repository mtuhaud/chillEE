package chill.modele;

import java.util.ArrayList;
import java.util.List;

public class CommandeService {
	
	private List<Boisson> listeBoissons;
	private List<Plat> listePlats;
	private List<Dessert> listeDesserts;
	
	public CommandeService() {
		creerListeBoissons();
		creerListePlats();
		creerListeDesserts();
	}
	
	private void creerListeBoissons() {
		listeBoissons = new ArrayList<Boisson>();
		listeBoissons.add(new Boisson(1, "Coca Cola"));
		listeBoissons.add(new Boisson(2, "Ice Tea"));
		listeBoissons.add(new Boisson(3, "Fanta"));
		listeBoissons.add(new Boisson(4, "Jus d'orange BIO"));
		listeBoissons.add(new Boisson(5, "Jus de pomme BIO"));
		listeBoissons.add(new Boisson(6, "Bouteille d'eau"));
	}
	
	private void creerListePlats() {
		listePlats = new ArrayList<Plat>();
		listePlats.add(new Plat(1, "Oslo Bagel", "Saumon fumé, avocat, "));
		listePlats.add(new Plat(2, "Texas Bagel", "Steack haché, cheddar, salades, tomates, oignon rouge"));
		listePlats.add(new Plat(3, "Paris Bagel", "Jambon de bayonne, chèvre, salade, tomate confite "));
		listePlats.add(new Plat(4, "Venise Bagel", "Mozarella, tomates, pesto, roquette"));
		listePlats.add(new Plat(5, "London Bagel", "Bacon, oeufs, cheddar, salade"));

	}
	
	private void creerListeDesserts() {
		listeDesserts = new ArrayList<Dessert>();
		listeDesserts.add(new Dessert(1, "Fondaut au chocolat"));
		listeDesserts.add(new Dessert(2, "Muffin"));
		listeDesserts.add(new Dessert(3, "Brownie"));
		listeDesserts.add(new Dessert(4, "Tiramisu"));
		listeDesserts.add(new Dessert(5, "Crumble aux pommes"));

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

}
