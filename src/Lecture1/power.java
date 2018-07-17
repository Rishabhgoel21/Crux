package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class power {


	public static void main(String[] args) {
	
		
		Scanner scn = new Scanner(System.in);

		int a=scn.nextInt();

		int b=scn.nextInt();

		int ans= (int) Math.pow(a,b);

		System.out.println(ans);

	}

}
