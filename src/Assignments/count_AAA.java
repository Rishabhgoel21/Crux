package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class count_AAA {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String str = scn.nextLine();
		System.out.println(countoverlap(str));

		System.out.println(countnotoverlap(str));
	}

	public static int countoverlap(String str) {

		int count = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == 'a' && str.charAt(i + 1) == 'a' && str.charAt(i + 2) == 'a') {
				count++;
			}
		}

		return count;
	}

	public static int countnotoverlap(String str) {

		int count = 0;

		for (int i = 0; i < str.length() - 2; i = i + 3) {
			if (str.charAt(i) == 'a' && str.charAt(i + 1) == 'a' && str.charAt(i + 2) == 'a') {
				count++;
			}
		}

		return count;
	}

}