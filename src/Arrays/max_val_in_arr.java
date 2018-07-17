package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class max_val_in_arr {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] array = takeinput();
		maxval(array);
		
	}
	
	public static int[] takeinput()
	{
		System.out.println("Enter Size ");
		int n=scn.nextInt();
		
		int[] arr= new int[n];
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.println("Enter "+ i + "th value");
			arr[i]=scn.nextInt();
		}
			return arr;
	}
	
	public static void maxval(int[] arr)
	{
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
		}
	System.out.println(max);
	}
	
}