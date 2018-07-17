package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class palindrome {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();

		String reverse = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}

		if (reverse.equals(str)) {
			System.out.println("Palindrome");

		} else {
			System.out.println("Not Palindrome");
		}

	}

}
