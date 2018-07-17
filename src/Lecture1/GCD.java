package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {


		Scanner scn = new Scanner(System.in);

		System.out.println("Enter 1st Number :");

		int n1 = scn.nextInt();
		
		System.out.println("Enter 2nd number : ");
		
		int n2 = scn.nextInt();
		
		int ans = 1;
		
		for(int i=1;i<=n1 && i<=n2 ; i++)
		{
			if(n1%i==0 && n2%i==0)
			{
				ans=i;
			}
		}
		System.out.println(ans);

	}

}
