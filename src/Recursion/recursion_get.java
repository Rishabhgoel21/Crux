package Recursion;
/**
 * @author Rishabh
 */
import java.util.ArrayList;

public class recursion_get {

	public static void main(String[] args) {

		// ArrayList<String> ans = getSS("abc");
		// ArrayList<String> ans = getSSplus("ab");
		// ArrayList<String> ans = Keypad_combination("145");
		// ArrayList<String> ans = Permutation("abc");
		// ArrayList<String> ans = Coin_toss(3);
		// ArrayList<String> ans = Board_path(0,10);
		// System.out.println(ans.size());
		// ArrayList<String> ans = maze_path(0, 0, 2, 2);
		// ArrayList<String> ans = mazepath_diagonal(0, 0, 2, 2);
		ArrayList<String> ans = mazePathDMM(0, 0, 2, 2);
		System.out.println(ans);
	}

	public static ArrayList<String> getSS(String str) // get sub sequence
	{
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add(rrs); // ch says no
			mr.add(ch + rrs); // ch says yes

		}

		return mr;

	}

	public static ArrayList<String> getSSplus(String str) // get sub sequence with ASCII codes
	{
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		int ascii = (int) str.charAt(0);

		String ros = str.substring(1);

		ArrayList<String> rr = getSSplus(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add(rrs); // ch says no
			mr.add(ch + rrs); // ch says yes
			mr.add(ascii + rrs);
		}

		return mr;

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

	public static ArrayList<String> Keypad_combination(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);

		ArrayList<String> rr = Keypad_combination(ros);
		ArrayList<String> mr = new ArrayList<>();

		String code = getcode(ch);
		for (int i = 0; i < code.length(); i++) {
			for (String rrs : rr) {
				mr.add(code.charAt(i) + rrs);
			}
		}

		return mr;

	}

	public static ArrayList<String> Permutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);

		ArrayList<String> rr = Permutation(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			for (int i = 0; i <= rrs.length(); i++) {
				mr.add(rrs.substring(0, i) + ch + rrs.substring(i)); // string builder can be used
			}
		}

		return mr;

	}

	public static ArrayList<String> Coin_toss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = Coin_toss(n - 1);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add("H" + rrs);
			mr.add("T" + rrs);
		}

		return mr;

	}

	public static ArrayList<String> Board_path(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6 && curr + dice <= end; dice++) {
			ArrayList<String> rr = Board_path(curr + dice, end);
			for (String rrs : rr) {

				mr.add(dice + rrs);

			}

		}
		return mr;

	}

	public static ArrayList<String> maze_path(int cr, int cc, int er, int ec) { // current row/col end row/col
		if (cr == er && cc == ec) { // BASE CASE
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) { // - ve BASE CASE
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = maze_path(cr + 1, cc, er, ec);
		for (String rrs : rrh) {

			mr.add("H" + rrs);

		}

		ArrayList<String> rrv = maze_path(cr, cc + 1, er, ec);
		for (String rrs : rrv) {

			mr.add("V" + rrs);

		}

		return mr;

	}

	public static ArrayList<String> mazepath_diagonal(int cr, int cc, int er, int ec) { // current row/col end row/col
		if (cr == er && cc == ec) { // BASE CASE
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) { // - ve BASE CASE
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = mazepath_diagonal(cr + 1, cc, er, ec);
		for (String rrs : rrh) {

			mr.add("H" + rrs);

		}

		ArrayList<String> rrv = mazepath_diagonal(cr, cc + 1, er, ec);
		for (String rrs : rrv) {

			mr.add("V" + rrs);

		}

		ArrayList<String> rrd = mazepath_diagonal(cr + 1, cc + 1, er, ec);
		for (String rrs : rrd) {

			mr.add("D" + rrs);

		}

		return mr;

	}

	public static ArrayList<String> mazePathDMM(int cr, int cc, int er, int ec) { // maze path diagonal with multiple
																					// steps

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int i = 1; i <= ec; i++) {
			ArrayList<String> rrh = mazePathDMM(cr, cc + i, er, ec);
			for (String rrhs : rrh) {
				mr.add("H" + i + rrhs);
			}
		}

		for (int j = 1; j <= er; j++) {
			ArrayList<String> rrv = mazePathDMM(cr + j, cc, er, ec);
			for (String rrvs : rrv) {
				mr.add("V" + j + rrvs);
			}
		}

		for (int k = 1; k <= er && k <= ec; k++) {
			ArrayList<String> rrd = mazePathDMM(cr + k, cc + k, er, ec);
			for (String rrds : rrd) {
				mr.add("D" + k + rrds);
			}
		}
		return mr;

	}

}