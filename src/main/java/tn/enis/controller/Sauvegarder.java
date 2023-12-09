package tn.enis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.model.Boisson;
import tn.enis.model.Commande;
import tn.enis.model.Pizza;

/**
 * Servlet implementation class Sauvegarder
 */
@WebServlet("/Sauvegarder")
public class Sauvegarder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sauvegarder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("<CENTER><H1>Les commandes :</H1></CENTER>");
		try {
			/* DATABASE CONNECTION */
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/restaurant_jee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection c = DriverManager.getConnection(url, "root", "");
			Statement s = c.createStatement();
			
			ServletContext application = getServletContext();
			Vector<Commande> cmds = (Vector<Commande>) application.getAttribute("commandes");
			String queryAddCmd = "";
			String queryAddCmdPizza = "";
			String queryAddCmdBoisson = "";
			ResultSet rs;
			int id_commande;
			if (cmds != null) {
				for (Commande cmd : cmds) {
					queryAddCmd = "INSERT INTO commandes VALUES (null,'"+cmd.getNom()+"', '"+cmd.getPrenom()+"', '"+cmd.getAdresse()+"', '"+cmd.getPrix_total()+"')";
					out.println("<h2>Commande sauvegarde</h2>");
					s.executeUpdate(queryAddCmd);
					
					rs = s.executeQuery("SELECT id FROM commandes ORDER BY id DESC LIMIT 1");
					rs.next();
					id_commande = rs.getInt("id");
					Vector<Pizza> pizzas = cmd.getPizzas();
					if (pizzas != null) {
						for (Pizza pizza : pizzas) {
							rs = s.executeQuery("SELECT * FROM pizzas WHERE nom = '"+pizza.getNom()+"'");
							if(!rs.next())
								s.executeUpdate("INSERT INTO pizzas VALUES ('"+pizza.getNom()+"', '"+pizza.getPrix()+"')");
							queryAddCmdPizza = "INSERT INTO pizzas_commande VALUES ("+id_commande+", '"+pizza.getNom()+"', '"+pizza.getQte()+"')";
							s.executeUpdate(queryAddCmdPizza);
						}
					}
					Vector<Boisson> boissons = cmd.getBoissons();
					if (boissons != null) {
						for (Boisson boisson : boissons) {
							rs = s.executeQuery("SELECT * FROM boissons WHERE nom = '"+boisson.getNom()+"'");
							if(!rs.next())
								s.executeUpdate("INSERT INTO boissons VALUES ('"+boisson.getNom()+"', '"+boisson.getPrix()+"')");
							queryAddCmdBoisson = "INSERT INTO boissons_commande VALUES ('"+id_commande+"', '"+boisson.getNom()+"', '"+boisson.getQte()+"')";
							s.executeUpdate(queryAddCmdBoisson);
						}
					}					
				}
				application.removeAttribute("commandes");
			}

			String querySelectAll = "SELECT * FROM commandes";

			rs = s.executeQuery(querySelectAll);

			out.println("<TABLE BORDER=1 ALIGN=CENTER>\n " + "<TR>\n"
					+ "<TH>ID</th><TH>Nom</th><TH>Prenom</th><TH>Adresse</th><TH>Prix total</th>");

			while (rs.next()) {
				out.print("<TR><TD>" + rs.getString("id")+"</td>");
				out.print("<TD>" + rs.getString("nom")+"</td>");
				out.print("<TD> " + rs.getString("prenom")+"</td>");
				out.print("<TD> " + rs.getString("adresse")+"</td>");
				out.print("<TD> " + rs.getString("prix_total")+"</td></tr>");

			}
			rs.close();
			s.close();
			c.close();
		} catch (Exception e) {
			out.println(" Erreur : " + e.toString());
		}

		
		out.println("</table></BODY></HTML>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
