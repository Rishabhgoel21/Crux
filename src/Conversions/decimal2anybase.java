package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class decimal2anybase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Number to be convereted");

		int num = scn.nextInt();
		
		System.out.println("in which base?");

		int base = scn.nextInt();
		
		int ans=0;
		int multiplier=1;
		
		while(num!=0)
		{
			int rem = num%base;
			ans = ans + (rem * multiplier);
			 multiplier = multiplier*10;
			 num=num/base;
		}
		
System.out.println(ans);
	}

}
