package DP;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 13-Jul-2018
 */

/*
 * You are provided a sequence of number. All numbers of that sequence is in
 * increasing order (including 1) and whose only prime factors are 2, 3 or 5
 * (except 1). You need to find the nth number of that sequence.
 */
// sample input -- 7.......ans = 8...
// sequence -- 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ....
public class UglyNumbers {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		System.out.println(uglyNos(n));

	}

	public static long uglyNos(int n) {

		long[] arr = new long[n];
		arr[0] = 1;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		// next multiple of 2, 3, 5
		long nm2 = 2;
		long nm3 = 3;
		long nm5 = 5;
		long res = 1;

		for (int i = 1; i < n; i++) {

			res = Math.min(nm2, Math.min(nm3, nm5));

			arr[i] = res;

			if (res == nm2) {
				i2 = i2 + 1;
				nm2 = arr[i2] * 2;
			}

			if (res == nm3) {
				i3 = i3 + 1;
				nm3 = arr[i3] * 3;
			}

			if (res == nm5) {
				i5 = i5 + 1;
				nm5 = arr[i5] * 5;
			}

		}

		return res;

		// to print sequence
		// for (int val : arr) {
		// System.out.print(val + " ");
		// }
		// System.out.println();
		// System.out.println(arr[n-1]);
	}

}
