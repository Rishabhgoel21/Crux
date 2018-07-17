package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class printprime {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

			int n = scn.nextInt();
		int flag;
		
		for(int i=2;i<=n;i++){
			flag=0;
			for(int j=2;j<i;j++)
			{
			if (i % j == 0) {
				flag = 1;
				
			}
		}
			if (flag == 0) {
				System.out.println(i);
			}
		}}

}