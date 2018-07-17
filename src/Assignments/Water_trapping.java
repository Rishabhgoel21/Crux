package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Water_trapping {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int n = scn.nextInt();
			int[] arr = takeinput(n);

			cases++;
			System.out.println(waterTrapping(arr));
		}
	}

	public static int[] takeinput(int n) {

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static int waterTrapping(int[] arr) {

		int[] left = new int[arr.length];

		left[0] = arr[0];

		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		int[] right = new int[arr.length];

		right[right.length - 1] = arr[arr.length - 1];

		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		int water = 0;
		for (int i = 0; i < arr.length; i++) {
			water += Math.min(left[i], right[i]) - arr[i];
		}
		return water;

	}

}
