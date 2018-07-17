package Lecture3;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class printarmstrong {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter lower Limit");
		int ll = scn.nextInt();
		System.out.println("Enter Upper Limit");
		int ul = scn.nextInt();

		printallarmstrong(ll, ul);

	}

	public static void printallarmstrong(int x, int y) {

		for (int i = x; i <= y; i++) {
			int ans = 0;
			int nod = numofdigits(i);
			int temp=i;
			for (int j = 1; j <= nod; j++) {
				int rem = i % 10;
				ans = ans + (int) (Math.pow(rem, nod));
				i = i / 10;
			}
			i=temp;
			
			if (temp == ans) {
				System.out.println(temp);
			}
		}
	}

	public static int numofdigits(int a) {
		int count = 0;
		while (a != 0) {
			int rem = a % 10;

			count++;
			a = a / 10;
		}
		return count;
	}
}
