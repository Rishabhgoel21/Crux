package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class arrays_spiral_disp {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

//		int[][] array = { { 10, 20, 30, 40, 50 }, { 60, 70, 80, 90, 100 }, { 110, 120, 130, 140, 150 },
//				{ 160, 170, 180, 190, 200 }, { 210, 220, 230, 240, 250 } };
		 int[][] array = takeinput();
		spiraldisplay(array);

	}

	public static int[][] takeinput() {

		System.out.println("Enter Rows and columns : ");
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

	public static void spiraldisplay(int[][] arr) {

		int counter = 0;
		int rmin = 0;
		int rmax = arr.length - 1;
		int cmin = 0;
		int cmax = arr[0].length - 1;

		int nel = arr.length * arr[0].length; // no. of elements

		while (counter < nel) {

			// first col

			for (int row = rmin; counter < nel && row <= rmax; row++) {
				System.out.print(arr[row][cmin] + " ");
				counter++;
			}
			cmin++;

			// last row

			for (int col = cmin; counter < nel && col <= cmax; col++) {
				System.out.print(arr[rmax][col] + " ");
				counter++;
			}
			rmax--;

			// last col

			for (int row = rmax; counter < nel && row >= rmin; row--) {
				System.out.print(arr[row][cmax] + " ");
				counter++;
			}
			cmax--;

			// first row

			for (int col = cmax; counter < nel && col >= cmin; col--) {
				System.out.print(arr[rmin][col] + " ");
				counter++;
			}
			rmin++;
		}

	}
}