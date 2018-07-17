package Stack_Queue_LL;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rishabh
 * 
 * @date 15-Jul-2018
 */

public class postfix_expression {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		scn.nextLine();
		for (int cases = 0; cases < tc; cases++) {
			String str = scn.nextLine();
			System.out.println(postfix(str));

		}
	}

	public static String postfix(String str) {
		Stack<String> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (Character.isDigit(ch))
				s.push("" + ch);

			if (ch == '*' || ch == '+' || ch == '/' || ch == '-') {
				int b = Integer.parseInt(s.pop());
				int a = Integer.parseInt(s.pop());
				int result = 0;
				if (ch == '*')
					result = a * b;
				else if (ch == '+')
					result = a + b;
				else if (ch == '-')
					result = a - b;
				else if (ch == '/')
					result = a / b;
				else
					result = a % b;

				String ans = Integer.toString(result);
				s.push(ans);
			}
		}

		return s.pop();
	}
}
