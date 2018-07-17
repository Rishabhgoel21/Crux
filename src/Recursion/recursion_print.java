package Recursion;

import java.util.Scanner;

/**
 * @author Rishabh
 */
public class recursion_print {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		// printSS("abc", "");
		// printSSplus("ab", "");
		// System.out.println(permutation("abc", ""));
		// Keypad_combination("145", "");
		// System.out.println(board_path(0, 10,""));
		// System.out.println(maze_path(0, 0, 2, 2, ""));
		// lexico_count(0, 100000);
		int n = scn.nextInt();
		char[] str = new char[2 * n];
		printparentheses(str, n, 0, 0, 0);

	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans);
		printSS(roq, ans + ch);

	}

	public static void printSSplus(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		int ascii = ch;
		String roq = ques.substring(1);

		printSSplus(roq, ans);
		printSSplus(roq, ans + ch);
		printSSplus(roq, ans + ascii);
	}

	public static String getcode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static void Keypad_combination(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = getcode(ch);
		for (int i = 0; i < code.length(); i++) {
			Keypad_combination(roq, ans + code.charAt(i));
		}

	}

	public static int permutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}
		int count = 0;

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			count += permutation(roq, ans + ch);
		}

		return count;
	}

	public static void lexico_count(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				lexico_count((curr * 10) + i, end);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				lexico_count((curr * 10) + i, end);
			}
		}
	}

	public static int board_path(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;
		for (int dice = 1; dice <= 6 && curr + dice <= end; dice++) {
			count += board_path(curr + dice, end, ans + dice);
		}
		return count;
	}

	public static int maze_path(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = maze_path(cr, cc + 1, er, ec, ans + "H");

		int cv = maze_path(cr + 1, cc, er, ec, ans + "V");
		return ch + cv;
	}

	public static void targetSum(int[] arr, int vidx, int pSum, String ans, int target) {

		if (vidx == arr.length) {
			if (pSum == target) {
				System.out.println(ans);
			}
			return;
		}

		targetSum(arr, vidx + 1, pSum, ans, target);
		targetSum(arr, vidx + 1, pSum + arr[vidx], ans + " " + arr[vidx], target);
	}

	public static void coin(int n, String ans) {

	}

	public static void coinNoConsecutiveHead(int n, String ans, boolean wasLastHeadIncluded) {

	}

	public static void printparentheses(char[] str, int n, int idx, int open, int close) {
		//base case
		if (close == n) {
			for (int i = 0; i < str.length; i++)
				System.out.print(str[i]);
			System.out.println();
			return;
		}
	
			if (open > close) {
				str[idx] = ')';
				printparentheses(str, n, idx + 1, open, close + 1);
			}
			if (open < n) {
				str[idx] = '(';
				printparentheses(str, n, idx + 1, open + 1, close);
			}
	}
}
