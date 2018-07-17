package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class remove_duplicates {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		StringBuilder sb = new StringBuilder(str);
		int n = str.length();
		for (int i = 1; i < n - 1; i++) {
			if (sb.charAt(i) == sb.charAt(i-1)) {
				sb.deleteCharAt(i);
				n--;
			}else if(sb.charAt(i) != sb.charAt(i-1))
			{
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(sb.charAt(i));
		}

	}
}