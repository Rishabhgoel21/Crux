package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class matrix_search {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int[][] array = takeinput();
			int item = scn.nextInt();
			System.out.println(Matrix_search(array, item));
			cases++;
		}
	}

	public static int[][] takeinput() {
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

	public static int Matrix_search(int[][] x, int item) {
		int flag = 0;
		for (int row = 0; row < x.length; row++) {
			for (int col = 0; col < x[0].length; col++) {
				if (x[row][col] == item) {
					flag = 1;
					break;
				}

			}
		}
		return flag;
	}
}