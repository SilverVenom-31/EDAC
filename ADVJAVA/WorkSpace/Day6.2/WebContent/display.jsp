<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center">
		SessionID:
		<%=session.getId()%></h5>
	<h5>Email:</h5>
	<%
		out.print(request.getParameter("em"));
	%>
	<h5>Password:</h5>
	<%
		out.print(request.getParameter("pass"));
	%>
	<hr>
	<h5><%=request.getParameter("em")%></h5>
	<h5><%=request.getParameter("pass")%></h5>
	<hr>
	<h5>Display email and pass using EL syntax</h5>
	<%--WC: out.print(request.getParameter("em"); --%>
	<h5>Email: ${param.em}</h5>
	<h5>Password: ${param.pass}</h5>
	<h5>param map: ${param}</h5>

</body>
</html>