package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class bubblesort {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();

		bubbleSort(array);
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

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int counter=0; counter < n-1; counter++)
		{	
			for(int j=0; j < n - counter -1; j++ )
			{
				if (arr[j] > arr[j+1]) {
					
					int temp =arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=temp;
				}
				}
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