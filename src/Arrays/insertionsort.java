package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class insertionsort {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();

		insertionSort(array);
		display(array);
	}

	public static int[] takeinput() {
		System.out.println("Enter Size ");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter " + i + "th value");
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;

		for (int counter = 1; counter <= n - 1; counter++) {
			int temp = arr[counter];
			int j = counter - 1;
			while (j >= 0 && arr[j] > temp) {

				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;

		}

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.println(val);
		}
	}

}