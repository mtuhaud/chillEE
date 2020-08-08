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
		<div id="subtitle">Récapitulatif de la commande :</div>
		<ul>
			<li><i>Numéro de chambre :</i> <fmt:formatNumber value="${commande.numChambre}"/></li>
			<li><i>Boisson :</i> <c:out value="${commande.boisson.nom}"/></li>
			<li><i>Plat :</i> <c:out value="${commande.plat.nom}"/></li>
			<li><i>Dessert :</i> <c:out value="${commande.dessert.nom}"/></li>
			<li><i>Date et heure :</i> <c:out value="${commande.dateRecap}"/></li>
		</ul>
		<a href="/chillee/"><button>Retour à l'accueil</button></a>
		
		<a href="RecapServlet?idcommande=${commande.idCommande}"><button>Delete</button></a>
		
<%-- 		<div>
			<p><a href="${pageContext.request.contextPath}/episode?action=supprimer&idsaison=${param['idsaison']}&idepisode=${episodeRequested.id}" id="confirmation">Supprimer l'épisode</a></p>
		</div> --%>
		
<%-- 		<form action="${pageContext.request.contextPath}/RecapServlet" method="post">
    		<button type="submit" name="button" value="button1">Supprimer commande </button>
		</form> --%>
	</div>
</body>
</html>