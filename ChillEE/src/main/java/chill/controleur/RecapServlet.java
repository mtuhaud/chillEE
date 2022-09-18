package chill.controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chill.dao.CommandeDAO;
import chill.modele.Commande;


@WebServlet("/RecapServlet")
public class RecapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String idC = request.getParameter("idcommande");
		int idcommande = Integer.valueOf(idC);
		new CommandeDAO().deleteCommande(idcommande);
		getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
