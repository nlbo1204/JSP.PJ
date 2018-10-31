<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% UserVO userVo = (UserVO)session.getAttribute("userVo");%>
	main.jsp
	<%= userVo.getName() + "[" + userVo.getAlias() +  "] 님 안녕하세요 " %>
	
	userId : <%= request.getParameter("userId") %>
	password : <%= request.getParameter("password") %>
</body>
</html>