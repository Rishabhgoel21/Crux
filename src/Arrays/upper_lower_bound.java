package Arrays;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class upper_lower_bound {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		int[] array = takeinput(n);
		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int item = scn.nextInt();			
			System.out.println(lowerbound(array, 0, item));
			System.out.println(upperbound(array, 0, item));
			cases++;
		}
	}

	public static int[] takeinput(int size) {

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static int upperbound(int[] arr,int vidx, int item) {
		        if(vidx==arr.length)
		        {
		            return -1;
		        }
		         int rr = upperbound(arr, vidx+1,item);
		        if(arr[vidx]==item && rr==-1)
		        {
		            return vidx;
		        }
		        return rr;
		    }

	public static int lowerbound(int[] arr, int vidx, int item) {

		  if(vidx==arr.length)
	        {
	            return -1;
	        }
	         int rr = lowerbound(arr, vidx+1,item);
	        if(arr[vidx]==item)
	        {
	            return vidx;
	        }
	       return rr;
	    }
	}
