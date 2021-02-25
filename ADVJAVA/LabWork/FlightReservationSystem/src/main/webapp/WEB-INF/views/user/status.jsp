<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STATUS</title>
<style>
body {
	 background-color: #3b2e8f;
	 font-family: 'Open Sans', sans-serif;
}

h1 {
	font-size: 34px;
	margin: 0;
	font-weight: 600;
}

h3 {
	font-size: 16px;
	margin: 0;
	font-weight: 700;
}

h4 {
	font-size: 11px;
	margin: 0;
	font-weight: 400;
}

h5 {
	font-size: 11px;
	font-weight: 600;
	margin: 25px 0 25px 0;
}

h6 {
	font-weight: 600;
	margin: 0;
}

.container {
	margin: 0 auto;
    width: 300px;
    background-color: white;
    position: relative;
    overflow: hidden;
}

.first {
	margin-top: 70px;
	height: 300px;
}

.second {
	margin-top: 0px;
	height: 120px;
	border-top: 1px solid #3b2e8f;
}

.top {
	top: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #3b2e8f;
}
.bottom {
	bottom: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #3b2e8f;
}
.left {
	left: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #3b2e8f;
}
.right {
	right: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #3b2e8f;
}

.spacer {
	padding: 25px 20px 20px 20px;
}

.spacer2 {
	padding: 15px 20px 20px 20px;
}

.spacer > img {
	width: 57px;
	float: left;
	padding-right: 30px;
}

.name-flight {
	float: left;
}

.name-flight > h3 {
	text-transform: uppercase;
	color: #4b4091;
}

.name-flight > h4 {
	color: #7c7c7c;
	margin-top: -5px;
}

h4 > span {
	font-size: 15px;
	font-weight: 700;
	color: #d9118d;
}

.destination {
	margin-top: 70px;
}

.from {
	float: left;
	width: 33%;
	color: #5d6474;
}

.center {
	float: left;
	width: 33%;

}

i {
	color: #5d6474;
	padding-top: 15px;
	padding-left: 25%;
}

.to {
	float: left;
	width: 33%;
	color: #5d6474;
}

.from > span {
	font-size: 12px;
	font-weight: 600;
}

.to > span {
	font-size: 12px;
	font-weight: 600;
}

.left-side {
	float: left;
	width: 33%;
}

h5 > span {
	font-weight: 700;
	font-size: 15px;
	color: #da0d8d;
}


.right-side {
	float: right;
	width: 33%;
}

h5 {
	color: #5e6675;
}

.spacer2 > h3 {
	color: #4b4091;
	text-transform: uppercase;
	text-align: center;
}

.flight-gate {
	float: left;
	width: 66%;
	margin-top: 15px;
}

.flight-gate > h5 {
	margin: 0 0 5px 0;
}

.text-barcode > img {
	float: left;
	width: 33%;
	margin-top: 5px;
}
</style>
</head>

<body>
<html>
<head>
	<title>WizzAir ticket</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300' rel='stylesheet' type='text/css'>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
	<div class="container first">
		<div class="top left corner"></div>
	    <div class="top right corner"></div>
	    <div class="bottom left corner"></div>
	    <div class="bottom right corner"></div>
	    <div class="spacer">
	    	
	    	<div class="name-flight">
	    		<h3>${sessionScope.aid.name}</h3>
	    		<h4>Flight: <span>CAS659789</span></h4>
	    	</div>
	    	<div class="destination">
	    		<div class="from">
	    			<h2>${sessionScope.pid.departureCity}</h2>
	    			
	    		</div>
	    		<div class="center">
	    			<i class="material-icons">flight_takeoff</i>
	    		</div>
	    		<div class="to">
	    			<h2>${sessionScope.pid.arrivalCity}</h2>
	    			
	    		</div>
	    	</div>
	    	<div class="details">
	    		<div class="left-side">
		    		<h5>Date:</br><span>${sessionScope.pid.departureDate}</span></h5>
		    		<h5>Gate:</br><span>2B</span></h5>
	    		</div>
	    		<div class="right-side">
		    		<h5>Depart:</br><span>${sessionScope.pid.departureTime}</span></h5>
		    		<h5>Seat:</br><span>4A</span></h5>
	    		</div>
	    	</div>
	    </div>
	</div>
	<div class="container second">
		<div class="top left"></div>
	    <div class="top right"></div>
	    <div class="bottom left"></div>
	    <div class="bottom right"></div>
	    <div class="spacer2">
	    	<h3>${requestScope.passdets.name}</h3>
	    	<div class="text-barcode">
	    		<div class="flight-gate">
	    			<h5>Flight: <span>CAS659789</span></h5>
	    			<h5>Gate: <span>2B</span></h5>
	    		</div>
	    		
	    	</div>
	    </div>
	</div>
	<div>
	<h3 style="color:cyan">Your booking has been confirmed. Check your email for details. Click here to <a style="text-align:centre;color:red" href ="<spring:url value="/bookingConfirmed"/>"> Log Out</a></h3>
</div>
</body>
</html>


</div>

</body>
</html>