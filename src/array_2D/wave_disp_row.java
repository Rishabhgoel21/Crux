package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class wave_disp_row {

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
			for (int col = 0; col < arr[0].length; col++) {
				arr[row][col] = scn.nextInt();

			}
		}

		return arr;

	}

	public static void display(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < arr[0].length; col++) {

					System.out.print(arr[row][col] + ", ");
				}
			} else {
				for (int col = (arr[0].length - 1); col >= 0; col--) {

					System.out.print(arr[row][col] + ", ");
				}
			}
		}
	}
}