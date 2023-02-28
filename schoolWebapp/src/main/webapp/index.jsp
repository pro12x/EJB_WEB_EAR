<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil</title>
	</head>
	<body>
		<h4>Liste des crud</h4>
		<ul>
			<li><a href="${pageContext.request.contextPath}/students">Gestion des étudiants</a></li>
			<li><a href="${pageContext.request.contextPath}/courses">Gestion des cours</a></li>
			<li><a href="${pageContext.request.contextPath}/school-years">Gestion des années d'étude</a></li>
			<li><a href="${pageContext.request.contextPath}/registrations">Gestion des inscriptions</a></li>
		</ul>
	</body>
</html>
