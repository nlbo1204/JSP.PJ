<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- login.jsp에서 전송한 파라미터 : userid, password --%>
<%--
	 request parameter 관련 메소드
	1. getParameter(String name);
	2. getParameterValues();
	3. getParameterMap();
	4. getParameterNames();


 --%>
 <%
 	String[] userIdValues = request.getParameterValues("userId");
 
 	Map<String, String[]> requestMap  = request.getParameterMap();
 	
 	//userId, password
 	Enumeration<String> parameterNames = request.getParameterNames();
 	while(parameterNames.hasMoreElements()){
 		String parameterName = parameterNames.nextElement();
 		System.out.println("parameterName = " + parameterName);
 	}
 %>
	request.getParameter("userId") <%= request.getParameter("userId")%>
	request.getParameterValues("userId"):
	<%
		for(String str : userIdValues){
			out.write(str + "<br>");
		}
	%>
	request.getParameter("password") <%= request.getParameter("password")%><br>
	
	<% for(String str : requestMap.get("userId")){ %>
		str : <%= str %>
	<%} %>
	requestMap.get("password") : <%= requestMap.get("password") %>
</body>
</html>