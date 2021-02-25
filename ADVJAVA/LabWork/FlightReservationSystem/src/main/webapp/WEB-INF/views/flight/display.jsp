<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>DISPLAY FLIGHTS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Available Flights Scheduled</h2>

		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Airlines</th>
					<th>Departure City</th>
					<th>Arrival City</th>
					<th>Departure Time</th>
					<th>Departure Date</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="air" items="${sessionScope.fList}">
					<c:forEach var="p" items="${air.airlines}">
						<tr>
							<td>${p.name}</td>
							<td>${air.departureCity}</td>
							<td>${air.arrivalCity}</td>
							<td>${air.departureTime}</td>
							<td>${air.departureDate}</td>
							<td>${p.price}</td>
							<td><a
								href="<spring:url value='/flight/passDetails?pid=${air.id}&aid=${p.id}' />">select</a></td>

						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
