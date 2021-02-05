<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<h5><a href="adminLogout.jsp">Logout</a></h5>
</body>
</html>