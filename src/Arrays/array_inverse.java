package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class array_inverse {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[] array = takeinput();

		inverse(array);
		
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

	public static void inverse(int[] arr)
	{	int i=0;
	int[] y=arr.clone();
		while(i<arr.length)
		{												//int[] y = x; don't copy array like this!
			int temp=y[i];
			arr[temp]=i;
			i=i+1;
		}
		
		for(int j=0; j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
	}
}