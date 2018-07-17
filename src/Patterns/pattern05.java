package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern05 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();
	
		int row=1;
		
		int nsp = 0;
		int nst = 5;
		
		while (row<=n) {
			
			int csp=1;			//work for spaces
			while(csp<=nsp) {
					System.out.print(" ");
					csp=csp+1;
			
		}
			int cst=1;			//work for stars
			while(cst<=nst) {
					System.out.print("*");
					cst=cst+1;
			
		}
			nst=nst-1;
			nsp=nsp+1;
			System.out.println();
			row=row+1;
	}
	}
}
