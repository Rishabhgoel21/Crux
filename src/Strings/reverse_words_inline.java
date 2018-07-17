package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class reverse_words_inline {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int size = scn.nextInt();
		String[] str = new String[size];

		for (int i = 0; i < size; i++) {
			str[i] = scn.next();
		}

		String reverse = "";

		for (int i = size - 1; i >= 0; i--) {

			reverse += str[i] + " ";

		}
		System.out.println(reverse);
	}
}
