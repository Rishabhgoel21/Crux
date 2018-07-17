package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class wildcard_matching {

	static Scanner scn = new Scanner(System.in);

	/*
	 * You are given a text and a wildcard pattern. A text contains lowercase
	 * English letters only. A wildcard pattern can contain, along with lowercase
	 * English letters, '?' and '*' characters. '?' matches any single character.
	 * For example, Text = "aaba" and Pattern = "aa?a", then they are matched.
	 * 
	 * ' * ' matches any subsegment of characters(including empty sub-segment). For
	 * example, Text = "aaba" and Pattern = "a*", then they are matched. Find out if
	 * the pattern and text matches or not.
	 */
	public static void main(String[] args) {

		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		wildCard(str1, str2);

	}

	public static void wildCard(String src, String pat) {

		int i = 0;
		int j = 0;

		int starindex = -1;
		int charindex = -1;

		while (i < src.length()) {

			if (j < pat.length() && (pat.charAt(j) == '?' || pat.charAt(j) == src.charAt(i))) {
				i++;
				j++;
			} else if (j < pat.length() && pat.charAt(j) == '*') {

				starindex = j;
				charindex = i;

				j++;
			} else if (starindex != -1) {
				i = charindex + 1;
				j = starindex + 1;

				charindex++;
			} else {
				System.out.println("NOT MATCHED");
			}
		}

		while (j < pat.length() && pat.charAt(j) == '*') {
			j++;
		}
		
		if(j==pat.length())
		{
		System.out.println("MATCHED");
		}
		else
		{
			System.out.println("NOT MATCHED");
		}
	}

}