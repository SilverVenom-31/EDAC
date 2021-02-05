
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<h5>Hello Friend: <%=new Date() %></h5>
<h5>Page : <%=page %></h5>
<h5>PageContext: <%=pageContext %></h5>
<h5><a href="comments.jsp">Comments</a></h5>
<h5><a href="login.jsp">Testing Scripting Elements</a></h5>
<h5 align="center">SessionID: <%=session.getId() %></h5>
<h5><a href="test.jsp">Test JSP Declaration</a></h5>

</body>
</html>