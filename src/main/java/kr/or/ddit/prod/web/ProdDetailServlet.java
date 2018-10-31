package kr.or.ddit.prod.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;

/**
 * Servlet implementation class ProdDetailServlet
 */
@WebServlet("/prodDetail")
public class ProdDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prodId = request.getParameter("prodId");
		ProdServiceInf service = new ProdService();
		ProdDetailVo prodDetailVo = service.prodDetailList(prodId);
		
		request.setAttribute("prodVo", prodDetailVo);
		
		
		request.getRequestDispatcher("/prod/prodDetail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
