<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Registration</title>
</head>
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />
<jsp:setProperty property="*" name="candidate" />

<body>

<jsp:forward page="${sessionScope.candidate.validateCandidate()}.jsp"/>

</body>
</html>