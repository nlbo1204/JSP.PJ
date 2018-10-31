package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

/** * UserServiceInf.java *  * @author 1003yd * @version 1.0 * @see *  * <pre> * << 개정이력(Modification Information) >> *    * 수정자 수정내용 * ------ ----------------------- * 1003yd 최초 생성 * * </pre> */
public interface UserServiceInf {
	
	public List<UserVO> selectUserAll();
	
	public UserVO selectUser(String userid);
	
	public UserVO selectUser(UserVO userVo);
	
	/**  
	* Method   : selectUserPageList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param page
	* @return  
	* Method 설명 :  사용자 페이징 조회
	*/
	public Map<String, Object> selectUserPageList(PageVO page);

	public int insertUser(UserVO userVo);
	
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
