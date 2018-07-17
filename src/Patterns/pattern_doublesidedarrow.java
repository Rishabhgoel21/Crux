package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern_doublesidedarrow {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

		int row = 1;

		int nsp = -1; // initialise no of spaces
		int nst = 1; // initialise no of stars
		int nspp = n - 1;

		while (row <= n) {

			int val1 = 1;

			int csp = 1; // work for spaces
			while (csp <= nspp) {
				System.out.print(" ");
				csp = csp + 1;

			}

			if (row <= n / 2) {
				int val2 = row;

				int csta = 1; // work for stars
				while (csta <= nst) {

					System.out.print(val2);
					csta = csta + 1;
					val2--;
				}
			} else {
				int val2 = n - row + 1;
				int csta = 1; // work for stars
				while (csta <= nst) {

					System.out.print(val2);
					csta = csta + 1;
					val2--;

				}
			}

			int cspp = 1; // work for spaces
			while (cspp <= nsp) {
				System.out.print(" ");
				cspp = cspp + 1;
			}

			int cst = 1; // work for stars
			while (cst <= nst) {
				if (row == 1 || row == n) {
					break;
				} else {
					System.out.print(val1);
					cst = cst + 1;
					val1++;
				}
			}

			if (row <= n / 2) {
				nst = nst + 1;
				nsp = nsp + 2;
				nspp = nspp - 2;
			} else {
				nst = nst - 1;
				nsp = nsp - 2;
				nspp = nspp + 2;
			}

			System.out.println();
			row = row + 1; // prep
		}
	}
}
