<%@page import="pojos.UserDets"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate</title>
</head>
<%!String userName;
	String password;

	public void jspInit() {
		userName = "abc";
		password = "1234";
	}%>
<body>

	<%
		if (userName.equals(request.getParameter("em")) && password.equals(request.getParameter("pass"))) {

		UserDets user = new UserDets(userName, password);
		request.setAttribute("usr", user);

		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
		rd.forward(request, response);

	} else {
	%>
	<h5>
		<a href="login.jsp">Invalid Login, Retry</a>
	</h5>
	<%
		}
	%>
</body>
</html>