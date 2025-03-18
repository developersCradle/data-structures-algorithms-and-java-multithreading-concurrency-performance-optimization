import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtil {

	   public void printArray(int[] arr) {
	      int n = arr.length;
	      for (int i = 0; i < n; i++) {
	         System.out.print(arr[i] + " ");
	      }
	      System.out.println();
	   }

	   
	   public static void main(String[] args) {
		      ArrayUtil arrUtil = new ArrayUtil();
		      arrUtil.arrayDemo();
		   }
	   
	   public void arrayDemo() {
		      int[] arr = { 1, 3, 6, 8, 2, 4, 7 };
		      System.out.println(arr);
		   }

}
