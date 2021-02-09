<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status</title>
</head>
<body>
	<c:set var="voted" scope="session"
		value="${sessionScope.voter.userDetails.status}" />

	<c:choose>

		<c:when test="${voted == 1}">
			<h5>Hello ${sessionScope.voter.userDetails.name}, you have
				already voted</h5>
		</c:when>

		<c:when test="${voted == 0}">
			<h5>Hello ${sessionScope.voter.userDetails.name}, you have voted
				successfully</h5>
			<h5>${sessionScope.voter.voterDao.updateVotingStatus(sessionScope.voter.userDetails.id)}</h5>
			<h5>${sessionScope.candidate.canDao.incrementVotes(param.can)}</h5>
		</c:when>

		<c:otherwise>
			<h5>Try Again!!!</h5>
		</c:otherwise>
	</c:choose>
	
	<h5>
		<a href="logout.jsp">LogOut</a>
	</h5>

</body>
</html>