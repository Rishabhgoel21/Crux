package Recursion;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class assignment {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		// System.out.println(removeduplicates(str));
		System.out.println(duplicateformatting(str));
	}

	public static String removeduplicates(String str) {

		if (str.length() <= 1) {
			return str;
		}
		if (str.substring(1, 2).equals(str.substring(0, 1))) {
			return removeduplicates(str.substring(1));
		} else {
			return str.substring(0, 1) + removeduplicates(str.substring(1));
		}
	}

	public static String duplicateformatting(String str) {

		if (str.length() <= 1) {
			return str;
		}

		if (str.substring(1, 2).equals(str.substring(0, 1))) {
			return duplicateformatting(str.substring(0, 1) + "*" + str.substring(1));
		} else {
			return str.substring(0, 1) + duplicateformatting(str.substring(1));
		}
	}

	public static void isbalanced()
	{
		
	}
}
