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
	            <c:when test="${course.id == null}">
	            	<h4>Formulaire de création d'un cours</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/courses/create">
	            </c:when>
	            <c:otherwise>
	            	<h4>Formulaire de modification d'un cours</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/courses/update">
	                <input type="hidden" class="form-control" name="id" value="${course.id}">
	            </c:otherwise>
	        </c:choose>
				<div class="col-12 col-md-6">
					<label for="name" class="text-black">Nom <span class="text-danger">*</span></label>
					<input type="text" class="form-control" id="name" name="name" value="${course.name}" placeholder="Nom">
				</div>
				<div class="col-12 col-md-6">
					<label for="program" class="text-black">Programme <span class="text-danger">*</span></label>
					<input type="text" class="form-control" id="program" name="program" value="${course.program}" placeholder="Programme">
				</div>
				<div>
					<button type="submit" class="btn btn-primary btn-sm btn-block">Enregistrer</button>
				</div>
			</form>
		</div>
	</body>
</html>
