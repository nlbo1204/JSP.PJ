package implicit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class scopeServlet
 */
@WebServlet("/scopeServlet")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageScope = request.getParameter("pageScope");
		String requestScope = request.getParameter("requestScope");
		String sessionScope = request.getParameter("sessionScope");
		String applicationScope = request.getParameter("applicationScope");
		
		// 속성설정 : setAttribute(String name, Object value);
		// 속성 획득 : getAttribute(String name);
		
		// page 영역 : servlet에 해당 scope 없음
		// request 영역 
		request.setAttribute("requestScope", requestScope + "_attribute");
		
		//session 영역
		HttpSession session = request.getSession();
		session.setAttribute("sessionScope", sessionScope + "_attribute");
		
		//appication 영역 
		ServletContext context = getServletContext();
		context.setAttribute("applicationScope", applicationScope + "_attribute");
		
		//forward로 위임 (scopeReulst.jsp)
		request.getRequestDispatcher("/implicit/scopeResult.jsp").forward(request, response);
	}

}
