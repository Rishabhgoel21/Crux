package DP;

/**
 * @author Rishabh
 * 
 * @date 04-Jul-2018
 */

public class DP {

	public static void main(String[] args) {

		// int n = 3;
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int[] price = { 2, 3, 5, 1, 4 };
		// int[] weight = { 1, 3, 4, 5 };
		// int[] price = { 1, 4, 5, 7 };
		// int cap = 7;
		// int[] prices = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };
		int[] mixture = { 40, 60, 20 };
		long start = System.currentTimeMillis();
		// System.out.println(fibonacciTd(n, new int[n + 1]));
		// System.out.println(fibonacciBUSE(n));
		// System.out.println(BoardPathTD(0, n, new int[n + 1]));
		// System.out.println(BoardPathBUSE(n));
		// System.out.println(mazepathDTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazepathDBUSE(n, n));
		// System.out.println(LCS("abcd", "agcfd"));
		// System.out.println(LCS_BU("abcd", "agcfd"));
		// System.out.println(converts2tos1("abcd", "agcfd"));
		// System.out.println(EditDistanceBU("abcd", "agcfd"));
		// System.out.println(MCM(arr, 0, arr.length - 1));
		// System.out.println(MCMTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));
		// System.out.println(wineproblem(price, 0, price.length - 1, 1));
		// System.out.println(wineproblemTD(price, 0, price.length - 1, new
		// int[price.length][price.length]));
		// System.out.println(wineproblemBU(price));
		// System.out.println(knapSack(weight, price, 0, cap));
		// System.out.println(knapSackTD(weight, price, 0, cap, new
		// int[price.length][cap + 1]));
		// System.out.println(knapSackBU(weight, price, cap));
		// System.out.println(RodCutting(prices, prices.length - 1));
		// System.out.println(RodCuttingTD(prices, prices.length - 1, new
		// int[prices.length]));
		// System.out.println(RodCuttingBU(prices, prices.length - 1));
		System.out.println(HarryPottermixtures(mixture, 0, mixture.length - 1));
		System.out.println(
				HarryPottermixturesTD(mixture, 0, mixture.length - 1, new int[mixture.length][mixture.length]));
		System.out.println(HarryPottermixturesBU(mixture));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	// fibonacci Top Down
	public static int fibonacciTd(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}
		int fnm1 = fibonacciTd(n - 1, strg);
		int fnm2 = fibonacciTd(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn;

		return fn;
	}

	// fibonacci Bottom Up
	public static int fibonacciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	// fibonacci Bottom Up space efficient
	public static int fibonacciBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i < n; i++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}

