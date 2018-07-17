package Arrays;
/**
 * @author Rishabh
 */
import java.util.Arrays;
import java.util.Scanner;

public class binarysearch {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();

		Arrays.sort(array); // arranging array in ascending order

		System.out.println("Enter no. to be searched ");
		int n = scn.nextInt();

		binarySearch(array, n);

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

	public static void binarySearch(int[] arr, int item) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		int mid = (low + high) / 2;
		while (low <= high) {

			if (arr[mid] == item) {

				System.out.println("Element found at position " + mid);
				break;
			}

			else if (arr[mid] > item) {
				high = mid - 1;

			}

			else {
				low = mid + 1;
			}

			mid = (low + high) / 2;

		}

		if (low > high) {
			System.out.println("-1");
		}
	}

}
