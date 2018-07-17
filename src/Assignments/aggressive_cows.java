package Assignments;

/**
 * @author Rishabh
 */
import java.util.*;

public class aggressive_cows {

	static Scanner scn = new Scanner(System.in);

	public static void main(String args[]) {

		int n = scn.nextInt();

		int cows = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {

			arr[i] = scn.nextInt();

		}

		Arrays.sort(arr);

		System.out.println(maxd(arr, cows));

	}

	public static int maxd(int[] arr, int cows) {

		// max distance between stalls
		int max = arr[arr.length - 1] - arr[0];

		int min = 0;

		int res = 0;

		while (min <= max) {

			int mid = (max + min) / 2;

			res = mid;

			boolean ans = placingCow(mid, arr, cows);

			if (ans == true) {

				min = mid + 1;

			} else if (ans == false) {

				max = mid - 1;

			}

		}

		return res;

	}

	private static boolean placingCow(int mid, int[] arr, int cows) {

		boolean check = false;

		int count = 1;

		int i = 0;

		int j = 0;

		while (count < cows && i < arr.length) {

			int res = arr[i] - arr[j];

			if (res >= mid) {

				check = true;

				count++;

				j = i;

			} else {

				check = false;

			}

			i++;

		}

		return check;

	}

}
