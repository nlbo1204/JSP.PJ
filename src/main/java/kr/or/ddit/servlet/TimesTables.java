package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTables extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();	// => consle 창이 아닌 web browser에 띄울때  사용한다.
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset= \"UTF-8\">");
		pw.print("			<title> insert title here </title>");
		pw.print("		<head>");
		pw.print("		<body>");
		pw.print("<table border= 1>");
		int i = 1;
		while(i < 10){
			pw.print("<tr>");
			for(int dan = 2; dan < 10 ; dan ++ ){
				int gugudan = dan * i;
				String result = dan + "*" + i + "=" + gugudan;
				pw.print("<td>" + result + "</td>" );
			}			
			pw.print("</tr>");
			i++;
		}
		pw.print("</table>");
		pw.print("		</body>");
		pw.print("	</html>");

	}

}
