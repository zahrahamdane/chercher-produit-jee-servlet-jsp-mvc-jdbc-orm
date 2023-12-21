<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue Produits</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<br>
	<div class="container col-md-10 offset-md-1">
		<div class="card">
			<div class="card-header bg-primary text-white">Recherche des produits</div>
			<div class="card-body">
				
				<form action="chercher.do" method="Get">

					<div class="form-group">
						<label class="control-label">Mot Clé</label> 
						<input class="form-control" type="text" name="motCle" value="${model.motCle}">
					</div>
					<button class="btn btn-primary" type="submit">Chercher</button>
				</form>
				<br>
			
				<table class="table">
					<tr>
						<th>ID</th><th>DESIGNATION</th><th>PRIX</th><th>QUANTITE</th>
					</tr>
					<c:forEach items="${model.produitsByMC}" var="produit">
					
						<tr>
							<td>${produit.id}</td>
							<td>${produit.designation}</td>
							<td>${produit.prix}</td>
							<td>${produit.quantite}</td>
							<td><a onclick="return confirm('Etes vous sûre ?')" href="supprimer.do?id=${produit.id}">Supprimer</a></td>
							<td><a href="edit.do?id=${produit.id}">Edit</a></td>
						</tr>
					</c:forEach>
					
				</table>
				
			</div>

		</div>

	</div>

</body>
</html>