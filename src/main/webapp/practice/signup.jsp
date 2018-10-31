<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="signupParameter.jsp" method="post">
	<table>
		
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="아이디를 입력하세요"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pass" value="비밀번호를 입력하세요"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="addr" value="주소를 입력하세요"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="tel" value="전화번호를 입력하세요"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="birth" value="생년월일을 입력하세요"></td>
		</tr>
		<tr>
			<td><input type="submit" name="id" value="회원가입"></td>
		</tr>
	</table>
</form>
</body>
</html>