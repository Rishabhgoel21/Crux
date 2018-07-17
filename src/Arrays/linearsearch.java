package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class linearsearch {

		static Scanner scn = new Scanner(System.in);

		public static void main(String[] args) {
			
			int[] array = takeinput();
			
			System.out.println("Enter no. to be searched ");
			int n=scn.nextInt();
			
			linearsearch(array, n );
			
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
		
		public static void linearsearch(int[] arr, int item)
		{int i=0;
			for(i=0; i< arr.length; i++)
				
			{
				if(arr[i]==item)
				{
					System.out.println(i);
					break;
			}
			}
		if(i==arr.length)
		{
		    System.out.println("-1");
		}


	}

}
