package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class togglecase {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < str.length(); i++) {
			if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
				System.out.print(Character.toLowerCase(sb.charAt(i)));
			} else {
				System.out.print(Character.toUpperCase(sb.charAt(i)));

			}
		}

	}

}
