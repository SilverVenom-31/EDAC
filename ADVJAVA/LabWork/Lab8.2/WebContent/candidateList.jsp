<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate List</title>
</head>

<body>
	<h5>Hello ${sessionScope.voter.userDetails.name}</h5>
	<form action="status.jsp" method="post">
		<table>
			<caption>Candidates:</caption>
			<c:forEach var="p" items="${sessionScope.candidate.fetchCandidates()}">
				<tr>
					<td><input type="radio" name="can" value="${p.id}"></td>
					<td>${p.name}</td>
					<td>${p.party}</td>
				</tr>

			</c:forEach>

		</table>
		<input type="submit" value="VOTE" />
	</form>
</body>
</html>