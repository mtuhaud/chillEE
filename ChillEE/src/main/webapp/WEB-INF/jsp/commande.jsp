<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Cocktail EE</title>
    <style><%@ include file="../style/style.css" %></style>
  </head>
  <body>
	<div id="content">
		<div class="title">Chill EE</div>
	    
	    <div id="message"><c:out value="${message}"/></div>
	  	
		<form method="post" accept-charset="utf-8">
<%-- 			<div>
				<select id="boisson" name="boisson">
					<option value="0">-- Boisson --</option>
					<c:forEach var="boisson" items="${listeBoissons}">
						<option value="${boisson.idBoisson}" ${param['boisson'] == boisson.idBoisson ? "selected" : ""}>
							<c:out value="${boisson.nom}"/>
						</option>
					</c:forEach>
				</select>
			</div> --%>
			<div>
				<select id="idboisson" name="idboisson">
					<option value="0">-- Boisson --</option>
					<c:forEach var="boisson" items="${boissons}">
					<option value="${boisson.idBoisson}">
						<c:out value="${boisson.nom}"/>
					</option>
					</c:forEach>
				</select>
			</div>
<%-- 			<div>
				<select id="plat" name="plat">
					<option value="0">-- Plat --</option>
					<c:forEach var="plat" items="${listePlats}">
						<option value="${plat.idPlat}" ${param['plat'] == plat.idPlat ? "selected" : ""}>
							<c:out value="${plat.nom}"/>
						</option>
					</c:forEach>
				</select>
			</div> --%>
			<div>
				<select id="idplat" name="idplat">
					<option value="0">-- Plat --</option>
					<c:forEach var="plat" items="${plats}">
					<option value="${plat.idPlat}">
						<c:out value="${plat.nom}"/>
					</option>
					</c:forEach>
				</select>
			</div>
<%-- 			<div>
				<select id="dessert" name="dessert">
					<option value="0">-- Dessert --</option>
					<c:forEach var="dessert" items="${listeDesserts}">
						<option value="${dessert.idDessert}" ${param['dessert'] == dessert.idDessert ? "selected" : ""}>
							<c:out value="${dessert.nom}"/>
						</option>
					</c:forEach>
				</select>
			</div> --%>
			<div>
				<select id="iddessert" name="iddessert">
					<option value="0">-- Dessert --</option>
					<c:forEach var="dessert" items="${desserts}">
					<option value="${dessert.idDessert}">
						<c:out value="${dessert.nom}"/>
					</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input id="chambre" name="chambre" type="text" placeholder="Chambre n°" value="<c:out value="${param['chambre']}" />"> 	 
			</div>
			<button type="submit">Ajouter Commande</button><br>
		</form>
		<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
  	</div>
  </body>
</html>