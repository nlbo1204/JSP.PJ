<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	request.setAttribute("number", 100000); 
	request.setAttribute("numberPercent", 1); 
%> --%>
<!-- scope를 지정하지 않을 시 가장 낮은 pageContext로 자동 인식이 된다. -->
<c:set var="number" value="100000" scope="request"/>
<c:set var="numberPercent" value="1" scope="request"/>

<h2>기본 locale</h2>
<fmt:formatNumber value="${number}"/>
<fmt:formatNumber value="${number}" type="currency"/> <br>
<fmt:formatNumber value="${numberPercent}" type="percent"/> <br>

<h2>영문 locale</h2>
<fmt:setLocale value="en-US"/>
<fmt:formatNumber value="${number}"/><br>
<fmt:formatNumber value="${number}" type="currency"/> <br>
<fmt:formatNumber value="${numberPercent}" type="percent"/> <br>

<h2>독어 locale</h2>
<fmt:setLocale value="de-DE"/>
<fmt:formatNumber value="${number}"/><br>
<fmt:formatNumber value="${number}" type="currency"/> <br>
<fmt:formatNumber value="${numberPercent}" type="percent"/> <br>

<fmt:setLocale value="ko"/>
<c:set var="parseNumber" value="1,000.99"/>
<fmt:parseNumber value="${parseNumber}"/> 


</body>
</html>