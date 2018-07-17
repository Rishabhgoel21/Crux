package Recursion;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class tower_of_hanoi {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
//		int n  = scn.nextInt();
		TOH(2, "S", "D", "T");
	}

	public static void TOH(int n, String src, String dst, String temp)
	{
		if(n==0)
		{
			return;
		}
		
		TOH(n-1,src, temp, dst);
		System.out.println("Move " + n + "th" + " disc from " + src + " to " + dst);
		TOH(n-1, temp, dst, src);
	}
}
