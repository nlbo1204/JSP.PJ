package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8081/filterServlet
@WebServlet("/filterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2.filter Servlet doGet");
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//CharacterEncoding 설정을 filter로 이관 (코드 중복제거)
//		request.setCharacterEncoding("utf-8");
		
		// userNm 파라미터 받기
		String userNm = request.getParameter("userNm");
		
		//requset 속성으로 저장
		request.setAttribute("userNm", userNm);
		//request forwoard(/filterServlet/view.jsp)
		request.getRequestDispatcher("/filter/view.jsp").forward(request, response);
		//view.jsp request객체의 userNm이라고 설정한 속성을 화면에 표시
		
			
		
		
	}

}
