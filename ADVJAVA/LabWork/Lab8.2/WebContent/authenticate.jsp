<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authenticate</title>
</head>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session" />
<jsp:setProperty property="*" name="voter" />
<body>
	<%--session.getAttribute("voter").validateUser() --%>
	<%--<h5>Authentication Status: ${sessionScope.voter.validatUser()}</h5> --%>
	<%--forward the client to next page in SAME request: server pull --%>
	
	<c:redirect url="${sessionScope.voter.validatUser()}.jsp"/>
</body>
</html>