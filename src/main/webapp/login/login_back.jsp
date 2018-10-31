<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%-- 
		method 방식 
		브라우저 주소줄에 입력할 경우 : get 
		form 태그의 method 속성 : get/post
	--%>
	
	<form  action="/dditLogin" method="post">
	사용자 아이디 :  <input type="text" name ="userId" value="brown"> <br>
	<!--  사용자 아이디 : <input type="text" name ="userId" value="샐리"> <br> -->
	<span>사용자 비밀번호 : </span> <input type="password" name ="password" value ="1234"> <br>
	<input type="submit" value = "로그인">
	</form>
</body>
</html>