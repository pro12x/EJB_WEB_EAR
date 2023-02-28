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
			<h4>List des années d'études</h4>
			<a class="btn btn-add" href="${pageContext.request.contextPath}/school-years/create" >Ajouter</a>
	  		<table id="test-table">
	    		<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Période</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="schoolYear" items="${schoolYears}" varStatus="currPos">
						<tr>
							<th scope="row">${currPos.index + 1}</th>
							<td>${schoolYear.startDate} - ${schoolYear.endDate}</td>
	                        <td class="text-center">
								<a class="btn btn-update" href="${pageContext.request.contextPath}/school-years/update?id=${schoolYear.id}" type="button" class="btn btn-secondary btn-sm">Editer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
	  		</table>
	  	</div>
	</body>
</html>