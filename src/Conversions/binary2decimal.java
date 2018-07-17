package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class binary2decimal {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int ans=0;
		int multiplier=1;
		
		while(n!=0)
		{
			int rem = n%10;
			ans = ans + (rem * multiplier);
			 multiplier = multiplier*2;
			 n=n/10;
		}
		
System.out.println(ans);
	}

}
