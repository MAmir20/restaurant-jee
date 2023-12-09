package tn.enis.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.enis.model.Boisson;
import tn.enis.model.Commande;
import tn.enis.model.Pizza;

/**
 * Servlet implementation class Commander
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Commander() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession(false);
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		Vector<Pizza> pizzas = (Vector<Pizza>) session.getAttribute("pizzas");
		int total = 0;
		if (pizzas != null) {
			for (Pizza pizza : pizzas) {
				total += pizza.getQte() * pizza.getPrix();
			}
		}
		Vector<Boisson> boissons = (Vector<Boisson>) session.getAttribute("boissons");
		if (boissons != null) {

			for (Boisson boisson : boissons) {
				total += boisson.getQte() * boisson.getPrix();
			}
		}
		Vector<Commande> cmds = null;
		Commande cmd = new Commande(nom, prenom, adresse, pizzas, boissons, total);
		cmds = (Vector<Commande>) application.getAttribute("commandes");
		if (cmds == null) {
			cmds = new Vector<Commande>();
		}
		cmds.add(cmd);
		application.setAttribute("commandes", cmds);
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/MenuPizza.html");
	}

}
