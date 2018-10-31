<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" type="java.lang.String" required="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
code = ${code}

	<%// DB작업에 필요한 객체변수 선언
	
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null; // 쿼리문이 select일때만 필요하다.

			try {
				// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "ydy"; // 등록된 사용자 ID
				String pass = "java"; // 등록된 패스워드

				conn = DriverManager.getConnection(url, user, pass);

				stmt = conn.createStatement();

				String sql = "select prod_id, prod_name from prod where prod_lgu = '"+code+"'";
						 // 실행할 SQL명령

				rs = stmt.executeQuery(sql); // sql명령이 select일 경우
%>
			<select>
<% 
				while (rs.next()) {%>
							
				
					<option value="<%=rs.getString("prod_id")%>"><%=rs.getString("prod_name") %></option>
				
	<%}%>
			</select>
	<%

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				// 6. 사용했던 자원을 반납한다.
				if (rs != null)
					try {
						rs.close();
					} catch (Exception e2) {
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (Exception e2) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (Exception e2) {
					}
			}%>
		
	