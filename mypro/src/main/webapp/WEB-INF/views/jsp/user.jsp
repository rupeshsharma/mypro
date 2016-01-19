<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY PRO SAMPLE</title>
</head>
<body>
	<h4>MY PRO SAMPLE</h4>
	<h3>USER Page</h3>
	says:
	<span class="blue">${msg}</span>
	<c:url var="logout" value="/logout"></c:url>
	<a href="${logout}">LOG OUT</a>
	<h1>Username :${user.username}</h1>
	<h1>Email :${user.email}</h1>
	<c:url value="/user/create" var="createUserURL" />
	<a href="${createUserURL}">Create new USER</a>
</body>
</html>
