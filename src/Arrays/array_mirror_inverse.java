package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class array_mirror_inverse {
	
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
		int flag=0;
		for (int k = 0; k < arr.length; k++) {

			if (arr[k] != y[k]) {
	              flag=1;
	                break;
	                
	            } else {
	            
	            flag=0;

	           }}
			if(flag==0)
			{
			    System.out.println("true");
			}else
			{
			    System.out.println("false");
			}
	}
		
}