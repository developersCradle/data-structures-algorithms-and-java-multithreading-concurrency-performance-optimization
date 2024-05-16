
public class TimeComplexityDemo {

	public static void main(String[] args) {
		double now = System.currentTimeMillis();
		
		TimeComplexityDemo demo = new TimeComplexityDemo();
		System.out.println(demo.findSumMoreComplex(9999999));
		
		System.out.println("Time taken - " + (System.currentTimeMillis() - now) + " millisecond.");
		
	}
	
	
	
	public int findSum(int n) {
		return n * (n + 1) / 2;
	}
	
	public int findSumMoreComplex(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum +1;
		}
		return sum;
	}
	

}
