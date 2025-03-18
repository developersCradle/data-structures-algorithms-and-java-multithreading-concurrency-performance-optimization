import java.util.Iterator;

public class TimeComplexityDemo {

	public static void main(String[] args) {
		double now = System.currentTimeMillis();
		
//		TimeComplexityDemo demo = new TimeComplexityDemo();
//		System.out.println(demo.findSum(9999999));
//		System.out.println(demo.findSumMoreComplex(5));
//		System.out.println("Time taken - " + (System.currentTimeMillis() - now) + " millisecond.");
		
		print(3);		
	}
	
	
	
	public int findSum(int n) {
		return n * (n + 1) / 2;
	}
	
	
	public int findSumMoreComplex(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
//			System.out.println("Looping" + i);
			sum = sum +1;
		}
		return sum;
	}
	
	static public void print(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println("i = " + i + ",j = " + j);
			}
			System.out.println("End of inner loop");
		}
		System.out.println("End of outer loop");
	}
	

}
