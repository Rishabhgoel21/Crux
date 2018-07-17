package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class char2ascii2char {
		
		static Scanner scn = new Scanner(System.in);

		public static void main(String[] args) {

			String str = scn.nextLine();
			StringBuilder sb = new StringBuilder(str);

			for (int i = 0; i < str.length(); i++) {
				if (i % 2 == 0) {
					int nextValue = (int) sb.charAt(i) + 1;
					char c = (char) nextValue;
					System.out.print(c);
				} else {
					int nextValue = (int) sb.charAt(i) - 1;
					char c = (char) nextValue;
					System.out.print(c);

				}
			}
	}

}
