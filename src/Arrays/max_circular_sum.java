package Arrays;

/**
 * @author Rishabh
 */
import java.util.Scanner;

//used kadane algorithm to find maximum sub array sum.
public class max_circular_sum {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int[] array = takeinput();

			System.out.println(circularsum(array));
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

	public static int circularsum(int[] a) {
		// get the maximum sum using subarray max
		int smax = maxsum(a);

		// Now find the maximum sum that includes corner elements.
		int cmax = 0;
		for (int i = 0; i < a.length; i++) {
			cmax += a[i]; // Calculate array-sum
			a[i] = -a[i]; // invert the array (change sign)
		}

		cmax += maxsum(a); // max sum with corner elements will be:
		// arraysum + (max subarray sum of inverted array)

		if (cmax > smax) {
			return cmax;
		} else {
			return smax;
		}
	}

	public static int maxsum(int[] a) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 0; i < a.length; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}
}