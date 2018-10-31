package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface UserDaoInf {

	public List<UserVO> selectUserAll();

	public UserVO selectUser(String userid);

	public UserVO selectUser(UserVO userVo);
	
	/**  
	* Method   : getUserCnt 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 : 사용자 전체 건수 조회 
	*/
	int getUserCnt();
	
	/**  
	* Method   : insertUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param userVo
	* @return  
	* Method 설명 : 사용자 등록  
	*/
	public int insertUser(UserVO userVo);
	
	
	/**  
	* Method   : deleteUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param userId
	* @return  
	* Method 설명 :  사용자 삭제
	*/
	public int deleteUser(String userId);
	
	/**  
	* Method   : updateUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param userVo
	* @return  
	* Method 설명 :  사용자 정보 수정
	*/
	public int updateUser(UserVO userVo);

	
	
	

}
