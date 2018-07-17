package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class substrings_palindrome {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String temp = (str.substring(i, j));
				String reverse = "";

				for (int k = temp.length() - 1; k >= 0; k--) {
					reverse += temp.charAt(k);
				}

				if (reverse.equals(temp)) {
					System.out.println(temp);

				}

			}
		}

	}
}
