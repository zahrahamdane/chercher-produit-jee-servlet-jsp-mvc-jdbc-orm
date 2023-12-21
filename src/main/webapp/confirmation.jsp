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
			<div class="card-header bg-primary text-white">Confirmation</div>
			<div class="card-body">
				
				<div class="form-group">
					<label>ID : </label>
					<label>${produit.id }</label>
				</div>
				<div class="form-group">
					<label>Designation : </label>
					<label>${produit.designation }</label>
				</div>
				<div class="form-group">
					<label>Prix : </label>
					<label>${produit.prix }</label>
				</div>
				<div class="form-group">
					<label>Quantite : </label>
					<label>${produit.quantite }</label>
				</div>
			
			</div>

		</div>

	</div>

</body>
</html>