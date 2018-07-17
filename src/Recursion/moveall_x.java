package Recursion;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class moveall_x {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		StringBuilder sb = new StringBuilder(str.length());
		StringBuilder ans = move(str, 0, sb);
		System.out.println(ans);
	}

	public static StringBuilder move(String str, int vidx, StringBuilder sb) {

		if (vidx == str.length()) {
			StringBuilder br = new StringBuilder();
			br.append("");
			return br;
		}
		char c = str.charAt(vidx);
		if (c == 'x') {
			move(str, vidx + 1, sb);
			sb.append("x");
		} else {
			sb.append(c);
			move(str, vidx + 1, sb);
		}
		return sb;
	}
}