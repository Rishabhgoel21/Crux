package Strings;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class max_frequency {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		String str = scn.nextLine();
		char maxoccuring = maxfreq(str);
		System.out.println(maxoccuring);

	}

	public static char maxfreq(String str) {

		StringBuilder sb = new StringBuilder(str);
		int n = str.length();

		/*Create array to keep the count of individual
         characters and initialize the array as 0
*/		int count[] = new int[256]; 			// 256 is the default ASCII size

		for (int i = 0; i < n; i++)
			count[str.charAt(i)]++;
		int max = -1;
		char result = ' ';

//		traversing through the string and maintaing count of each variable
		for (int i = 0; i < n; i++) {
			if (max < count[str.charAt(i)]) {
				max = count[str.charAt(i)];
				result = str.charAt(i);
			}

		}
		return result;

	}
}