<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList</title>
</head>
<jsp:useBean id="product" class="beans.ProductBean" scope="application" />
<body>
	<!--  get Products() -->
	<h5>
		<%--Product List: ${applicationScope.product.products}</h5> --%>

		<table>
			<caption>Product List</caption>

			<tr>
				<th>Product ID:</th>
				<th>Product Name:</th>
				<th>Product Price:</th>
			</tr>

			<c:forEach var="p" items="${applicationScope.product.products}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.price}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>