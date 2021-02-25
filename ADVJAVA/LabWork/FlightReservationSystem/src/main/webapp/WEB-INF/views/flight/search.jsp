<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<style>
/* Search Form */
* {
	box-sizing: border-box;
}

body {
	font-family: sans-serif;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;;
}

#search-form {
	border: 1px solid red;
	width: 700px;
	position: relative;
}

#header {
	height: 80px;
	background: red;
	display: flex;
	justify-content: flex-start;
	align-items: center;
}

#header h1 {
	color: #FFF;
	margin-left: 20px;
	font-size: 1.3em
}

.flight {
	padding: 20px;
}

.flight input, select {
	color: #6B6A6A;
}

.info-box {
	padding: 10px 0;
	margin-top: 20px;
	flex: 1;
	border-right: 20px solid transparent;
}

.info-box:last-child {
	border-right: none;
}

.info-box label {
	display: block;
	color: #6B6A6A;
	font-size: .9em;
}

.info-box input[type=text], input[type=submit], select {
	border: none;
	outline: none;
	background: #E2E0E0;
	margin-top: 5px;
	width: 100%;
	padding: 5px;
	height: 30px;
	border-radius: 3px;
}

#flight-type {
	display: flex;
	justify-content: flex-start;
	border-bottom: 1px dotted silver;
}

#flight-type .info-box {
	flex: 0 1 25%;
	display: flex;
	align-items: center;
}

#flight-depart {
	display: flex;
	justify-content: space-between;
	border-bottom: 1px dotted silver;
}

#flight-depart .info-box {
	position: relative;
}

#depart-res, #arrive-res {
	position: absolute;
	background: #FFFFFF;
}

#depart-res p, #arrive-res p {
	padding: 7px 2px;
	border-bottom: 1px dotted silver;
}

#depart-res p:hover, #arrive-res p:hover {
	background: #EDEDED;
	cursor: pointer;
}

#flight-dates {
	display: flex;
	border-bottom: 1px dotted silver;
}

#flight-info {
	display: flex;
	border-bottom: 1px dotted silver;
}

#flight-search .info-box {
	display: flex;
	justify-content: center;
}

#flight-search input[type=submit] {
	background: #55AF3A;
	color: white;
	padding: 0;
	height: 50px;
	font-size: 1.2em;
	font-weight: bold;
}

table {
	border: 1px solid #DBDBDB;
	background: #F4F4F4;
}

table td {
	border: 1px solid #DBDBDB;
	padding: 5px;
	text-align: center;
	cursor: pointer;
}

.normal {
	color: rgba(0, 0, 0, .8)
}

.today {
	background: #FF3240;
	color: #FFFFFF;
}

.closed {
	color: #DBDBDB;
	cursor: default;
}

.picked {
	background: green;
}
</style>
</head>
<body>

<h3 style="color:green">Hello ${sessionScope.user.name} !!!</h3>
	<div id="search-form">
		<div id="header">
			<h1>SEARCH FLIGHTS</h1>
		</div>
		<section>
			<div class="flight" id="flightbox">

				<form id="flight-form" method="post">

					<!-- FROM/TO -->
					<div id="flight-depart">
						<div class="info-box">
							<label for="">LEAVING FROM</label> <input type="text"
								id="dep-from" name="departureCity" />
							<div id="depart-res"></div>
						</div>
						<div class="info-box" id="arrive-box">
							<label for="">ARRIVING AT</label> <input type="text" id="dep-to" name="arrivalCity" />
							<div id="arrive-res"></div>
						</div>
					</div>

					<!-- FROM/TO -->
					<div id="flight-dates">
						<div class="info-box">
							<label for="">DEPARTURE DATE</label> <input type="date"
								id="leave-date" name="departureDate"/>
						</div>

					</div>

					<!-- SEARCH BUTTON -->
					<div id="flight-search">
						<div class="info-box">
							<input type="submit" id="search-flight" value="SEARCH" />
						</div>
					</div>

				</form>
			</div>
		</section>

	</div>
	<h3 style="color:red">${requestScope.mssg}</h3>

</body>
</html>