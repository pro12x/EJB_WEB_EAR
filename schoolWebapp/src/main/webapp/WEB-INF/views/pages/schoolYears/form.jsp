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
	            <c:when test="${schoolYear.id == null}">
	            	<h4>Formulaire de création d'une année d'étude</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/school-years/create">
	            </c:when>
	            <c:otherwise>
	            	<h4>Formulaire de modification d'une année d'étude</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/school-years/update">
	                <input type="hidden" class="form-control" name="id" value="${schoolYear.id}">
	            </c:otherwise>
	        </c:choose>
				<div class="col-12 col-md-6">
					<label for="startDate" class="text-black">Année de début <span class="text-danger">*</span></label>
					<input type="number" class="form-control" id="startDate" name="startDate" value="${schoolYear.startDate}" placeholder="2020">
				</div>
				<div class="col-12 col-md-6">
					<label for="endDate" class="text-black">Année de fin <span class="text-danger">*</span></label>
					<input type="number" class="form-control" id="endDate" name="endDate" value="${schoolYear.endDate}" placeholder="2021">
				</div>
				<div>
					<button type="submit" class="btn btn-primary btn-sm btn-block">Enregistrer</button>
				</div>
			</form>
		</div>
	</body>
</html>
