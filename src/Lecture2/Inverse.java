package Lecture2;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Inverse {
	
	/*Take the following as input.
	A number
	Assume that for a number of n digits, the value of each digit is from 1 to n and is 
	unique. E.g. 32145 is a valid input number.
	Write a function that returns its inverse, where inverse is defined as follows
	Inverse of 32145 is 12543. In 32145, “5” is at 1st place, therefore in 12543, “1” is at
	 5th place; in 32145, “4” is at 2nd place, therefore in 12543, “2” is at 4th place.
*/	
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 1;
		int ans = 0;

		while (n != 0) {

			int rem = n % 10;
			ans = ans + (int) Math.pow(10, rem - 1) * count;
			count++;
			n = n / 10;
		}

		System.out.println(ans);

	}
}
