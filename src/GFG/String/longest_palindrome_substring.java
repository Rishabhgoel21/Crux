package GFG.String;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 18-Jul-2018
 */

public class longest_palindrome_substring {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scn.nextInt();
		int flag = 1;
		String ans = "";

		for (int p = 0; p < t; p++) {

			String str = scn.next();

			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j <= str.length(); j++) {
					String temp = (str.substring(i, j));
					String reverse = "";

					for (int k = temp.length() - 1; k >= 0; k--) {
						reverse += temp.charAt(k);
					}

					if (reverse.equals(temp)) {
						if (reverse.length() > ans.length()) {
							ans = temp;
						}
						flag = 0;
					}

				}
			}
			if (flag == 0) {
				System.out.println(ans);
				ans = "";
				flag = 1;
			} else {
				System.out.println(str.charAt(0));
			}

		}
	}
}