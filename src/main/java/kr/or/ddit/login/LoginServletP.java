package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServletP extends HttpServlet {
	// service - request.getMethod() : "POST" , "GET" -> doPost , doGet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.write("LoginServlet doPost");
		
		pw.print("<!DOCTYPE html>");
		pw.print("	<html>");
		pw.print("		<head>");
		pw.print("			<meta charset= \"UTF-8\">");
		pw.print("			<title> insert title here </title>");
		pw.print("		<head>");
		pw.print("		<body>");
		String[] userIds = req.getParameterValues("userId");
		
		for(String userId : userIds){
			pw.println("userId : " + userId + "<br>");
			pw.println("password : " + req.getParameter("password") + "<br>");
		}
		pw.print("		</body>");
		pw.print("		</html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
