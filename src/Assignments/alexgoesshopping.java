package Assignments;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 13-Jul-2018
*/

public class alexgoesshopping {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] array = takeinput();
		shopping(array);
	}

	public static void shopping(int[] prices) {
		int n = scn.nextInt();
		int cases = 1;
		
		while(cases<=n) {
		
			int count = 1;
			
			//queries input
			int money = scn.nextInt();
			int kindofitems = scn.nextInt();
		
			while(count<=kindofitems) {
				
				count++;
			}
		
		}
	}

	public static int[] takeinput() {
		int n = scn.nextInt();

		int[] prices = new int[n];

		for (int i = 0; i < prices.length; i++) {
			prices[i] = scn.nextInt();
		}
		return prices;
	}

}
