package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern03 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();
	
		int row=1;
		
		
		int nst = 5;				//initialise no of stars
		
		while (row<=n) {
			
					int cst=1;			//work for stars
			while(cst<=nst) {
					System.out.print("*");
					cst=cst+1;
			
		}
		
			nst=nst-1;
			System.out.println();
			row=row+1;									//prep
	}
	}
}
