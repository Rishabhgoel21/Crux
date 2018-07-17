package Lecture3;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class isarmstrong {

	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		
		int n=scn.nextInt();
		
		int nod= numofdigits(n);
		
		
		
		int ans1 = isarmstrong(n,nod);
		
		if(ans1==n)
		{
			System.out.println("It is armstrong Number");
			
		}
		else
		{
			System.out.println("Not Armstrong Number");
		}
	}
	
	public static int numofdigits(int a)
	{
		int count=0;
		while(a!=0) {
			int rem=a%10;
			a=a/10;
			count++;
		}
		
		return count;
	}
	
	
	public static int isarmstrong(int x,int y)
	{
		int ans=0;
			
			for(int i=1;i<=y;i++)
			{
				int rem=x%10;
				ans = ans + (int) (Math.pow(rem, y));
				x=x/10;
			}
		return ans;
	}
	
}
