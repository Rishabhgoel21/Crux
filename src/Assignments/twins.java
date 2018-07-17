package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class twins {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String str = scn.nextLine();
		System.out.println(twin(str));
	}

	public static int twin(String str) {

		int countA = 0;

		int countX = 0;

		int ch1 = str.charAt(0);

		for (int j = 2; j < str.length(); j = j + 2) {
			if (str.charAt(j) == ch1) {
				countA++;
			}
			int ch2 = str.charAt(1);

			for (int i = 3; i < str.length(); i = i + 2) {
				if (str.charAt(i) == ch2) {
					countX++;
				}
			}

		}
		return countA + countX -1;

	}

}