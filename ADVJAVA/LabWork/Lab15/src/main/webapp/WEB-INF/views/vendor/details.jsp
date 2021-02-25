<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
<h5 style="color: green">${sessionScope.msg}</h5>
	<h5>User Details: ${sessionScope.user_dets}</h5>

	
	<h5>
		<a href="<spring:url value='/user/logout' />">Logout</a>
	</h5>
</body>
</html>