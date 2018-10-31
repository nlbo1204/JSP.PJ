package kr.or.ddit.mul;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("param1"));
		int end = Integer.parseInt(request.getParameter("param2"));
		
		Integer mulResult = start;
		
		for(int mul = start ; mul < end+1; mul++ ){
			mulResult = mulResult*mul;
			System.out.println(mulResult);
		}
		
		System.out.println(start + " 부터 " + end + "까지의 곱은 " + mulResult);
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", mulResult);
		
//		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
		
		
	}

}
