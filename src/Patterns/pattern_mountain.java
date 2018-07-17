package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern_mountain {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

		int row = 1;

		int nsp = n + 1; // initialise no of spaces
		int nst = 1; // initialise no of stars
		
		
		
		while (row <= n) {

			int val = 1;

			int cst = 1; // work for stars
			while (cst <= nst) {
				System.out.print(val);
				cst = cst + 1;
				val++;
			}
			int csp = 1; // work for spaces
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;

			}

			if (row == n) {
				int val2 = row - 1;

				int csta = 1; // work for stars
				while (csta < nst) {

					System.out.print(val2);
					csta = csta + 1;
					val2--;
				}
			} else {
				int val2 = row;

				int csta = 1; // work for stars
				while (csta <= nst) {

					System.out.print(val2);
					csta = csta + 1;
					val2--;
				}
			}

			nst = nst + 1;
			nsp = nsp - 2;
			System.out.println();
			row = row + 1; // prep
		}
	}
}
