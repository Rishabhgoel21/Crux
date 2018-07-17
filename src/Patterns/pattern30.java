package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern30 {

	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();
	
		int row=1;
		
		int nst = n;
		
		while (row<=n) {
			
			int val=n;
			int cst=1;			//work for stars
			while(cst<=nst) {
					System.out.print(val) ;
					cst=cst+1;
					val--;
		}
			System.out.println();
			row=row+1;
	}
	}
}
