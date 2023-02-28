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
			<h4>List des étudiants</h4>
			<a class="btn btn-add" href="${pageContext.request.contextPath}/students/create" >Ajouter</a>
	  		<table id="test-table">
	    		<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Prénom & Nom</th>
						<th scope="col">Date de naissance</th>
						<th scope="col">Téléphone</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${students}" varStatus="currPos">
						<tr>
							<th scope="row">${currPos.index + 1}</th>
							<td>${student.firstName} ${student.lastName}</td>
							<td>${student.birthdate}</td>
							<td>${student.phone}</td>
	                        <td class="text-center">
								<a class="btn btn-update" href="${pageContext.request.contextPath}/students/update?id=${student.id}" type="button" class="btn btn-secondary btn-sm">Editer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
	  		</table>
	  	</div>
	</body>
</html>