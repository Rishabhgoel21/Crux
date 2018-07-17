package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern32 {

	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();
	
		int row=1;
		
		int nst = 1;
		int val=1;
		
		while (row<=2*n-1) {
			
			int cst=1;			//work for stars
			while(cst<=nst) {
					if(cst%2==0)
					{
						System.out.print("*");
						
					}else
					{
						System.out.print(val);
						
					
					}
					cst=cst+1;
		}
			if(row<n)
			{
			nst+=2;
			val++;
			}
			else
				{
				nst-=2;
				val--;
				}
				System.out.println();
				
			row=row+1;
	}
	}
}
