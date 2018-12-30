package CodeChef.Smackdown;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 16-Oct-2018
 */

public class findingTeammates {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int n = scn.nextInt();
			int[] array = takeinput(n);
			Arrays.sort(array);
			rvereseArray(array, 0, n - 1);

			findMates(array);
			cases++;
		}
	}

	public static void rvereseArray(int arr[], int start, int end) {
		int temp;
		if (start >= end)
			return;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		rvereseArray(arr, start + 1, end - 1);
	}

	public static int[] takeinput(int n) {

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void findMates(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();

		// putting no. of times a no. is there
		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val)) {
				int of = map.get(val);
				int nf = of + 1;
				map.put(val, nf);
			} else {
				map.put(val, 1);
			}
		}

		int ans = 1;

		for (int i = 0; i < arr.length - 1; i = i + 2) {

			map.put(arr[i], map.get(arr[i]) - 1);

			int p = map.get(arr[i + 1]);

			map.put(arr[i + 1], map.get(arr[i + 1]) - 1);

			ans = ans * p;
		}

		System.out.println(ans);
	}
}