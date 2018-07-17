package Patterns;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pattern_number_ladder {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter Number :");

		int n = scn.nextInt();

		int i, j, num = 1;

		for (i = 0; i < n; i++) {

			for (j = 0; j <= i; j++) {

				System.out.print(num + " ");

				num = num + 1;
			}

			System.out.println();
		}

	}

}
