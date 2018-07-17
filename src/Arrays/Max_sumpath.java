package Arrays;
/**
 * @author Rishabh
 */
import java.util.Arrays;
import java.util.Scanner;

public class Max_sumpath {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int n1 = scn.nextInt();
			int n2 = scn.nextInt();
			int[] array1 = takeinput1(n1);
			int[] array2 = takeinput2(n2);

			System.out.println(intersection(array1, array2));
			cases++;
		}
	}

	public static int[] takeinput1(int n) {

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static int[] takeinput2(int n) {

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static int intersection(int[] x, int[] y) {
		Arrays.sort(x);
		Arrays.sort(y);

		int i = 0, j = 0;
		int result = 0;
		int sum1 = 0;
		int sum2 = 0;
		while (i < x.length && j < y.length) {
			if (x[i] < y[j]) {
				sum1 += x[i];
				i++;
			} else if (x[i] > y[j]) {
				sum2 += y[j];
				j++;
			}

			else

			{
				// Take the maximum of two sums and add to result
				result += Math.max(sum1, sum2);

				// Update sum1 and sum2 for elements after intersection point
				sum1 = 0;
				sum2 = 0;

				// Keep updating result while there are more common elements
				while (i < x.length && j < y.length && x[i] == y[j]) {
					result += x[i];
					i++;
					j++;
				}
			}
		}

		// Add remaining elements of arr1 and arr2[]
		while (i < x.length) {
			sum1 += x[i];
			i++;
		}

		// Add remaining elements of ar2[]
		while (j < y.length) {
			sum2 += y[j];
			j++;
		}
		// Add maximum of two sums of remaining elements
		result += Math.max(sum1, sum2);

		return result;
	}
}
