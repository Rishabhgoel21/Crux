package Lecture2;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class rotate_no {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Number : ");

		int n = scn.nextInt();
		
		int nod=0;
		int r = scn.nextInt();
		
		int num=n;   // bcoz otherwise after while loop n would become zero, therefore storing num on temporary
		while(num!=0)
		{
			nod++;
			num=num/10;			// to find no. of digits of the input
			
		}
		
		if(r<0)				//make -ve to +ve
		{
			r=r+nod;
		}
		
		
		if(r>nod)			//makes r smaller to nod
		{
			r=r-nod;
		}
		
		int divisor = (int) Math.pow(10, r);
		
		int rem = n % divisor;
		int quot = n / divisor;
		
		
		System.out.print(rem);
		System.out.print(quot);
	}
}