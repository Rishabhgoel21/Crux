package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class string_compression {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		StringBuilder sb = new StringBuilder(str);
		int n = str.length();

		for (int i = 0; i < n; i++) {
			System.out.print(sb.charAt(i));
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (sb.charAt(j) == sb.charAt(i)) {
					sb.deleteCharAt(i);
					count++;
					--j;
					n--;
				} else if (sb.charAt(j) != sb.charAt(i)) {
					break;

				}

			}
			if (count > 1) {
				System.out.print(count);
			}
		}

	}
}