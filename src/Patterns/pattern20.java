package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern20 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();
	
		int row=1;
		
		int nsp1 = n/2;					//initialise no of spaces
		int nst = 1;				//initialise no of stars
		int nsp2=1;
		
		while (row<=n) {
			
			if(row==1 || row==n)
			{
				for (int i = 1; i < n; i++) {
					
					if(i==(n/2+2))
					{
						System.out.print("*");
					}
					else
					{
						System.out.print(" ");  
						
					}
				}
			
			}
			
			else
			{
			int csp=1;			//work for spaces
			while(csp<=nsp1) {
					System.out.print(" ");
					csp=csp+1;
			
		}
			int csta=1;			//work for stars
			
			while(csta<=nst) {
					System.out.print("*");
					csta=csta+1;
			}
			
			
					int cspa=1;			//work for spaces
					while(cspa<=nsp2) {
							System.out.print(" ");
							cspa=cspa+1;
					
				}	
					
					int cstb=1;			//work for stars
					
					while(cstb<=nst) {
							System.out.print("*");
							cstb=cstb+1;
					}
		
			}
			if(row<(n/2+1))
			{
				nsp1=nsp1-1;
				nsp2=nsp2+2;
					
			}
			else
			{
				nsp1=nsp1+1;
				nsp2=nsp2-2;
				
			}
		
			System.out.println();
			row=row+1;									//prep
	}}
}
