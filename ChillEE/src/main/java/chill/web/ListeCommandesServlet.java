package chill.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import chill.dao.CommandeDAO;
import chill.dao.DessertDAO;
import chill.modele.Commande;
import chill.modele.Dessert;

@WebServlet(urlPatterns = "/listecommandes", loadOnStartup = 0)
public class ListeCommandesServlet extends HttpServlet {

	private static final String VUE_LISTE = "/WEB-INF/jsp/listecommandes.jsp";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Commande> listeCommandes = new CommandeDAO().selectCommande();
		req.setAttribute("listeCommandes", listeCommandes);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_LISTE);
		rd.forward(req, resp);
	}
}
