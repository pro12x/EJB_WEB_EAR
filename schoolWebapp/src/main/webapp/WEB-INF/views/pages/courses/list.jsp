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
			<a class="btn btn-add" href="${pageContext.request.contextPath}/courses/create" >Ajouter</a>
	  		<table id="test-table">
	    		<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Libellé</th>
						<th scope="col">Programme</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${courses}" varStatus="currPos">
						<tr>
							<th scope="row">${currPos.index + 1}</th>
							<td>${course.name}</td>
							<td>${course.program}</td>
	                        <td class="text-center">
								<a class="btn btn-update" href="${pageContext.request.contextPath}/courses/update?id=${course.id}" type="button" class="btn btn-secondary btn-sm">Editer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
	  		</table>
	  	</div>
	</body>
</html>