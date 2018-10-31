<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--  지시자 라고 하며 JSP 가 어떻게 이루어져 있는지 간단한 설명 -->
<!-- language => 언어의 종류 
	 contentType =>
	 pageEncoding => 현재 페이지의 인코딩 방식
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% UserVO userVo = (UserVO)session.getAttribute("userVo");%>
	<%= userVo.getName() + "[" + userVo.getAlias() +  "] 님 안녕하세요 " %>

<!--  스크립틀릿 : <% %>자바 코드 작성 -->
<!--  표현식 : <%= %> 출력을 표현 => 변수 등 java 형식으로 된 데이터를 출력할 때 사용 -->
<%
	String msg = "fisrt jsp";
	SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Date date = new Date();
	String formattingDate = simpledate.format(date);
%>
<body>
	hello, world
	<br><%= msg %><%= formattingDate %> <%-- yyyy-mm-dd hh:mi:ss --%>
</body>
</html>

<!-- http://localhost:8081/basic.jsp -->