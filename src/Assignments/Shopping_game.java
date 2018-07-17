package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Shopping_game {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt(); // test cases

		for (int k = 0; k < t; k++) {
			int i = 1, j = 2;
			int p1 = 0, p2 = 0;
			int m = scn.nextInt(); // M and N denoting the maximum possible number of smartphones
			int n = scn.nextInt();

			while (p1 <= m || p2 <= n) {
				if (p1 <= m) {
					p1 = p1 + i;
				}
				if (p2 <= n) {
					p2 = p2 + j;
				}
				i += 2;
				j += 2;
			}
			if (p1 > p2) {
				System.out.println("Aayush");
			} else {
				System.out.println("Harshit");

			}
		}

	}
}
