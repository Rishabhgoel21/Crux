package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class decimal2octal {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int ans=0;
		int multiplier=1;
		
		while(n!=0)
		{
			int rem = n%8;
			ans = ans + (rem * multiplier);
			 multiplier = multiplier*10;
			 n=n/8;
		}
		
System.out.println(ans);
	}

}
