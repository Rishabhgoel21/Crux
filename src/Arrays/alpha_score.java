package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class alpha_score {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();
		System.out.println(alphascore(array));
	}

	public static int[] takeinput() {
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static long alphascore(int[] arr) {

		long score = 0;

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					score += arr[j];
				}
			}
		}
		return score%1000000007;

	}
}
