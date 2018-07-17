package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Decimal2binary {

	public static void main(String[] args) {
		
		Scanner scn= new Scanner(System.in);
		
		int n=scn.nextInt();
		
		int multiplier =1;
		int ans=0;
		
		 while(n!=0)
		 {
			 int rem = n%2;
			 ans=ans+(rem*multiplier);
			 multiplier = multiplier*10;
			 n=n/2;
		 }
		 
		 System.out.println(ans);

	}

}
