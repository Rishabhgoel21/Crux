package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern31 {

	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();
	
		int row=1;
		
		int nst = n;
		
		while (row<=n) {
			
			int val=n+1;
			int cst=1;			//work for stars
			while(cst<=nst) {
					
					cst=cst+1;
					val--;
					if(val==row)
					{
						System.out.print("*");
					}
					else
					{
						System.out.print(val) ;
					}
		}
			System.out.println();
			row=row+1;
	}
	}
}
