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
			<h4>List des cours</h4>
			<a class="btn btn-add" href="${pageContext.request.contextPath}/registrations/create" >Ajouter</a>
	  		<table id="test-table">
	    		<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Étudiant</th>
						<th scope="col">Année d'étude</th>
						<th scope="col">Cours</th>
						<th scope="col">Details</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="registration" items="${registrations}" varStatus="currPos">
						<tr>
							<th scope="row">${currPos.index + 1}</th>
							<td>${registration.student.firstName} - ${registration.student.lastName}</td>
							<td>${registration.schoolYear.startDate} - ${registration.schoolYear.endDate}</td>
							<td>
								<c:forEach var="course" items="${registration.courses}">
									<span>${course.name}</span>
								</c:forEach>
							</td>
							<td>${registration.details}</td>
	                        <td class="text-center">
								<a class="btn btn-update" href="${pageContext.request.contextPath}/registrations/update?id=${registration.id}" type="button" class="btn btn-secondary btn-sm">Editer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
	  		</table>
	  	</div>
	</body>
</html>