package Assignments;
/**
 * @author Rishabh
 */
import java.util.Arrays;
import java.util.Scanner;

public class roses {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int test = scn.nextInt(); // no. of test cases

		for (int i = 0; i < test; i++)

		{

			int roses = scn.nextInt(); // no. of roses

			int[] price = new int[roses]; // of different prices

			for (int l = 0; l < roses; l++) {
				price[l] = scn.nextInt();
			}

			Arrays.sort(price);
			int money = scn.nextInt(); // money available

			int r1 = 0;
			int r2 = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < roses; j++) // j will count all prices from starting
			{
				int moneyleft = money - price[j];

				for (int k = j + 1; k < roses; k++) {
					if (price[k] == moneyleft) {

						int diff = price[k] - price[j];

						if (diff < min) {
							min = diff;
							r1 = j;
							r2 = k;

						}

					}
				}
			}

			System.out.print("Deepak should buy roses whose prices are " + price[r1] + " and " + price[r2] + ".");

			System.out.println();
		}
	}
}