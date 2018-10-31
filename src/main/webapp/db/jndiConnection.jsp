<%@page import="java.sql.Connection"%>
<%@page import="org.apache.tomcat.jdbc.pool.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//jndi connection
		Context initialContext = new InitialContext();
		// 어떠한 자원에 대해서 리턴을 해줌
		
		//java:comp/env는 정해져 있고 이후에 사용되는 경로는 톰캣에 등록되있는 리소스를 보내달라 요청
		 DataSource ds =  (DataSource)initialContext.lookup("java:comp/env/jdbc/oracleDB"); //대소문자 구분하니깐 맞춰서 쓰세요
		 
	
		 Connection conn = null;
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 30; i++) {
				conn = ds.getConnection();
				out.println("scheme : "+conn.getSchema()+"<br>");
				conn.close();
			}
			
			long endTime = System.currentTimeMillis();
			out.println("startTime + endTime : " + (endTime - startTime));
		
	%>
</body>
</html>