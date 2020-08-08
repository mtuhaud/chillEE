package chill.modele;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Commande {
	
	private int idCommande;
	private Boisson boisson;
	private Plat plat;
	private Dessert dessert;
	private int numChambre;
	private String dateRecap;
	private String date;
	
	public Commande(String idBoisson, String idPlat, String idDessert, String numChambre) throws FormulaireInvalide {
		if (idBoisson.equals("0") && idPlat.equals("0") && idDessert.equals("0")) {
			throw new FormulaireInvalide("Votre commande doit comporter au moins une séléction.");
		}
		try {
			int idB = Integer.valueOf(idBoisson);
			int idP = Integer.valueOf(idPlat);
			int idD = Integer.valueOf(idDessert);
			
			Boisson boissons = new Boisson();
			this.boisson = boissons.getBoisson(idB);
			Plat plats = new Plat();
			this.plat = plats.getPlat(idP);
			Dessert desserts = new Dessert();
			this.dessert = desserts.getDessert(idD);
		} catch(NumberFormatException e) {
			throw new FormulaireInvalide("Séléction non trouvée.");
		}
		
		if (isBlank(numChambre)) {
			throw new FormulaireInvalide("Veuillez renseigner le numéro de chambre.");
		}
		try {
			this.numChambre = Integer.valueOf(numChambre);
			if (this.numChambre <= 0) {
				throw new FormulaireInvalide("Le numéro de chambre être supérieur à 0 !");
			}
		} catch(NumberFormatException e) {
			throw new FormulaireInvalide("Le numéro de chambre n'est pas un nombre !");
		}
		
		setDates();
	}
	
	
	
	public Commande(int idCommande, int numChambre, String date) {
		super();
		this.idCommande = idCommande;
		this.numChambre = numChambre;
		this.date = date;
	}



	private static boolean isBlank(String valeur) {
		return valeur == null || "".equals(valeur);
	}
	
	
	private void setDates() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		int Y = c.get(Calendar.YEAR);
		String M = checkZero(c.get(Calendar.MONTH) + 1);
		String D = checkZero(c.get(Calendar.DAY_OF_MONTH));
		String h = checkZero(c.get(Calendar.HOUR_OF_DAY));
		String m = checkZero(c.get(Calendar.MINUTE));
		String s = checkZero(c.get(Calendar.SECOND));
		this.date = Y + "-" + M + "-" + D;
		this.dateRecap = D + "/" + M + "/" + Y + " " + h + ":" + m + ":" + s;
	}
	
	private static String checkZero(int n) {
		if (n < 10) {
			return "0" + Integer.toString(n);
		}
		else
			return Integer.toString(n);
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Boisson getBoisson() {
		return boisson;
	}

	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

	public int getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}

	public String getDateRecap() {
		return dateRecap;
	}

	public void setDateRecap(String dateRecap) {
		this.dateRecap = dateRecap;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
