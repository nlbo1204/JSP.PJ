package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class TempDaoTest {

	// 테스트 메소드 명명 규칙(회사 마다 다름)
	// 운영코드 메소드 이름 + Test
	// getTemp + Test : getTempTest
	@Test
	public void getTempTest() {
		/*** Given : 주어진 상황 ***/
		TempDao tempDao = new TempDao();

		/*** When : 어떤 동작 수행(메소드 호출) ***/
		Map<String, Object> map = tempDao.getTemp();
		System.out.println("map : " + map);

		// select 'X' as result from dual
		// result : X

		/*** Then : 결과가 어떠해야하는지 정의 ***/
		// 반드시 키값 대소문자 구별해야함
		// db에서 alias에 ""안에 넣지 않고 그냥 쓰게 되면 대문자로 인식하게 된다.
		// 소문자로 인식을 하고 싶을 경우에는 ""안에 alias를 사용하면된다.
		// => select 'X' as "result" from dual
		assertEquals("X", map.get("result"));
		map.get("result");
		
		
	}

}
