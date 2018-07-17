package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class wave_disp_col {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] array = takeinput();
		display(array);
		System.out.print("END");

	}

	public static int[][] takeinput() {

		System.out.println("Enter Rows and cols: ");
		int rows = scn.nextInt();
		int cols = scn.nextInt();

		int[][] arr = new int[rows][cols];

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = scn.nextInt();

			}
		}

		return arr;

	}

	public static void display(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {

					System.out.print(arr[row][col] + ", ");
				}
			} else {
				for (int row = (arr.length - 1); row >= 0; row--) {

					System.out.print(arr[row][col] + ", ");
				}
			}
		}
	}
}