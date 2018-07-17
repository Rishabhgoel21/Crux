package DP;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 15-Jul-2018
 */

public class coinChange {

	// Amount(n) = 5
	// coins [coins=3] = {1,2,3}
	// Ways to make change = 5
	// {1,1,1,1,1} {1,1,1,2}, {1,2,2}, {1,1,3} {2,3}
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();

		int coins = scn.nextInt();

		int[] coin = new int[coins];

		for (int i = 0; i < coins; i++) {
			coin[i] = scn.nextInt();
		}

		// System.out.println(coincount(coin, coins, n));
		System.out.println(coincountBU(coin, n));
	}

	// using Recursion
	public static int coincount(int[] coin, int coins, int n) {

		// If n = 0, there is 1 solution
		if (n == 0) {
			return 1;
		}

		// If n<0, then no solution exists
		if (n < 0) {
			return 0;
		}

		// If there are no coins and n>0,then no soln exist
		if (coins <= 0 && n > 0) {
			return 0;
		}

		// 1st call only decreasing no. of coins for 2nd call like loop
		// 2nd call checking the total ways
		int i = coincount(coin, coins - 1, n);
		int j = coincount(coin, coins, n - coin[coins - 1]);

		return (i + j);
	}

	// using DP(bottom up)
	// Explanation --
	// https://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
	public static int coincountBU(int[] coin, int amount) {

		int[][] strg = new int[coin.length + 1][amount + 1];

		// if amount=0
		for (int i = 0; i <= coin.length; i++) {
			strg[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			strg[0][i] = 0;
		}

		// now fill rest of the matrix.
		for (int i = 1; i <= coin.length; i++) {
			for (int j = 1; j <= amount; j++) {

				// check if the coin value is less than the amount needed
				if (coin[i - 1] <= j) {

					// reduce the amount by coin value and
					// use the subproblem solution (amount-coin[i]) and
					// add the solution from the top to it
					strg[i][j] = strg[i - 1][j] + strg[i][j - coin[i - 1]];
				} else {
					// just copy the value from the top
					strg[i][j] = strg[i - 1][j];
				}
			}
		}
		return strg[coin.length][amount];
	}

}
