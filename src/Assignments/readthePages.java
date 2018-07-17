package Assignments;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 15-Jul-2018
 */

public class readthePages {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int books = scn.nextInt();
		long students = scn.nextLong();
		long book[] = new long[books];

		for (int i = 0; i < books; i++) {
			// inputing the pages of each book
			book[i] = scn.nextLong();
		}

		long ans = binary(book, students);

		System.out.println(ans);

	}

	public static long binary(long[] book, long students) {

		long sum = 0;

		for (int i = 0; i < book.length; i++) {
			// sum of all pages of all books
			sum += book[i];
		}

		long lo = 0;
		long hi = sum;

		long anstilnow = 0;

		while (lo <= hi) {

			long mid = (lo + hi) / 2;

			if (isValid(book, students, mid)) {

				anstilnow = mid;

				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return anstilnow;
	}

	public static boolean isValid(long[] book, long k, long mid) {

		long students = 1;

		long sum = 0;

		for (int i = 0; i < book.length; i++) {

			if (book[i] > mid) {
				return false;
			}

			sum += book[i];

			if (sum > mid) {

				students++;

				sum = book[i];
			}

			if (students > k) {
				return false;
			}
		}
		return true;
	}
}