package kr.or.ddit.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignupServlet() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charse=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String birth = request.getParameter("birth");
		
		pw.write(id);
		pw.write(pass);
		pw.write(addr);
		pw.write(tel);
		pw.write(birth);
	}

}
