package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기존 view 요청 get : localhost:8081/jsp/sumInput.jsp
		//변경 view 요청 get : localhost:8081/sumCalculation
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end =  Integer.parseInt(request.getParameter("end"));

		CalculationLogic logic = new CalculationLogic();
		Integer result = logic.sumBetweenTwoNumbers(start, end);
		
		 
		
		
		System.out.println(start + " 부터  " + end + "까지의 합은 " + result);
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", result);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
