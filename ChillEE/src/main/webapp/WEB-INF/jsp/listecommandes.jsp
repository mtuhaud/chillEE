<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Chill EE</title>
	<style><%@ include file="../style/style.css" %></style>
</head>
<body>
	<div id="content">
		<div class="title">Chill EE</div>

		<div id="message"><c:out value="${message}"/></div>
		
		<div id="subtitle">Liste des commandes :</div>
		<table>
			<tr>
				<th>Table n°</th>
				<th>Date et heure</th>
			</tr>
			<c:forEach var="commande"  items="${listeCommandes}" >
			<tr>
				<td><c:out value='${commande.numChambre}'/></td>
				<td><c:out value='${commande.date}'/></td>
			</tr>
			</c:forEach>
		</table>
		<a href="/cocktailee/prepacommande"><button>Commande suivante</button></a><br>
		<a href="/cocktailee/"><button>Retour à l'accueil</button></a>
	</div>
</body>
</html>