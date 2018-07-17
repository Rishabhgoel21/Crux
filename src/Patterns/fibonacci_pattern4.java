package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class fibonacci_pattern4 {

	public static void main(String[] args) {
		

Scanner scn = new Scanner(System.in);

		
		int n = scn.nextInt();

		int a = 0;
		int b = 1;
		int sum=0;
		int row=1; int nd=1;
		
		
		while (row <= n) {
            
            int cd=1;
            while(cd<=nd)
            {
			System.out.print(a+ " ");
		
			sum = a + b;
           
			a = b;
			b = sum;

			cd++;
		}
            System.out.println();
            nd++;
		    row++;
		}
    }
}