<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Educational Details</title>
</head>
<body>

	<table border=1>

		<tr>
			<td>email</td>
			<td>type</td>
			<td>year</td>
			<td>grade</td>
		</tr>

		<c:forEach var="d"
			items="${sessionScope.student.sDao.getEducationalQuals(param.email)}">


			<tr>
				<td>${param.email}</td>
				<td>${d.type}</td>
				<td>${d.year}</td>
				<td>${d.grade}</td>
			</tr>

		</c:forEach>
	</table>

	<h5>
		<a href="studentDetails.jsp?cid=${param.cid}">Back</a>
	</h5>
</body>
</html>