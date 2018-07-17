package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class matrix_multiplication {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] array1 = takeinput1();
		int[][] array2 = takeinput2();

		matrix_multiply(array1, array2);

	}

	public static int[][] takeinput1() {

		System.out.println("Enter Rows and columns for 1st matrix: ");
		int rows = scn.nextInt();
		int cols = scn.nextInt();

		int[][] arr = new int[rows][cols];

		System.out.println("Enter Values for 1st matrix : ");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {

				arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	public static int[][] takeinput2() {

		System.out.println("Enter Rows and columns for 2nd matrix: ");
		int rows = scn.nextInt();
		int cols = scn.nextInt();

		int[][] arr = new int[rows][cols];

		System.out.println("Enter Values for 2nd matrix : ");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {

				arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void matrix_multiply(int[][] x, int[][] y) {
		int rowx = x.length;
		int colx = x[0].length;

		int rowy = y.length;
		int coly = y[0].length;

		int[][] arr = new int[x.length][y[0].length];

		if (colx != rowy) {
			System.out.println("Matrix can not be multiplied !!");
		} else {
			for (int row = 0; row < x.length; row++) {
				for (int col = 0; col < y[0].length; col++) {
					int ans = 0;

					for (int i = 0; i < y.length; i++) {
						ans = ans + (x[row][i] * y[i][col]);

					}
					arr[row][col] = ans;

				}
			}

		}
		for (int m = 0; m < x.length; m++) {
			for (int n = 0; n < y[0].length; n++) {
				System.out.print(arr[m][n] + " ");

			}
			System.out.println();
		}

	}
}