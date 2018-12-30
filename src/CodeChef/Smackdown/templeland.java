package CodeChef;

/**
 * @author Rishabh
 * 
 * @date 28-Sep-2018
*/
import java.util.Scanner;

public class templeland {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int[] array = takeinput();
			check(array);
			cases++;
		}
	}

	public static int[] takeinput() {

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void check(int[] a) {
		int n = a.length;
		int ans = 1;

		if (a[0] != 1 || a[n - 1] != 1) {
			ans = 0;
		}
		for (int i = 0; i <= n / 2; i++)
			if (a[i] != i + 1) {
				ans = 0;
			}

		int j = 1;
		for (int i = n - 1; i >= n / 2; i--) {
			if (a[i] != j) {
				ans = 0;
			} else {
				j++;
			}
		}
			if (ans == 0) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
	}
}