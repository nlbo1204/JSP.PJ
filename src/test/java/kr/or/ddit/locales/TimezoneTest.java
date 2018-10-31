package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.After;
import org.junit.Test;

public class TimezoneTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void timezoneTest() {
		/***Given***/
		

		/***When***/
		String[] timezones = TimeZone.getAvailableIDs();
		
		for(String str : timezones){
			System.out.println(str);
		}
		
		/***Then***/

	}

}
