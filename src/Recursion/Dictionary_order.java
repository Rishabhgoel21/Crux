package Recursion;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Dictionary_order {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		order(str, "", str);
	}

	public static void order(String ques, String ans, String temp) {

		if (ques.length() == 0) {
			if (temp.compareTo(ans) < 0) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			order(roq, ans + ch, temp);
		}

	}
}
