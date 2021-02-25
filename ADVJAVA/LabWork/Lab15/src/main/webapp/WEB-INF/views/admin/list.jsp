<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>

<h5 style="color: green">Last Action Status: ${requestScope.message}</h5>
	<table border=1>

		<caption>List all vendors</caption>
		<tr>
			<th>name</th>
			<th>email</th>
			<th>regamount</th>
			<th>regDate</th>
			<th>update</th>
			<th>delete</th>
		</tr>

		<c:forEach var="p" items="${requestScope.vList}">

			<tr>
				<td>${p.name}</td>
				<td>${p.email}</td>
				<td>${p.regAmount}</td>
				<td>${p.regDate}</td>
				<td><a href="<spring:url value='/admin/update?vid=${p.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/admin/delete?vid=${p.id}'/>">Delete</a></td>

				<!-- "<spring:url value='/admin/update?vid=${p.id}'/>" -->
			</tr>
		</c:forEach>
	</table>

	<h5>
		<a href="<spring:url value='/admin/register'/>">Add New Vendor</a>
	</h5>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Logout</a>
	</h5>

</body>
</html>