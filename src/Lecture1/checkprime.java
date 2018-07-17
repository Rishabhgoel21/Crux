package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class checkprime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the Number : ");

		int n = scn.nextInt();

		int num = 2;
		int flag = 0;

		while (num < n) {
			if (n % num == 0) {
				flag = 1;
				break;
			}
			num = num + 1;
		}

			if (flag == 0) {
				System.out.println("Prime");
			} else {
				System.out.println("Not Prime");
			}
		}

}