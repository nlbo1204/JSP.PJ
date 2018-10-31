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
	내장객체(implicit) 
	request, reponse, session, application ,out, pageContext
--%>

<%-- 
	out, requset, response, session, page, application 내장객체 비교 
		application은 servletContext를 사용하여 비교 함 (이름이 달라 기억해)	
		
		기본객체(내장객체)를 pageContext를 통해서도 알 수 있다. 라는 걸 알기 위한 실습
 --%>

	out.equals(pageContext.getOut()) : <%= out.equals(pageContext.getOut()) %>											<br>
	response.equals(pageContext.getResponse()) : <%= response.equals(pageContext.getResponse())  %>                     <br>
	session.equals(pageContext.getSession()) : <%= session.equals(pageContext.getSession())  %>                         <br>
	page.equals(pageContext.getPage()) : <%= page.equals(pageContext.getPage())  %>                                     <br>
	application.equals(pageContext.getServletContext()) : <%= application.equals(pageContext.getServletContext())  %>   <br>
	
</body>
</html>