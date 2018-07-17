package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();

		int ans = 0;

		// num % 10 gives the last digit
		// num / 10 removes the last digit

		while (n != 0) {

			int rem = n % 10;
			ans = ans * 10 + rem;
			n = n / 10;
		}

		System.out.println(ans);
	}
}
