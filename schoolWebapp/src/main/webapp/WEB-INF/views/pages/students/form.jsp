<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<c:choose>
	            <c:when test="${student.id == null}">
	            	<h4>Formulaire de création d'étudiant</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/students/create">
	            </c:when>
	            <c:otherwise>
	            	<h4>Formulaire de modification d'étudiant</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/students/update">
	                <input type="hidden" class="form-control" name="id" value="${student.id}">
	            </c:otherwise>
	        </c:choose>
				<div class="col-12 col-md-6">
					<label for="firstName" class="text-black">Prénom <span class="text-danger">*</span></label>
					<input type="text" class="form-control" id="firstName" name="firstName" value="${student.firstName}" placeholder="Prénom">
				</div>
				<div class="col-12 col-md-6">
					<label for="lastName" class="text-black">Nom <span class="text-danger">*</span></label>
					<input type="text" class="form-control" id="lastName" name="lastName" value="${student.lastName}" placeholder="Nom">
				</div>
				<div class="col-12 col-md-6">
					<label for="phone" class="text-black">Numéro de téléphone <span class="text-danger">*</span></label>
					<input type="text" class="form-control" id="phone" name="phone" value="${student.phone}" placeholder="Téléphone">
				</div>
				<div class="col-12 col-md-6">
					<label for="birthdate" class="text-black">Date de naissance <span class="text-danger">*</span></label>
					<input type="date" class="form-control" id="birthdate" name="birthdate" value="${student.birthdate}" placeholder="Date de naissance">
				</div>
				<div>
					<button type="submit" class="btn btn-primary btn-sm btn-block">Enregistrer</button>
				</div>
			</form>
		</div>
	</body>
</html>
