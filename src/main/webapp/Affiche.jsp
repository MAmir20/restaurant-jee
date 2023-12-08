<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java"  contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" import="tn.enis.model.Pizza" import="tn.enis.model.Boisson" import="java.util.Vector" %>
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
            <th>Action</th>
        </tr>
		<% int total = 0;
		Vector<Pizza> pizzas = (Vector<Pizza>)session.getAttribute("pizzas");
		for (Pizza pizza : pizzas) { total+=pizza.getPrix()*pizza.getQte(); %>
        <tr>
            <td><%= pizza.getNom() %></td>
            <td><%= pizza.getQte() %></td>
            <td><%= pizza.getPrix()*pizza.getQte() %></td>
            <td><a href="Supprimer.java">Supprimer</a></td>
        </tr>
        <% }
        Vector<Boisson> boissons = (Vector<Boisson>)session.getAttribute("boissons");
		for (Boisson boisson : boissons) { total+=boisson.getPrix()*boisson.getQte(); %>
        <tr>
            <td><%= boisson.getNom() %></td>
            <td><%= boisson.getQte() %></td>
            <td><%= boisson.getPrix()*boisson.getQte() %></td>
            <td><a href="Supprimer.java">Supprimer</a></td>
        </tr>
        <% } %>
    </table>
    <p>Total a payer: <%= total %></p>
    <button type="button">Valider</button>
    <button type="button">Afficher le menu</button>
</body>
</html>
