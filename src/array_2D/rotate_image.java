package array_2D;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class rotate_image {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {


		int[][] array = takeinput();
		int[][] ans=rotate(array);
		display(ans);

	}

	public static int[][] takeinput() {

		System.out.println("Enter Rows and columns for 1st matrix: ");
		int rows = scn.nextInt();
		int cols = rows;

		int[][] arr = new int[rows][cols];

		System.out.println("Enter Values for 1st matrix : ");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {

				arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}


	 private static void transpose(int[][] m) {

	        for (int i = 0; i < m.length; i++) {
	            for (int j = i; j < m[0].length; j++) {
	                int temp = m[i][j];
	                m[i][j] = m[j][i];
	                m[j][i] = temp;
	            }
	        }
	    }


	    public static int[][] rotate(int[][] arr) {
	        transpose(arr);					//transpose of matrix

	        //  swap rows
	        for (int  i = 0; i < arr.length/2; i++) {
	            for (int j = 0; j < arr[0].length; j++) {
	                int temp = arr[i][j];
	                arr[i][j] = arr[arr.length -1 -i][j]; 
	                arr[arr.length -1 -i][j] = temp;
	            }
	        }
	        return arr;
	    }

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

}
