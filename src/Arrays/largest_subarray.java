package Arrays;

/**
 * @author Rishabh
 */
import java.util.Scanner;

public class largest_subarray {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			int[] array = takeinput();
			findSubArray(array);
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

	// taken all zeroes as -1 so that sum comes out to be zero..
	public static int findSubArray(int arr[]) {
		int n = arr.length;
		int sum = 0;
		int maxsize = -1;
		int startindex = 0;
		int endindex = 0;

		for (int i = 0; i < n - 1; i++) {
			sum = (arr[i] == 0) ? -1 : 1;

			// Consider all subarrays starting from i

			for (int j = i + 1; j < n; j++) {
				if (arr[j] == 0) {
					sum += -1;
				} else {
					sum += 1;
				}
				// If this is a 0 sum subarray, then compare it with max size subarray

				if (sum == 0 && maxsize < j - i + 1) {
					maxsize = j - i + 1;
					startindex = i;
					endindex = j;
				}
			}
		}

		if (maxsize == -1)
			System.out.println("None");
		else
			System.out.println(startindex + " to " + endindex);

		return maxsize;
	}

}