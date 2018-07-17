package Arrays;
/**
 * @author Rishabh
 */
import java.util.Arrays;
import java.util.Scanner;

public class selectionsort {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();

		selectionSort(array);
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

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		
		for(int counter=0; counter < n-1; counter++)
		{	
			int min = counter;
			for(int j=counter +1; j < n; j++ )
			{
				if (arr[j] < arr[min]) {
					
					min =j;
									}
			}
			
			int temp =arr[counter];
			arr[counter]=arr[min];
			arr[min]=temp;
	}

}

	public static void display(int[] arr)
	{
		for(int val : arr)
		{
			System.out.println(val);
		}
	}
	
}