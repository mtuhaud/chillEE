package chill.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chill.dao.BoissonDAO;
import chill.dao.CommandeDAO;
import chill.dao.DessertDAO;
import chill.dao.PlatDAO;
import chill.modele.Boisson;
import chill.modele.Cocktail;
import chill.modele.CocktailService;
import chill.modele.Commande;
import chill.modele.Dessert;
import chill.modele.FormulaireInvalide;
import chill.modele.ListeCommandes;
import chill.modele.Plat;


@WebServlet(urlPatterns = "/commande", loadOnStartup = 0)
public class CommandeServlet extends HttpServlet {

	private static final String VUE_COMMANDE = "/WEB-INF/jsp/commande.jsp";
	private static final String VUE_RECAP = "/WEB-INF/jsp/recapcommande.jsp";

	@Override
	public void init() throws ServletException {
		
//		Boisson boisson = new Boisson();
//		getServletContext().setAttribute("boisson", boisson);
//		getServletContext().setAttribute("listeBoissons", boisson.getListeBoissons());
//		
//		Plat plat = new Plat();
//		getServletContext().setAttribute("plat", plat);
//		getServletContext().setAttribute("listePlats", plat.getListePlats());
//		
//		Dessert dessert = new Dessert();
//		getServletContext().setAttribute("dessert", dessert);
//		getServletContext().setAttribute("listeDesserts", dessert.getListeDesserts());

		ListeCommandes listeCommandes = new ListeCommandes();
		getServletContext().setAttribute("objetListeCommandes", listeCommandes);
		getServletContext().setAttribute("listeCommandes", listeCommandes.getListe());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_COMMANDE);
//		rd.forward(req, resp);
		List<Boisson> boisson = new BoissonDAO().selectBoisson();
		List<Plat> plat = new PlatDAO().selectPlat();
		List<Dessert> dessert = new DessertDAO().selectDessert();
		req.setAttribute("boissons", boisson);
		req.setAttribute("desserts", dessert);
		req.setAttribute("plats", plat);
		getServletContext().getRequestDispatcher(VUE_COMMANDE).forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		CocktailService cocktailService = getCocktailService();
		ListeCommandes listecommandes = getListeCommandes();
		req.setCharacterEncoding("utf-8");
		try {
//			String idBoisson = req.getParameter("boisson");
			String idBoisson = req.getParameter("idboisson");
			String idPlat = req.getParameter("idplat");
			String idDessert = req.getParameter("iddessert");
			String numChambre = req.getParameter("chambre");
			Commande commande = new Commande(idBoisson, idPlat, idDessert, numChambre);
			System.out.println(commande);
			listecommandes.addCommande(commande);
			new CommandeDAO().insertCommande(commande);
			req.setAttribute("commande", commande);
			getServletContext().getRequestDispatcher(VUE_RECAP).forward(req, resp);
		} catch (FormulaireInvalide e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_COMMANDE).forward(req, resp);
		}
	}

	private ListeCommandes getListeCommandes() {
		return (ListeCommandes) getServletContext().getAttribute("objetListeCommandes");
	}
	
//	private CocktailService getCocktailService() {
//		return (CocktailService) getServletContext().getAttribute("cocktailService");
//	}
}
