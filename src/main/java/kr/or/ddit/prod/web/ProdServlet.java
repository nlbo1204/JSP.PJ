package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVO;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet("/prodServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProdServiceInf service = new ProdService();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		pageVO.setPageSize(pageSize);
		
		Map<String, Object> prodMap= service.prodAllList(pageVO);
		List<ProdAllVo> prodAllIst = (List<ProdAllVo>) prodMap.get("prodList");
		int pageCnt = (int)prodMap.get("pageCnt");
		
		request.setAttribute("prodList", prodAllIst);
		request.setAttribute("pageCnt", pageCnt);
		
		request.getRequestDispatcher("/prod/prodList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
