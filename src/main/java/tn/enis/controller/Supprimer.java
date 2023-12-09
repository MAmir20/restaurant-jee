package tn.enis.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.enis.model.Boisson;
import tn.enis.model.Pizza;

/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Supprimer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String selectedItem = request.getParameter("item");
		boolean deleted = false;

		Vector<Pizza> pizzas = (Vector<Pizza>) session.getAttribute("pizzas");
		Iterator<Pizza> itPizza = pizzas.iterator();
		if (selectedItem != null && pizzas != null) {
			while (itPizza.hasNext()) {
				Pizza p = itPizza.next();
				if (p.getNom().equals(selectedItem)) {
					if (p.getQte() > 1)
						p.setQte(p.getQte() - 1);
					else
						pizzas.remove(p);
					deleted = true;
					break;
				}
			}
			if (deleted) {
				session.setAttribute("pizzas", pizzas);
				response.sendRedirect(request.getContextPath() + "/Affiche.jsp");
			}
		}
		if (deleted == false) {
			Vector<Boisson> boissons = (Vector<Boisson>) session.getAttribute("boissons");
			Iterator<Boisson> itBoisson = boissons.iterator();
			if (selectedItem != null && boissons != null) {
				while (itBoisson.hasNext()) {
					Boisson b = itBoisson.next();
					if (b.getNom().equals(selectedItem)) {
						if (b.getQte() > 1)
							b.setQte(b.getQte() - 1);
						else
							boissons.remove(b);
						deleted = true;
						break;
					}
				}
				if (deleted) {
					session.setAttribute("boissons", boissons);
					response.sendRedirect(request.getContextPath() + "/Affiche.jsp");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
