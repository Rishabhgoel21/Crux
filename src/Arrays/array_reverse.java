package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class array_reverse {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] array = takeinput();

		int n =array.length;
		for(int i=0;i<n/2;i++)
		{
			int temp = array[i];
			array[i]=array[n-i-1];
			array[n-i-1]=temp;
			
		}
		for(int i=0; i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		
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
	

	
}