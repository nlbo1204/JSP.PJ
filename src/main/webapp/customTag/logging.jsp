<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h2>logging tag</h2>
	<tags:logginTag></tags:logginTag>
	<br>
	<c:forEach begin="1" end="10" var="i" >
		${i}
	</c:forEach>
	<br>
	<tags:logginTag></tags:logginTag>
 --%>
 	<h2>color logging tag</h2>
<%--	<tags:colorLogging length="10" />
	<c:forEach begin="1" end="10" var="i" >
		${i}
	</c:forEach> --%>
<%-- 	<tags:colorLogging color="red"/> --%>
<tags:code code="P102"/>
	

	
</body>
</html>