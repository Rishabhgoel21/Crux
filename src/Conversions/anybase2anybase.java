package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class anybase2anybase {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter source base");
		int sb = sc.nextInt();
		System.out.println("Enter destination base");
		int db = sc.nextInt();
		
		System.out.println("Enter Number to be convereted");

		int num = sc.nextInt();
		
		
		int ans1=0,fans=0;
		int multiplier1=1,multiplier2=1;
		
		while(num!=0)
		{
										//first srcbase to decimal
			int rem1 = num % 10;
			ans1 = ans1 + (rem1 * multiplier1);
			multiplier1 = multiplier1 * sb;
			num = num/ 10; 
		}
				while(ans1!=0)													//here decimal 2 dstbase
				{
					int rem2 = ans1 % db;
					fans = fans + (rem2 * multiplier2);
					multiplier2 = multiplier2 * 10;
					ans1 = ans1 / db;
			}
		
			System.out.println(fans);
		}	
	}