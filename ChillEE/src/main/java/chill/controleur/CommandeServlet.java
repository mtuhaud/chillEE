package chill.controleur;

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
import chill.modele.Commande;
import chill.modele.Dessert;
import chill.modele.FormulaireInvalide;
import chill.modele.Plat;


@WebServlet(urlPatterns = "/commande", loadOnStartup = 0)
public class CommandeServlet extends HttpServlet {

	private static final String VUE_COMMANDE = "/WEB-INF/jsp/commande.jsp";
	private static final String VUE_RECAP = "/WEB-INF/jsp/recapcommande.jsp";


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Boisson> boisson = new BoissonDAO().selectBoisson();
		List<Plat> plat = new PlatDAO().selectPlat();
		List<Dessert> dessert = new DessertDAO().selectDessert();
		req.setAttribute("boissons", boisson);
		req.setAttribute("desserts", dessert);
		req.setAttribute("plats", plat);
		getServletContext().getRequestDispatcher(VUE_COMMANDE).forward(req, resp);		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String idBoisson = req.getParameter("idboisson");
			String idPlat = req.getParameter("idplat");
			String idDessert = req.getParameter("iddessert");
			String numChambre = req.getParameter("chambre");
			Commande commande = new Commande(idBoisson, idPlat, idDessert, numChambre);
			new CommandeDAO().insertCommande(commande);
			req.setAttribute("commande", commande);
			getServletContext().getRequestDispatcher(VUE_RECAP).forward(req, resp);
		} catch (FormulaireInvalide e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_COMMANDE).forward(req, resp);
		}
	}

//	private ListeCommandes getListeCommandes() {
//		return (ListeCommandes) getServletContext().getAttribute("objetListeCommandes");
//	}
	
//	private CocktailService getCocktailService() {
//		return (CocktailService) getServletContext().getAttribute("cocktailService");
//	}
}
