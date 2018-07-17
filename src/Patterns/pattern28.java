package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern28 {

	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

	
	
		int row=1;
		
		int val=-1;
		int nsp = n-1;
		int nst = 1;
		
		while (row<=n) {
			
			int csp=1;			//work for spaces
			while(csp<=nsp) {
					System.out.print(" ");
					csp=csp+1;
			
		}
			
			int cst=1;			//work for stars
			val=val+2;
			while(cst<=nst) {
				if(cst<=nst/2)
				{
					System.out.print(val) ;
					cst=cst+1;
					val=val+1;
				}
				else
				{
					System.out.print(val) ;
					cst=cst+1;
					val--;
				}
		}
			nst=nst+2;
			nsp=nsp-1;
			System.out.println();
			row=row+1;
	}
	}
}
