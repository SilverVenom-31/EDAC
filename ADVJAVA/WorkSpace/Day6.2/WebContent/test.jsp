<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	int counter;//private scope

	int incCount() {
		return ++counter;
	}

	//override lifecyle method of jsp
	public void jspInit() {
		System.out.println("in jsp init: " + Thread.currentThread());

	}%>
<body>


	<%
		System.out.println("in jsp in service: " + Thread.currentThread());
	%>
	<h5>
		Counter:
		<%=incCount()%></h5>

</body>
<%!public void jspDestroy() {
		System.out.println("in jsp destroy: " + Thread.currentThread());
	}%>
</html>