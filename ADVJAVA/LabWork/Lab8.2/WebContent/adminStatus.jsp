<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<h5>Admin Login successfull</h5>
	<h5>Hello ${sessionScope.voter.userDetails.name}</h5>

	<h5>
		<a href="candidateRegister.jsp">New Candidate Registration</a>
	</h5>

	<h5>${sessionScope.candidate.msg}</h5>

	<h3>Top 2 Candidates:</h3>
	<table border=1>
		<tr>
			<th>Candidate Name</th>
			<th>Candidate Party</th>
			<th>Candidate Votes</th>
		</tr>

		<c:forEach var="p"
			items="${sessionScope.candidate.canDao.top2Analysis()}">
			<tr>
				<td>${p.name}</td>
				<td>${p.party}</td>
				<td>${p.votes}</td>
			</tr>

		</c:forEach>
	</table>

	<h3>Votes Analysis:</h3>
	<table border=1>
		<tr>

			<th>Party Name</th>
			<th>Party Votes</th>
		</tr>

		<c:forEach var="c"
			items="${sessionScope.candidate.canDao.partyWiseAnalysis()}">
			<tr>

				<td>${c.key}</td>
				<td>${c.value}</td>
			</tr>

		</c:forEach>
	</table>


	<h5>
		<a href="logout.jsp">Logout</a>
	</h5>
</body>
</html>