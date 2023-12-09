<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="tn.enis.model.Commande"
	import="java.util.Vector"%>
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
			<th>Nom</th>
			<th>Prenom</th>
			<th>Adresse</th>
			<th>Prix total</th>
		</tr>
		<% Vector<Commande> cmds = (Vector<Commande>)application.getAttribute("commandes");
		if(cmds != null){
		for (Commande cmd : cmds) { %>
		<tr>
			<td><%= cmd.getNom() %></td>
			<td><%= cmd.getPrenom() %></td>
			<td><%= cmd.getAdresse() %></td>
			<td><a href="Details.jsp?item=<%= cmd.getId() %>"><%=  cmd.getPrix_total() %>
					TND</a></td>
		</tr>
		<% } } %>
	</table>
	<% if(cmds != null) { %>
	<a href="Sauvegarder"><button type="button">Sauvegarder</button></a>
	<% } %>
</body>
</html>
