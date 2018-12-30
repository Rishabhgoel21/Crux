package GFG.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 18-Jul-2018s
 */

public class permutation {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scn.nextInt();

		for (int p = 0; p < t; p++) {
			String s = scn.next();
			// sort string
			char ch[] = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				ch[i] = s.charAt(i);
			}
			Arrays.sort(ch);
			s = "";
			for (int i = 0; i < ch.length; i++) {
				s = s + ch[i];
			}
			permutations(s, "");
			System.out.println();

		}
	}

	public static void permutations(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			permutations(roq, ans + ch);
		}

	}

}
