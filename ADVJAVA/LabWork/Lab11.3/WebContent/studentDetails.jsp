<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>displayStudents</title>
</head>
<body>

	<table border=1>
		<caption>Student Details for course: ${param.cid}</caption>

		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Aadhar Card No.</td>
			<td>Details</td>
			<td>Cancel</td>
		</tr>
		<c:forEach var="c"
			items="${sessionScope.student.sDao.getStudDetByCourse(param.cid)}">
			<tr>
				<td>${c.name}</td>
				<td>${c.email}</td>
				<td>${c.aadharCard.cardNumber}</td>
				<td><a
					href="educationalDetails.jsp?cid=${param.cid}&email=${c.email}">Educational
						Details</a></td>
				<td><a
					href="deleteStudent.jsp?email=${c.email}&cid=${param.cid}">Cancel
						Admission</a></td>
			</tr>
		</c:forEach>

	</table>
	<h5>
		<a href="courseList.jsp">Back</a>
	</h5>
</body>
</html>