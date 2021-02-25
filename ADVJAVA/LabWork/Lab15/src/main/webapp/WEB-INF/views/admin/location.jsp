<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- import for form binding technique our spring supplied form tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location</title>
</head>
<body>
	<!-- Step 2 of form binding using tag lib -->
	<form:form method="post" modelAttribute="location">
		<table style="background-color: cyan; margin: auto;">
		
			<tr>
				<td>Enter city: </td>
				<td><form:input path="city" /></td>
				<td><form:errors path="city" /></td>
			</tr>

			<tr>
				<td>Enter state: </td>
				<td><form:input path="state" /></td>
				<td><form:errors path="state" /></td>
			</tr>


			<tr>
				<td>Enter country </td>
				<td><form:input path="country" /></td>
				<td><form:errors path="country" /></td>
			</tr>

			
			<tr>
				<td><input type="submit" value="Register New Vendor" /></td>
			</tr>
		</table>
	</form:form>
	

</body>
</html>