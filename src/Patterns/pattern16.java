package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern16 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();
	
		int row=1;
		int nr=(2*n-1);
		
		int nsp = (n-1);					//initialise no of spaces
		int nst = n;				//initialise no of stars
		
		while (row<=nr) {
			
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
			
			if(row<n)
			{
				nst=nst-1;
				nsp=nsp-1;
					
			}
			else
			{
				nst=nst+1;
				nsp=nsp+1;
				
			}
			System.out.println();
			row=row+1;									//prep
	}}
}
