package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;;

public class Intersection {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array1 = takeinput1();
		int[] array2 = takeinput2();

		intersection(array1, array2);
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

	public static void intersection(int[] x, int[] y) {
		ArrayList<Integer> list = new ArrayList<>();

		Arrays.sort(x);
		Arrays.sort(y);
		
		int i=0,j=0;

		while(i<x.length && j<y.length)
		{		if(x[i]==y[j])
		{		list.add(x[i]);
		i++;
		j++;
		
		} else if(x[i]>y[j])
		{
			j++;
		}else
		{
			i++;
		}
		}
		System.out.println(list);
	}

}