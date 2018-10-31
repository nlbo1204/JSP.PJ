
<!-- jsp 주석 사용 => <%-- --%> 형태로 사용 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach begin="1" end="9" var="dan">
			<tr>
				<!--  jstl에서 표현식은 불가능 -->
			
				<c:forEach begin="2" end="${param.number }" var="gob">
					<td>${dan}* ${gob} = ${gob*dan}</td>
				</c:forEach>
			</tr>
		</c:forEach>
		<%-- <%
		for(int dan =1; dan< 10; dan ++ ){
		%>
			<tr>	
		<% 
			for(int gob=2; gob <10; gob++){
				String result = gob + "*" + dan + "=" + (gob * dan);
		%>
		<td><%= result %></td>
		<%}%>
		</tr>
		<% } %> --%>
	</table>

</body>
</html>