<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY PRO SAMPLE</title>
</head>
<body>
	<h4>MY PRO SAMPLE</h4>
	<h3>Login Page</h3>
	says:
	<span class="blue">${msg}</span>
	<c:url var="home" value="/"></c:url>
	<a href="${home}">HOME VIEW</a>
</body>
</html>
