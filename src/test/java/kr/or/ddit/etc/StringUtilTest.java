package kr.or.ddit.etc;

import static org.junit.Assert.*;
import kr.or.ddit.util.StringUtil;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given***/
		String contentDisposition= "form-data; name=\"profile\"; filename=\"brown.png\"";

		/***When***/
		//logic
		String fileName = "";
		String[] strArray = contentDisposition.split("; ");
		
//		for(String str : strArray){
//			if(str.contains("filename")){
//				System.out.println(str);
//			}
//		}
		
		for(String str : strArray){
			if(str.indexOf("filename") >= 0 ){
				//filename="brown.png"
				System.out.println(str.length());
				fileName = str.substring(10, str.lastIndexOf("\""));
			
			}
		}

		/***Then***/
		assertEquals("brown.png", fileName);

	}
	
	
	//쿠키 문자열 파싱 테스트
	@Test
	public void getCookieTest(){
		/***Given***/
		String cookieString = "remember=Y; userId=brown; etc=test";

		/***When***/
		String cookieValue = StringUtil.getCookie(cookieString, "remember");
		String cookieValue2 = StringUtil.getCookie(cookieString, "userId");
		/***Then***/
		assertEquals("Y", cookieValue);
		assertEquals("brown", cookieValue2);
	}

}
