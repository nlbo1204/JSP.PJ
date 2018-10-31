package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdListDao;
import kr.or.ddit.prod.dao.ProdListDaoInf;
import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.util.model.PageVO;

public class ProdService implements ProdServiceInf {
	private ProdListDaoInf prodDao = new ProdListDao();
	
	@Override
	public Map<String, Object> prodAllList(PageVO page) {
		// TODO Auto-generated method stub
		List<ProdAllVo> prodAllList = prodDao.prodAllList(page);
		
		int totalCnt = prodDao.prodCnt();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("prodList", prodAllList);
		result.put("pageCnt", (int)Math.ceil((double)totalCnt/page.getPageSize()));
		
		return result; 
	}

	@Override
	public ProdDetailVo prodDetailList(String prodId) {
		// TODO Auto-generated method stub
		return prodDao.prodDetailList(prodId);
	}

}
