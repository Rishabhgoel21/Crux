package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class arrays_2D_inout {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] array = takeinput();
		display(array);

	}

	public static int[][] takeinput() {

		System.out.println("Enter Rows : ");
		int rows = scn.nextInt();

		int[][] arr = new int[rows][];

		for (int row = 0; row < arr.length; row++) {
			System.out.println("Enter Col for " + row + "?");
			int col = scn.nextInt();

			arr[row] = new int[col];

			for (int cols = 0; cols < arr[row].length; cols++) {
				System.out.println("Enter values of " + row + " row : ");
				arr[row][cols] = scn.nextInt();

			}
		}

		return arr;

	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

}
