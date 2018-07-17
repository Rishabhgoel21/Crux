package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class sum_of_n_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int sum = 0;
		
		int counter =1;
		
		while (counter<=n) {
			
			sum = sum + counter;
			
			counter = counter + 1;
		}
		
		System.out.println(sum);
	}

}
