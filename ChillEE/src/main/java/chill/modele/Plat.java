package chill.modele;

import java.util.ArrayList;
import java.util.List;

public class Plat {
	
	private int idPlat;
	private String nom;
	private String composition;
	private List<Plat> listePlats;

	
	public Plat(int idPlat, String nom, String composition) {
		this.idPlat = idPlat;
		this.nom = nom;
		this.composition = composition;
	}
	
	public Plat(int idPlat, String nom) {
		this.idPlat = idPlat;
		this.nom = nom;
	}
	
	public Plat() {
		creerListePlats();
	}

	public void creerListePlats() {
		listePlats = new ArrayList<Plat>();
		listePlats.add(new Plat(0, "Je ne veux pas de plat"));
		listePlats.add(new Plat(1, "Oslo Bagel", "Saumon fumé, avocat, fromage frais, ciboulette"));
		listePlats.add(new Plat(2, "Texas Bagel", "Steack haché, cheddar, salade, tomates, oignon rouge"));
		listePlats.add(new Plat(3, "Paris Bagel", "Jambon de bayonne, chèvre, salade, tomate confite "));
		listePlats.add(new Plat(4, "Venise Bagel", "Mozzarella, tomate, pesto, roquette"));
		listePlats.add(new Plat(5, "London Bagel", "Bacon, oeufs, cheddar, salade"));

	}

	public List<Plat> getListePlats() {
		return listePlats;
	}
	
	public Plat getPlat(int numero) {
		for (Plat plat : listePlats) {
			if (plat.getIdPlat() == numero) {
				return plat;
			}
		}
		return null;
	}
	
	public int getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(int idPlat) {
		this.idPlat = idPlat;
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
