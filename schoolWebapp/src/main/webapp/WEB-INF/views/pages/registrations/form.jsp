<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
	            <c:when test="${registration.id == null}">
	            	<h4>Formulaire de création d'une inscription</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/registrations/create">
	            </c:when>
	            <c:otherwise>
	            	<h4>Formulaire de modification d'une inscription</h4>
	                <form method="POST" action="${pageContext.request.contextPath}/registrations/update">
	                <input type="hidden" class="form-control" name="id" value="${registration.id}">
	            </c:otherwise>
	        </c:choose>
				<div class="col-12 col-md-6">
					<label for="studentId" class="text-black">Étudiant <span class="text-danger">*</span></label>
					<select id="studentId" name="studentId">
						<c:forEach var="student" items="${students}">
							<c:choose>
	                            <c:when test="${registration != null && registration.student.id == student.id}">
	                                <option value="${student.id}" selected>${student.firstName}${student.lastName}</option>
	                            </c:when>
	                            <c:otherwise>
	                                <option value="${student.id}">${student.firstName}${student.lastName}</option>
	                            </c:otherwise>
	                        </c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="col-12 col-md-6">
					<label for="studentId" class="text-black">Année d'étude <span class="text-danger">*</span></label>
					<select id="schoolYearId" name="schoolYearId">
						<c:forEach var="schoolYear" items="${schoolYears}">
							<c:choose>
	                            <c:when test="${registration != null && registration.schoolYear.id == schoolYear.id}">
	                                <option value="${schoolYear.id}" selected>${schoolYear.startDate} - ${schoolYear.endDate}</option>
	                            </c:when>
	                            <c:otherwise>
	                                <option value="${schoolYear.id}">${schoolYear.startDate} - ${schoolYear.endDate}</option>
	                            </c:otherwise>
	                        </c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="col-12 col-md-6">
					<label for="courseIds" class="text-black">Cours <span class="text-danger">*</span></label>
					<select id="courseIds" name="courseIds" multiple>
						<c:forEach var="course" items="${courses}">
							<c:choose>
	                            <c:when test="${registration != null && fn:contains(registration.courses, course)}">
	                                <option value="${course.id}" selected>${course.name}</option>
	                            </c:when>
	                            <c:otherwise>
	                                <option value="${course.id}">${course.name}</option>
	                            </c:otherwise>
	                        </c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="col-12 col-md-6">
					<label for="details" class="text-black">Détails <span class="text-danger">*</span></label>
					<textarea rows="5" class="form-control" id="details" name="details">${registration.details}</textarea>
				</div>
				<div>
					<button type="submit" class="btn btn-primary btn-sm btn-block">Enregistrer</button>
				</div>
			</form>
		</div>
	</body>
</html>

