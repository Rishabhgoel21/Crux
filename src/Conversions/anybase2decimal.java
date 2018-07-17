package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class anybase2decimal {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter base");
		int basein = scn.nextInt();
		
		System.out.println("Enter Number to be convereted");

		int num = scn.nextInt();
		
		
		int ans=0;
		int multiplier=1;
		
		while(num!=0)
		{
			int rem = num%10;
			ans = ans + (rem * multiplier);
			 multiplier = multiplier*basein;
			 num=num/10;
		}
		
System.out.println(ans);
	}

}
