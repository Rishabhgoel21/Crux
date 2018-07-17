package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class inside_paranthesis {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String str = scn.nextLine();

		StringBuilder sb = new StringBuilder(str);

		int start = sb.indexOf("(");
		int end = sb.indexOf(")");

		System.out.println(sb.substring(start+1, end));
	}

}
