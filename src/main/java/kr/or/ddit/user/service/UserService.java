package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class UserService implements UserServiceInf{
	UserDao userDao = new UserDao();

	@Override
	public List<UserVO> selectUserAll() {
		return userDao.selectUserAll();
	}

	@Override
	public UserVO selectUser(String userid) {
		return userDao.selectUser(userid);
	}

	@Override
	public UserVO selectUser(UserVO userVo) {
		return userDao.selectUser(userVo);
	}

	/**  
	* Method   : selectUserPageList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param page
	* @return  
	* Method 설명 : 사용자 페이징 조회 
	*/
	public Map<String, Object> selectUserPageList(PageVO page) {
		
		//페이지에 해당하는 유저 리스트(1~10건사이)
		List<UserVO> userList = userDao.selectUserPageList(page);
		
		//페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = userDao.getUserCnt();
		
		//결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCount", (int)Math.ceil((double)totalUserCnt/page.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVO userVo) {
		// TODO Auto-generated method stub
		return userDao.insertUser(userVo);
	}

	@Override
	public int updateUser(UserVO userVo) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userVo);
	}


	
	

}
