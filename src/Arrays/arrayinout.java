package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class arrayinout {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] array = takeinput();
		display(array);
		
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
	
	public static void display(int[] arr)
	{
		for(int val : arr)
		{
			System.out.println(val);
		}
	}
	
}