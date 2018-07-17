package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern18 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();
	
		int row=1;
		
		int nsp = n/2;					//initialise no of spaces
		int nst = 1;				//initialise no of stars
		
		while (row<=n) {
			

			int csp=1;			//work for spaces
			while(csp<=nsp) {
					System.out.print(" ");
					csp=csp+1;
			
		}
			
			
			int csta=1;			//work for stars
			while(csta<=nst) {
					System.out.print("*");
					csta=csta+1;
			
		}
			
		
			
			if(row<=n/2)
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
			row=row+1;									//prep
	}}
}
