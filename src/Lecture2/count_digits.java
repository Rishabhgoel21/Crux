package Lecture2;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class count_digits {

	public static void main(String[] args) {
		
Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Number");
		int num = scn.nextInt();
		
		System.out.println("Enter digit to be counted");

		int dgt = scn.nextInt();
		int ans=0;
		while(num!=0)
		{
			int rem=num%10;
			
			if(rem==dgt)
			{
				ans++;
				
			}
			num/=10;
		}
		System.out.println(ans);
	}

}
