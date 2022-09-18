package chill.controleur;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chill.dao.BoissonDAO;
import chill.dao.DessertDAO;
import chill.dao.PlatDAO;
import chill.modele.Boisson;
import chill.modele.Dessert;
import chill.modele.Plat;


// @WebServlet("/menu")
@WebServlet(urlPatterns = "/menu", loadOnStartup = 0)
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_MENU = "/WEB-INF/jsp/menu.jsp";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Boisson> boisson = new BoissonDAO().selectBoisson();
		List<Plat> plat = new PlatDAO().selectPlat();
		List<Dessert> dessert = new DessertDAO().selectDessert();
		req.setAttribute("boissons", boisson);
		req.setAttribute("desserts", dessert);
		req.setAttribute("plats", plat);
		getServletContext().getRequestDispatcher(VUE_MENU).forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
