<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- el scope 확인 예제 --%>
	<%--
		page(pageContext) : jsp 페이지에서만 유효한 속성
		request : 요청이 끝날 때 까지 유효한 속성
		session : session이 만료 되기 전까지 유효한 속성
				   sesion이 만료되는 시점 : server 종료시, tomcat 설정에 따라
				                      session.invalidate()/ 사용자가 server timeout 시간안에 요청을 하지 않을 때 
		application : was에 하나 존재 (서버 종료 전까지는 유효)
	 --%>
	 
	 <%--범위가 작은데서 부터 검사를 시작한다. --%>
	 <%
	 	pageContext.setAttribute("attribute","pageContextAttribute");
	 	request.setAttribute("attribute","requestAttribute");
	 	session.setAttribute("attribute","sessionAttribute");
	 	application.setAttribute("attribute","applicationAttribute");
	 %>
	 
	 pageContext : <%=pageContext.getAttribute("attribute") %>
	 request : <%=request.getAttribute("attribute") %>
	 session : <%=session.getAttribute("attribute")%>
	 application : <%=application.getAttribute("attribute") %>
	 
	 <h2>el</h2>
	 <%-- 
	 	같은 속성명일 경우 범위가 작은것 먼저 출력한다(검색 시 범위가 작은 것 부터 검색) 
		따라서 가급적 scope 간의 같은 속성명을 사용하지 않는게 좋다. 	
	--%>
	 el attribute : ${applicationScope.attribute} <br>
	 
	 
</body>
</html>