<%@ page contentType="text/html; charset=EUC-KR" isELIgnored="false" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>${exception.getMessage()}</h2>
<ul>
	<c:forEach items="${exception.getStackTrace()}" var="stack">
		<li>${stack.toString}</li>
	</c:forEach>
</ul>
</body>
</html>