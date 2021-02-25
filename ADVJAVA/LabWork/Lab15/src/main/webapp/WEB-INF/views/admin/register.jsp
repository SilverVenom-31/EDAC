<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- import for form binding technique our spring supplied form tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<body>
	<!-- Step 2 of form binding using tag lib -->
	<form:form method="post" modelAttribute="vendors">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>

			<tr>
				<td>Enter User Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>


			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>

			<tr>
				<td>Registration Amount</td>
				<td><form:input type="number" path="regAmount" /></td>
				<td><form:errors path="regAmount" /></td>
			</tr>

			<tr>
				<td>Registration Date</td>
				<td><form:input type="date" path="regDate" /></td>

			</tr>

			<tr>
				<td>Payment Mode:</td>
				<td><form:radiobuttons path="paymentDetails.mode"
						items="${requestScope.paymentModes}" /></td>
			</tr>


			<tr>
				<td>Payment Amount</td>
				<td><form:input type="number" path="paymentDetails.amount" /></td>
				<td><form:errors path="paymentDetails.amount" /></td>
			</tr>


			<tr>
				<td>Payment Date</td>
				<td><form:input type="date" path="paymentDetails.paymentDate" /></td>

			</tr>

			<tr>
				<td><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>