package kr.or.ddit.sum;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationLogicTest {

	// 1~10 까지의 합
	
	@Test
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		int start = 1; 
		int end =10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(55, sumResult);
//		if(sumResult == 55){
//			System.out.println("정답");
//		}else{
//			System.out.println("오답");
//		}
	}
	
	//@Test 가 없을 시 인식을 못하고 실행을 안하게 된다. -> @Test 를 사용해야 한다. 
	@Test
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		int start = 3; 
		int end =12;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(75, sumResult);

	}
}
