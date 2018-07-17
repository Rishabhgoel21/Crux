package DP;
/**
 * @author Rishabh
 * 
 * @date 13-Jul-2018
*/

public class WildcardMatching {

	public static void main(String[] args) {

		 System.out.println(wildCardMatching("aaabac", "**ab*?"));
	}

	public static boolean wildCardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pattern.length() != 0) {

			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;

		}

		char srcChar = src.charAt(0);
		char patChar = pattern.charAt(0);
		String srcRos = src.substring(1);
		String patRos = pattern.substring(1);

		if (patChar == '*') {

			boolean fc = wildCardMatching(src, patRos);
			boolean sc = wildCardMatching(srcRos, pattern);

			return fc || sc;
		} else if (patChar == '?' || patChar == srcChar) {
			return wildCardMatching(srcRos, patRos);
		} else {
			return false;
		}
	}

}
