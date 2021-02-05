<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Registration</title>
</head>
<body>
	<h5>Registration Form:</h5>
	<form action="checkRegistration.jsp" method="post">
		<table>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Party:</td>
				<td><input type="text" name="party" /></td>
			</tr>
			<tr>
				<td>Date Of Birth(yyyy-mm-dd):</td>
				<td><input type="text" name="doBDate"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>

	</form>
	
	<h5> ${sessionScope.candidate.msg}</h5>
	
</body>
</html>