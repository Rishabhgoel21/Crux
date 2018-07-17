package Arrays;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 27-Jun-2018
 */

public class calculate_sum {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();
		int noo = scn.nextInt();

		int i = 0;
		while (i < noo) {
			int operation = scn.nextInt();
			
			
			i++;
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
	/*
	 * At each sum operation, the sum of the elements of the array double. It is
	 * irrelevant what the displacement is exactly, since we are only interested in
	 * the sum.
	 * 
	 * As a result the total sum of the array after Q operations is 2^Q * S with S
	 * the sum of the original array.
	 * 
	 * We thus first compute the sum of the initial array, modulo 10^9+7 and then
	 * multiply this with 2^Q modulo 10^9+7. The result modulo 10^9+7 is written to
	 * stdout. Note that one never needs to read the actual displacements.
	 */

}
