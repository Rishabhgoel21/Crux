package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class evnodd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int num = scn.nextInt();

		if (num % 2 == 0) {
			System.out.println("Number is Even");
		} else {
			System.out.println("Number is Odd");
		}
	}

}
