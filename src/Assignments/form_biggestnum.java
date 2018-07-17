package Assignments;

/**
 * @author Rishabh
 */
import java.util.Scanner;

public class form_biggestnum {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 0;

		while (cases < t) {

			String[] str = takeinput();

			// this functions arranges the numbers in ascending order
			bubbleSort(str);

			for (String val : str) {
				System.out.print(val);
			}
			System.out.println();
			cases++;
		}
	}

	public static String[] takeinput() {

		int n = scn.nextInt();

		int[] arr = new int[n];

		String[] str = new String[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();

			str[i] = Integer.toString(arr[i]);
		}
		return str;
	}

	public static void bubbleSort(String[] arr) {

		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - 1 - counter; j++) {

				if (compare(arr[j], arr[j + 1]) > 0) {

					String temp = arr[j];

					arr[j] = arr[j + 1];

					arr[j + 1] = temp;

				}
			}
		}
	}

	public static int compare(String str1, String str2) {

		int i = 0;

		int j = 0;

		while (i < str1.length() && j < str2.length()) {

			if (str1.charAt(i) != str2.charAt(j)) {

				return str2.charAt(i) - str1.charAt(j);

			} else {

				i++;

				j++;

			}

		}

		if (i == str1.length() && j < str2.length()) {

			char lc = str2.charAt(j);

			char ls = str2.charAt(j - 1);

			if (lc > ls) {

				return 1;

			} else {

				return -1;

			}

		}

		if (j == str2.length() && i < str1.length()) {

			char lc = str1.charAt(i);

			char ls = str1.charAt(i - 1);

			if (lc > ls) {

				return -1;

			} else {

				return 1;

			}

		}

		return 0;

	}

}
