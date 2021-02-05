<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errHandler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%!String msg="hello";//instance var %>

<body>

<%int count=100; //method local var
pageContext.setAttribute("attr1", 1234);
%>

<%@ include file="inc.jsp" %>
</body>
</html>