		return strg[1];
	}

	public static int BoardPathTD(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;
		for (int dice = 1; dice <= 6 && curr + dice <= end; dice++) {
			count += BoardPathTD(curr + dice, end, strg);
		}
		strg[curr] = count;
		return count;
	}

	public static int BoardPathBU(int n) {
		int[] strg = new int[n + 6];

		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= 6; j++) {
				strg[i] += strg[i + j];
			}
		}

		return strg[0];
	}

	public static int BoardPathBUSE(int n) {
		int[] strg = new int[6];
		int sum = 0;
		strg[0] = 1;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j <= 5; j++) {
				sum += strg[j];
			}
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;

		}
		return strg[0];
	}

	public static int mazepathTD(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int ch = mazepathTD(cr, cc + 1, er, ec, strg);
		int cv = mazepathTD(cr + 1, cc, er, ec, strg);
		strg[cr][cc] = cv + ch;

		return ch + cv;
	}

	public static int mazepathBU(int er, int ec) {

		int[][] strg = new int[er + 1][ec + 1];

		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg[0].length - 1; col >= 0; col--) {
				if (row == strg.length - 1 || col == strg[0].length - 1) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int mazepathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg.length - 1; col >= 0; col--) {
				if (row == strg.length - 1 || col == strg.length - 1) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}

		return strg[0];
	}

	public static int mazepathDTD(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int ch = mazepathDTD(cr, cc + 1, er, ec, strg);
		int cv = mazepathDTD(cr + 1, cc, er, ec, strg);
		int cd = mazepathDTD(cr + 1, cc + 1, er, ec, strg);
		strg[cr][cc] = cv + ch + cd;

		return ch + cv + cd;
	}

	public static int mazepathDBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];
		int diag = 0;

		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg.length - 1; col >= 0; col--) {
				if (row == strg.length - 1 || col == strg.length - 1) {
					strg[col] = 1;
					diag = 1;
				} else {
					int sum = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = sum;
				}
			}
		}

		return strg[0];
	}

	// length of Longest Common Sub Sequence
	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			// +1 in case of equality
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);
		}

		return ans;
	}

	public static int LCS_BU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg[0].length - 1; col >= 0; col--) {
				if (row == strg.length - 1 || col == strg[0].length - 1) {
					strg[row][col] = 0;
				} else {
					if (s1.charAt(row) == s2.charAt(col)) {
						int diag = strg[row + 1][col + 1];
						strg[row][col] = diag + 1;
					} else {
						int max = Math.max(strg[row + 1][col], strg[row][col + 1]);
						strg[row][col] = max;
					}
				}
			}
		}

		return strg[0][0];
	}

	// convert string 2 to 1 in minimum operations....EditDistance
	public static int converts2tos1(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = converts2tos1(ros1, ros2);
		} else {
			// insert, delete, replace
			int d = converts2tos1(s1, ros2);
			int i = converts2tos1(ros1, s2);
			int r = converts2tos1(ros1, ros2);

			ans = Math.min(r, Math.min(d, i)) + 1;
		}

		return ans;
	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
				} else if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
				} else {
					if (s1.charAt(row) == s2.charAt(col)) {
						strg[row][col] = strg[row + 1][col + 1];
					} else {
						int i = strg[row + 1][col];
						int d = strg[row][col + 1];
						int r = strg[row + 1][col + 1];

						strg[row][col] = Math.min(r, Math.min(i, d)) + 1;
					}
				}
			}
		}
		return strg[0][0];
	}

	// minimum multiplication of matrices
	public static int MCM(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		// ei - 1 due to arr.length-2 calls
		for (int i = si + 1; i <= ei - 1; i++) {

			// first and second part
			int fp = MCM(arr, si, i);
			int sp = MCM(arr, i, ei);

			// self work....two matrix of order(a*b)&(b*c) multiplications a*b*c
			int sw = arr[si] * arr[i] * arr[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
		}
		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;
		// ei - 1 due to arr.length-2 calls
		for (int i = si + 1; i <= ei - 1; i++) {

			// first and second part
			int fp = MCMTD(arr, si, i, strg);
			int sp = MCMTD(arr, i, ei, strg);

			// self work....two matrix of order(a*b)&(b*c) multiplications a*b*c
			int sw = arr[si] * arr[i] * arr[ei];

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}

			strg[si][ei] = min;
		}
		return min;
	}

	public static int MCMBU(int[] arr) {
		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide < n; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				if (si + 1 == ei) {
					strg[si][ei] = 0;
					continue;
				}

				int min = Integer.MAX_VALUE;

				for (int i = si + 1; i <= ei - 1; i++) {

					int fp = strg[si][i];
					int sp = strg[i][ei];
					int sw = arr[si] * arr[i] * arr[ei];

					int sum = fp + sp + sw;

					if (sum < min) {
						min = sum;
					}

					strg[si][ei] = min;
				}
			}
		}
		return strg[0][n - 1];

	}

	// max profit by selling wines form beg or end
	public static int wineproblem(int[] price, int si, int ei, int yr) {

		if (si == ei) {
			return price[si] * yr;
		}
		int fc = wineproblem(price, si + 1, ei, yr + 1) + price[si] * yr;
		int sc = wineproblem(price, si, ei - 1, yr + 1) + price[ei] * yr;

		int ans = Math.max(fc, sc);

		return ans;
	}

	public static int wineproblemTD(int[] price, int si, int ei, int[][] strg) {

		int n = price.length;
		int yr = n - (ei - si);
		if (si == ei) {
			return price[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int fc = wineproblemTD(price, si + 1, ei, strg) + price[si] * yr;
		int sc = wineproblemTD(price, si, ei - 1, strg) + price[ei] * yr;

		int ans = Math.max(fc, sc);

		strg[si][ei] = ans;
		return ans;
	}

	public static int wineproblemBU(int[] price) {

		int n = price.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n; slide++) {
			for (int si = 0; si <= n - slide; si++) {

				int ei = si + slide - 1;
				int yr = n - (ei - si);

				if (si == ei) {
					strg[si][ei] = price[si] * yr;
				} else {

					int fc = strg[si + 1][ei] + price[si] * yr;
					int sc = strg[si][ei - 1] + price[ei] * yr;

					int ans = Math.max(fc, sc);

					strg[si][ei] = ans;
				}
			}
		}
		return strg[0][n - 1];
	}

	public static int knapSack(int[] weight, int[] price, int vidx, int cap) {

		if (vidx == weight.length) {
			return 0;
		}
		int include = 0;

		if (cap >= weight[vidx]) {
			include = knapSack(weight, price, vidx + 1, cap - weight[vidx]) + price[vidx];
		}

		int exclude = knapSack(weight, price, vidx + 1, cap);

		int ans = Math.max(include, exclude);

		return ans;
	}

	public static int knapSackTD(int[] weight, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == weight.length) {
			return 0;
		}
		int include = 0;

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}
		if (cap >= weight[vidx]) {
			include = knapSackTD(weight, price, vidx + 1, cap - weight[vidx], strg) + price[vidx];
		}

		int exclude = knapSackTD(weight, price, vidx + 1, cap, strg);

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;
		return ans;
	}

	public static int knapSackBU(int[] weight, int[] price, int cap) {

		int nr = price.length + 1;
		int nc = cap + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 0; row < nr; row++) {
			for (int col = 0; col < nc; col++) {
				if (row == 0 || col == 0) {
					strg[row][col] = 0;
				} else {
					int include = 0;

					if (col >= weight[row - 1]) {
						include = price[row - 1] + strg[row - 1][col - weight[row - 1]];
					}

					int exclude = strg[row - 1][col];

					int ans = Math.max(include, exclude);

					strg[row][col] = ans;
				}
			}
		}
		return strg[nr - 1][nc - 1];
	}

	public static int RodCutting(int[] prices, int n) {

		if (n == 0) {
			return 0;
		}
		int max = prices[n];

		int left = 1;
		int right = n - 1;

		while (left <= right) {
			int fh = RodCutting(prices, left);
			int sh = RodCutting(prices, right);

			int ans = fh + sh;

			if (max < ans) {
				max = ans;
			}

			left++;
			right--;
		}
		return max;
	}

	public static int RodCuttingTD(int[] prices, int n, int[] strg) {

		if (n == 0) {
			return 0;
		}
		int max = prices[n];

		int left = 1;
		int right = n - 1;

		if (strg[n] != 0) {
			return strg[n];
		}
		while (left <= right) {
			int fh = RodCuttingTD(prices, left, strg);
			int sh = RodCuttingTD(prices, right, strg);

			int ans = fh + sh;

			if (max < ans) {
				max = ans;
			}
			strg[n] = max;
			left++;
			right--;
		}
		return max;
	}

	public static int RodCuttingBU(int[] prices, int n) {

		int[] strg = new int[prices.length];

		for (int i = 1; i <= n; i++) {
			int max = prices[i];
			strg[i] = max;
			int left = 1;
			int right = i - 1;

			while (left <= right) {
				int fh = strg[left];
				int sh = strg[right];

				int ans = fh + sh;

				if (max < ans) {
					max = ans;
				}
				strg[i] = max;
				left++;
				right--;
			}
		}
		return strg[n];
	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;

		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}

	public static int HarryPottermixtures(int[] mixture, int si, int ei) {

		if (si == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = HarryPottermixtures(mixture, si, k);
			int sp = HarryPottermixtures(mixture, k + 1, ei);

			// self work.
			int sw = color(mixture, si, k) * color(mixture, k + 1, ei);

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
		}
		return min;
	}

	public static int HarryPottermixturesTD(int[] mixture, int si, int ei, int[][] strg) {

		if (si == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		for (int k = si; k <= ei - 1; k++) {

			int fp = HarryPottermixturesTD(mixture, si, k, strg);
			int sp = HarryPottermixturesTD(mixture, k + 1, ei, strg);

			// self work.
			int sw = color(mixture, si, k) * color(mixture, k + 1, ei);

			int sum = fp + sp + sw;

			if (sum < min) {
				min = sum;
			}
			strg[si][ei] = min;
		}
		return min;
	}

	public static int HarryPottermixturesBU(int[] mixture) {

		int n = mixture.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				if (si == ei) {
					strg[si][ei] = 0;
					continue;
				}

				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k + 1][ei];

					int sw = color(mixture, si, k) * color(mixture, k + 1, ei);

					int sum = fp + sp + sw;

					if (sum < min) {
						min = sum;
					}
					strg[si][ei] = min;
				}
			}
		}
		return strg[0][n - 1];
	}

}