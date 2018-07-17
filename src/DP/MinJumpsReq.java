package DP;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 15-Jul-2018
 */


// If an element is 0, then cannot move through that element.
// Example:
// Input: array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output: 3 (1-> 3 -> 8 ->9)
// First element is 1, so can only go to 3.
// Second element is 3, so can make at most 3 steps
// eg to 5 or 8 or 9.

public class MinJumpsReq {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = scn.nextInt();

		for (int cases = 0; cases < tc; cases++) {
			int[] arr = takeinput();
			System.out.println(minjumps(arr, 0, arr.length - 1));
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

	// using Recursion
	public static int minjumps(int[] arr, int lo, int hi) {

		// when source and destination are same
		if (hi == lo) {
			return 0;
		}

		// When nothing is reachable from the given source
		if (arr[lo] == 0) {
			return Integer.MAX_VALUE;
		}

		// Traverse through all the points
		// reachable from arr[lo] to reach arr[hi]

		int min = Integer.MAX_VALUE;

		for (int i = lo + 1; i <= hi && i <= lo + arr[lo]; i++) {
			int jumps = minjumps(arr, i, hi);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			}
		}
		return min;
	}

}
