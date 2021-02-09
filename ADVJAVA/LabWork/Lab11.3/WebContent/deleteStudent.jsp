<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student</title>
</head>
<body>


${sessionScope.student.sDao.cancelAdmission(param.cid,param.email)}


	<h5>
		<a href="studentDetails.jsp?cid=${param.cid}">Back</a>
	</h5>
</body>
</html>