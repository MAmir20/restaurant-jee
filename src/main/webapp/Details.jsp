<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java"  contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" import="tn.enis.model.Commande" import="tn.enis.model.Pizza" import="tn.enis.model.Boisson" import="java.util.Vector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            border: 2px solid blue;
        }
        th, td {
            border: 1px solid black;
            padding: 15px;
            text-align: left;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Item Ordered</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
		<%
		Vector<Commande> cmds = (Vector<Commande>)application.getAttribute("commandes");
		int id_cmd = Integer.parseInt((String)request.getParameter("item"));
		int total = 0;
		if(cmds != null){
			for (Commande cmd : cmds) { 
				if(cmd.getId() == id_cmd) {
					total = cmd.getPrix_total();
					Vector<Pizza> pizzas = cmd.getPizzas();
					if(pizzas != null){
						for (Pizza pizza : pizzas){
		%>
        <tr>
            <td><%= pizza.getNom() %></td>
            <td><%= pizza.getQte() %></td>
            <td><%= pizza.getPrix()*pizza.getQte() %></td>
        </tr>
        <% 				}
					}
					Vector<Boisson> boissons = cmd.getBoissons();
					if(boissons != null){
						for (Boisson boisson : boissons) { %>
        <tr>
            <td><%= boisson.getNom() %></td>
            <td><%= boisson.getQte() %></td>
            <td><%= boisson.getPrix()*boisson.getQte() %></td>
        </tr>
        <% 				}
					}
					break;
				}
			}
		}
		%>
    </table>
    <p>Total a payer: <%= total %></p>
    <a href="Commandes.jsp"><button type="button">Retourner</button></a>
</body>
</html>
