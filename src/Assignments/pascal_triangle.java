package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class pascal_triangle {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
	

		for(int i=0;i<n;i++){
			
			int num = 1;
			
			for (int j = 0; j <= i; j++) {
				System.out.print(num + " ");
				
				num = num * (i - j) / (j + 1);
				
			}
			System.out.println();
		}

	}

}