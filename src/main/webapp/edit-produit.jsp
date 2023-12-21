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
			<div class="card-header bg-primary text-white">Edit produit</div>
			<div class="card-body">
				
				<form action="UpdateProduit.do" method="Post">
				
					<div class="form-group">
						<label class="control-label">ID</label> 
						<input class="form-control" type="text" name="id" value="${produit.id}">
					</div>
				
					<div class="form-group">
						<label class="control-label">Designation</label> 
						<input class="form-control" type="text" name="designation" value="${produit.designation}">
					</div>
					<div class="form-group">
						<label class="control-label">Prix</label> 
						<input class="form-control" type="text" name="prix" value="${produit.prix}">
					</div>
					<div class="form-group">
						<label class="control-label">Quantité</label> 
						<input class="form-control" type="text" name="quantite" value="${produit.quantite}">
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary" type="submit">Edit</button>
					</div>
					
					
				</form>
			
			</div>

		</div>

	</div>

</body>
</html>