package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PageEtcTest {


	/**  
	* Method   : test 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 : 페이지 내비게이션 계산 테스트  
	*/
	@Test
	public void pageNaviCaltest() {
		/***Given***/
		int totalUserCount = 105;
		int pageSize = 10;

		/***When***/
		int nviSize = (int)Math.ceil((double)totalUserCount / pageSize);
		/***Then***/
		assertEquals(11, nviSize);

	}

}
