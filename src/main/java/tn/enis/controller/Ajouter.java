package tn.enis.controller;

import java.io.IOException;
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
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ajouter() {
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
		HttpSession session = request.getSession(true);
		String[] selectedPizzas = request.getParameterValues("pizzas");
		if (request.getParameterValues("PizzaButton")!= null && selectedPizzas == null) {
			response.sendRedirect(request.getContextPath() + "/MenuPizza.html");
		}
		Vector<Pizza> pizzas = (Vector<Pizza>) session.getAttribute("pizzas");
		if (pizzas == null) {
			pizzas = new Vector<>();
			session.setAttribute("pizzas", pizzas);
		}
		if (selectedPizzas != null) {
			for (String pizzaNom : selectedPizzas) {
				boolean pizzaExistante = false;
				for (Pizza pizza : pizzas) {
					if (pizza.getNom().equals(pizzaNom)) {
						pizza.setQte(pizza.getQte() + 1);
						pizzaExistante = true;
						break;
					}
				}

				if (!pizzaExistante) {
					Pizza nouvellePizza = new Pizza(pizzaNom, 10, 1);
					pizzas.add(nouvellePizza);
				}
			}
			session.setAttribute("pizzas", pizzas);
			response.sendRedirect(request.getContextPath() + "/MenuPizza.html");
		}
		String[] selectedBoissons = request.getParameterValues("boissons");
		Vector<Boisson> boissons = (Vector<Boisson>) session.getAttribute("boissons");
		if (request.getParameterValues("BoissonButton")!= null && selectedBoissons == null) {
			response.sendRedirect(request.getContextPath() + "/MenuBoisson.html");
		}
		if (boissons == null) {
			boissons = new Vector<>();
			session.setAttribute("boissons", boissons);
		}

		if (selectedBoissons != null) {
			for (String boissonNom : selectedBoissons) {
				boolean boissonExistante = false;
				for (Boisson boisson : boissons) {
					if (boisson.getNom().equals(boissonNom)) {
						boisson.setQte(boisson.getQte() + 1);
						boissonExistante = true;
						break;
					}
				}

				if (!boissonExistante) {
					Boisson nouvelBoisson = new Boisson(boissonNom, 10, 1);
					boissons.add(nouvelBoisson);
				}
			}
			session.setAttribute("boissons", boissons);
			response.sendRedirect(request.getContextPath() + "/MenuBoisson.html");
		}
	}

}
