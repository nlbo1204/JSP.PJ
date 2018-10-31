<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	

</style>
</head>

<body>
	
	<canvas id="myCanvas" width="200" height="200"
		style="border: 1px solid #000000"></canvas>
	<script type="text/javascript">
		var canvas = document.getElementById("myCanvas");
		var ctx = canvas.getContext("2d");
		//ctx.fillStyle = "#ff0000";
		//ctx.fillRect(0,0,150,75);
		ctx.beginPath();
		//원의 중심 x좌표, 원의 중심 Y좌표 , 반지름
		ctx.arc(100, 100, 100, 0, 2 * Math.PI);
		ctx.stroke();

		ctx.font = "60px Arial";
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

				int randomNum = (int) (Math.random() * 19 + 1);
				String sql = "select * from jspstudent where no ='" + randomNum
						+ "'"; // 실행할 SQL명령

				rs = stmt.executeQuery(sql); // sql명령이 select일 경우

				if (rs.next()) {%>
				
				ctx.fillText("<%=rs.getString("name")%>", 10, 115);
	<%}

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
		
	</script>

</body>
</html>