package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern19 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();
	
		int row=1;
		
		int nsp = 1;					//initialise no of spaces
		int nst = n/2;				//initialise no of stars
		
		while (row<=n) {
			
			if(row==1 || row==n)
			{
				for(int i=1;i<=n;i++)
				{
				System.out.print("*");
			}}
			
			else
			{
				int csta=1;			//work for stars
			
			while(csta<=nst) {
					System.out.print("*");
					csta=csta+1;
			
		}
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
			
			if(row<(n/2+1))
			{
				nst=nst-1;
				nsp=nsp+2;
					
			}
			else
			{
				nst=nst+1;
				nsp=nsp-2;
				
			}		}
			System.out.println();
			row=row+1;									//prep
	}}
}
