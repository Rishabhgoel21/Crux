package Lecture2;
/**
 * @author Rishabh
 */
import java.util.Scanner;
/*
sample input --12345
output ---12345 then it is said to be mirror inverse*/

public class Mirror_inverse {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 1;
		int ans = 0;
		boolean a;
		int temp = n;
		while (n != 0) {

			int rem = n % 10;
			ans = ans + (int) Math.pow(10, rem - 1) * count;
			count++;
			n = n / 10;
		}

		if (ans == temp) {
			a = true;
			System.out.println(a);

		} else
			{
			a = false;
			System.out.println(a);
			}
			}

}
