package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern_invertedhourglass {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

		int row = 1;

		int nsp = 2 * n - 1; // initialise no of spaces
		int nst = 1; // initialise no of stars

		while (row <= 2 * n + 1) {

			int val = n;

			int csta = 1; // work for stars
			while (csta <= nst) {

				System.out.print(val);
				csta = csta + 1;
				val--;
			}

			int cspp = 1; // work for spaces
			while (cspp <= nsp) {
				System.out.print(" ");
				cspp = cspp + 1;
			}

			int cst = 1; // work for stars

			int vall = n - row + 1;
			int valll = row - n - 1;
			int vallll = 1;

			while (cst <= nst) {

				if (row <= n) {
					System.out.print(vall);
					cst = cst + 1;
					vall++;
				}

				else if (row == n + 1) {

					if (vallll <= n) {
						System.out.print(vallll);
						vallll++;
					} else {
						break;
					}
				} else {
					System.out.print(valll);
					cst = cst + 1;
					valll++;
				}

			}

			if (row <= n) {
				nst = nst + 1;
				nsp = nsp - 2;

			} else {
				nst = nst - 1;
				nsp = nsp + 2;
			}

			System.out.println();
			row = row + 1; // prep
		}
	}
}
