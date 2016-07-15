<%@ page contentType="text/html; charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="/member/login" method="post">
		아이디 : <input type="text" name="userid" /><br> 패스워드 : <input
			type="password" name="userpw"><br>
		<button type="submit">로그인</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>