package Arrays;
/**
 * @author Rishabh
 */
import java.util.Arrays;
import java.util.Scanner;

public class rotate_array {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();
			
		int[] arr=rotate(array);
		display(arr);

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

	public static int[] rotate(int[] arr)
	{
		System.out.println("Enter Rotations?");
		int r=scn.nextInt();
		int[] finalarray= new int[arr.length];
		
		for(int p=0; p<finalarray.length; p++)
		{
			if(p<r)
			{
				finalarray[p]= arr[p+arr.length - r];
				
			}else
			{
				finalarray[p]= arr[p - r];
			}
		}
		return finalarray;
		
	}
	
	public static void display(int[] arr)
	{
		for(int val : arr)
		{
			System.out.println(val);
		}
	}
	
}
