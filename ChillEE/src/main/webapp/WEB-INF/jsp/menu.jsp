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
		<h2> Les boissons</h2>
	    <div>
			<c:forEach items="${boissons}" var="boisson">
				<c:if test="${boisson.idBoisson > 0}" >
					<div class="boisson">
				   		<p><c:out value="${boisson.nom}" /></p>
					</div>
				</c:if>
			</c:forEach>
	    </div>
	    
	    <h2> Les plats</h2>
	    <div>
			<c:forEach items="${plats}" var="plat">
				<c:if test="${plat.idPlat > 0}" >
					<div class="plat">
				   		<p><c:out value="${plat.nom}" /></p>
				   		<p><c:out value="${plat.composition}" /></p>
					</div>
				</c:if>
			</c:forEach>
	    </div>
	    
	    <h2> Les desserts</h2>
	    <div>
			<c:forEach items="${desserts}" var="dessert">
				<c:if test="${dessert.idDessert > 0}" >
					<div class="dessert">
				   		<p><c:out value="${dessert.nom}" /></p>
					</div>
				</c:if>
			</c:forEach>
	    </div>
	    <a href="<c:url value="/commande"/>"><button>Passer à la commande</button></a><br>
		<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
  	</div>
  </body>
</html>