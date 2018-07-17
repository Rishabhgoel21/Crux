package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class array_sumpair {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] array = takeinput();
		int target=scn.nextInt();
		sum(array,target);
		
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
	
	public static void sum(int[] arr, int num)
	{	
		int n= arr.length;
		
		for(int i=0;i<n;i++)
		{
			for (int j = i+1; j < n; j++) {
			if(arr[i]+arr[j]==num) {

			    if(arr[i]<arr[j])
			    {
				System.out.print(arr[i]+" and "+arr[j]);
				System.out.println();       }
				else
				{
				System.out.print(arr[j]+" and "+arr[i]);
				System.out.println();       }
			}}
		}
					
	}
	
}