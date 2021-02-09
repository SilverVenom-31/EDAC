<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>

	<h5>User Details: ${sessionScope.usr.toString()}</h5>

	<h5>
		<a href="logout.jsp">LogMe Out</a>
	</h5>
</body>
</html>