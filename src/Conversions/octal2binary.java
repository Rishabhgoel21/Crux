package Conversions;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class octal2binary {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int ans1 = 0;
		int fans=0;
		int multiplier1 = 1;

		int multiplier2 = 1;

		while (n != 0) {											//first octal to decimal
			int rem1 = n % 10;
			ans1 = ans1 + (rem1 * multiplier1);
			multiplier1 = multiplier1 * 8;
			n = n / 10;
		}

		while(ans1!=0)													//here decimal to binary
		{
			int rem2 = ans1 % 2;
			fans = fans + (rem2 * multiplier2);
			multiplier2 = multiplier2 * 10;
			ans1 = ans1 / 2;
		}
		System.out.println(fans);
	}
}
