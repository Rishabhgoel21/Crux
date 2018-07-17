package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
	

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

		int a = 0;
		int b = 1;
		int counter = 1;
		System.out.println(a);
		System.out.println(b);
		while (counter < n) {

			int sum = a + b;

			System.out.println(sum);

			a = b;
			b = sum;

			counter = counter + 1;
		}
	}

}
