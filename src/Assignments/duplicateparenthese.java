package Assignments;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rishabh
 * 
 * @date 12-Jul-2018
 */

public class duplicateparenthese {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(findDuplicateparenthesis(str));

	}

	public static boolean findDuplicateparenthesis(String str) {

		Stack<Character> brackets = new Stack<Character>();

		int count = 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			// if ch is not a closing parentheses
			if (ch != ')') {
				brackets.push(ch);
			}

			// if ch is a closing parentheses
			else {
				if (brackets.peek() == '(') {
					return true;
				}

				// pop till '(' is found for current ')'
				while (brackets.peek() != '(') {
					brackets.pop();
				}

				brackets.pop();
			}
		}

		return false;
	}
}
