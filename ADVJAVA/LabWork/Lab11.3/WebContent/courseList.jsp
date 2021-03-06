<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerList</title>
</head>
<jsp:useBean id="course" class="beans.CourseBean" scope="session" />
<jsp:useBean id="student" class="beans.StudentBean" scope="session" />
<body>

	<form action="studentDetails.jsp" method="post">

		<table>
			<caption><h5>Available Courses: </h5></caption>
			<c:forEach var="p"
				items="${sessionScope.course.cDao.fetchAllCourseNames()}">

				<tr>
					<td><input type="radio" name="cid" value="${p}"></td>
					<td>${p}</td>
				</tr>

			</c:forEach>

		</table>

		<input type="submit" value="Choose Course" />


	</form>


</body>
</html>