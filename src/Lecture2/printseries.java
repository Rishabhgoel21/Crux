package Lecture2;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class printseries {

	public static void main(String[] args) {



Scanner scn = new Scanner(System.in);
	
		int n1 = scn.nextInt();
	
		int n2 = scn.nextInt();
		int ans=0;
		int row=0;
		
		for(int i=1;i<=100;i++)
		{
			ans=3*i+2;
			
			if(ans%n2!=0)
			{
			    System.out.println(ans);
			    row++;
				
			}
			if(row==10)
			{
			    break;
			}
		}
	}

}
