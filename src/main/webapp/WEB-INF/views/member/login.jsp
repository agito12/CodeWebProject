<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<spring:hasBindErrors name="memberVO" />
	<form:errors name="memberVO" />

	<spring:hasBindErrors name="login" />
	<form:errors name="login" />

	<jsp:include page="../include/header.jsp" />
	<form action="/member/login" method="post">
		<table>
			<tr>
				<td>아이디 : <input type="text" name="userid" /> <span
					style="color: red"> <form:errors path="memberVO.userid" />
				</span>
				</td>
			</tr>
			<tr>
				<td>패스워드 : <input type="password" name="userpw"> <span
					style="color: red"> <form:errors path="memberVO.userpw" />
				</span>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit">로그인</button>
					<button type="reset">취소</button>
					<div style="color: red">
						<form:errors path="memberVO" />
					</div>
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>