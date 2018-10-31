package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		String[] userIdValues = req.getParameterValues("userId");
		Map<String, String[]> requestMap = req.getParameterMap();
		String pass  = req.getParameter("password");
		
		for(String getId : requestMap.get("userId")){
			pw.print("Id : " +getId);
			pw.print("<br>");
		}
		
		pw.print("password : " + pass);

		

		
		
	}
	

}
