package kr.or.ddit.sum;

public class CalculationLogic {

	public static void main(String[] args) {
		CalculationLogic logic = new CalculationLogic();
		int start = 1; 
		int end =10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		if(sumResult == 55){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
	}
	
	public Integer sumBetweenTwoNumbers(int start, int end) {
		int min =Math.min(start, end);
		int max  = Math.max(end, start);
		
		Integer result = 0;
		for(int sum = start; sum < end+1 ; sum++){
			result += sum;
		}
		return result;
	}
	
}
