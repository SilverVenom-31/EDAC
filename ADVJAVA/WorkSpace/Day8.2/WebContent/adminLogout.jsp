<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Logout</title>
</head>
<body>
${sessionScope.voter.voterDao.cleanUp()}
${sessionScope.candidate.canDao.cleanUp()}
	 ${pageContext.session.invalidate()}
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>


	
