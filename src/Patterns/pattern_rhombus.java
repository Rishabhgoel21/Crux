package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern_rhombus {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

		int row = 1;

		int val = -1;
		int nsp = n - 1;
		int nst = 1;

		while (row <= 2*n-1) {

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;

			}
if(row<=n) {
			int cst = 1;
			val = val + 2;
			while (cst <= nst) {
				
				if (cst <= nst /2) {
					System.out.print(val);
					cst = cst + 1;
					val = val + 1;
				} else {
					System.out.print(val);
					cst = cst + 1;
					val--;
				}
			}}else
			{
				int cst = 1;
				
				while (cst <= nst) {
					
					if (cst <= nst /2) {
						System.out.print(val);
						cst = cst + 1;
						val = val + 1;
					} else {
						System.out.print(val);
						cst = cst + 1;
						val--;
					}
				}
			}
			
			if(row<n)
			{
				nst=nst+2;
				nsp=nsp-1;
					
			}
			else
			{
				nst=nst-2;
				nsp=nsp+1;
				
			}
			System.out.println();
			row = row + 1;
		}
	}
}
