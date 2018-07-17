package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class inverting_digit {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String num = scn.next();
		for (int i = 0; i < num.length(); ++i) {
			if (i == 0) {
				if ('5' <= num.charAt(0) && num.charAt(0) <= '8')
					System.out.print((char) ('0' + 9 - num.charAt(0) + '0'));
				else
					System.out.print(num.charAt(0));
			} else {
				if ('5' <= num.charAt(i) && num.charAt(i) <= '9')
					System.out.print((char) ('0' + 9 - num.charAt(i) + '0'));
				else
					System.out.print(num.charAt(i));
			}
		}
	}

}
