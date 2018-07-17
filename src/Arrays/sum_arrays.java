package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;
import java.util.ArrayList;

public class sum_arrays {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array1 = takeinput1();
		int[] array2 = takeinput2();

		sum_array(array1, array2);
	}

	public static int[] takeinput1() {

		System.out.println("Enter size of 1st array");
		int size = scn.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter Values for 1st Array : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static int[] takeinput2() {

		System.out.println("Enter size of 2nd array");
		int size = scn.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter Values for 2nd Array : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void sum_array(int[] x, int[] y) {
		ArrayList<Integer> list = new ArrayList<>();

		int num1 = 0, num2 = 0;
		for (int i = 0; i < x.length; i++) { // making 1st array as a number
			num1 = num1 + (x[i] * (int) (Math.pow(10, x.length - i)));
		}
		num1 = num1 / 10;

		for (int i = 0; i < y.length; i++) { // making 1st array as a number
			num2 = num2 + (y[i] * (int) (Math.pow(10, y.length - i)));
		}
		num2 = num2 / 10;

		int num = num1 + num2;

		while (num != 0) { // reversing num
			int rem = num % 10;
			list.add(0, rem);
			num /= 10;

		}

		for(int i=0;i<list.size();i++)
		{
				System.out.print(list.get(i)+", ");
				
		}
		System.out.print("END");

	}
}