package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class vertical_disp {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] array = { {2,4,6}, {4,6,8}, {7,2,7}};
		display(array);

	}

	public static void display(int[][] arr) {
		
		for (int col = 0; col < arr[0].length; col++) {
			
		for (int row = 0; row < arr.length; row++) {
			
				System.out.print(arr[row][col] + " , ");
			}
		}
	}

}
