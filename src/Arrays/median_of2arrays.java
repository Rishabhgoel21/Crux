package Arrays;
/**
 * @author Rishabh
 */
import java.util.Arrays;
import java.util.Scanner;

public class median_of2arrays {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		int[] array1 = takeinput(n);
		int[] array2 = takeinput(n);

		int[] array = mergetwosortedarrays(array1, array2);

		Arrays.sort(array);
		if (array.length % 2 == 0) {
			int idx = (array.length / 2) - 1;
			System.out.println(array[idx]);
		} else {
			int idx = (array.length / 2) + 1;
			System.out.println(array[idx]);
		}
	}

	public static int[] takeinput(int size) {

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static int[] mergetwosortedarrays(int[] one, int[] two) {

		int[] sorted = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length) {
			sorted[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			sorted[k] = two[j];
			j++;
			k++;
		}
		return sorted;
	}

}
