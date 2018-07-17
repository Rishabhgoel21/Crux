package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class max_subarray_sum {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int[] array = takeinput();

			System.out.println(maxsum(array));
			cases++;
		}
	}

	public static int[] takeinput() {

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static int maxsum(int[] a) {
		int max_so_far = a[0];
	    int curr_max = a[0];
	 
	    for (int i = 1; i < a.length; i++)
	    {
	           curr_max = Math.max(a[i], curr_max+a[i]);
	        max_so_far = Math.max(max_so_far, curr_max);
	    }
	    return max_so_far;
	}
}