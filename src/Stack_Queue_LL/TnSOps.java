package Stack_Queue_LL;

/**
 * @author Rishabh
 */
import java.util.Arrays;

public class TnSOps { // time and space complexity operations

	public static void main(String[] args) {

		// System.out.println(polynomial(3, 7));
		// System.out.println(power(2, 9));
		// System.out.println(countSS("nittin"));
		// PrintPrimes(29);
		// int[] arr = { 120, 20, 40, 10, 60, 50 };
		// int[] sorted = mergesort(arr, 0, arr.length - 1);

		// Quicksort(arr, 0, arr.length - 1);
		// for (int val : arr) {
		// System.out.print(val + " ");
		// }

		// int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0
		// }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		// { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0,
		// 9, 0, 6, 0, 0 },
		// { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2,
		// 0, 6, 3, 0, 0 } };

		boolean[][] board = new boolean[3][3];
		// NQueen(0, board, "");
		nknights(board, 0, 0, "", 0);
		// sudukoSolver(board, 0, 0);

	}

	// 1*(x^n) + 2*(x^n-1) + 3*(x^n-2) + -----------
	public static int polynomial(int x, int n) {
		int sum = 0;
		int multiplier = x;
		for (int i = n; i >= 1; i--) {
			sum += i * multiplier;
			multiplier *= x;
		}
		return sum;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int sp = power(x, n / 2);
		if (n % 2 == 0) {
			return sp * sp;
		} else {

			return sp * sp * x;
		}
	}

	public static int countSS(String str) {

		int count = 0;

		// ODD LENGTH
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}
		}
		// EVEN LENGTH
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}

	public static void PrintPrimes(int n) {

		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; (table * table <= n); table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}

		}

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}

	public static int[] mergetwosortedarrays(int[] one, int[] two) {

		int[] sorted = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				sorted[k] = one[i];
				i++;
				k++;
			} else {
				sorted[k] = two[j];
				j++;
				k++;
			}
		}
		if (i == one.length) {
			while (j < two.length) {
				sorted[k] = two[j];
				j++;
				k++;
			}
		}
		if (j == two.length) {
			while (i < one.length) {
				sorted[k] = one[i];
				i++;
				k++;
			}
		}
		return sorted;
	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergesort(arr, lo, mid); // first half
		int[] sh = mergesort(arr, mid + 1, hi);

		int[] sorted = mergetwosortedarrays(fh, sh);
		return sorted;
	}

	public static void Quicksort(int[] arr, int lo, int hi) {

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		Quicksort(arr, lo, right);
		Quicksort(arr, left, hi);

	}

	public static void NQueen(int row, boolean[][] board, String asf) {

		if (row == board.length) {
			System.out.println(asf);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {

			if (isitsafequeen(board, row, col) == true) {
				board[row][col] = true;
				NQueen(row + 1, board, asf + "{" + row + " - " + col + "}");
				board[row][col] = false;
			}
		}

	}

	public static boolean isitsafequeen(boolean[][] board, int row, int col) {
		int r = row - 1;
		int c = col;

		// check vertically up
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
		}

		r = row - 1;
		c = col - 1;
		// check diagonally left
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

		r = row - 1;
		c = col + 1;
		// check diagonally right
		while (r >= 0 && c < board[0].length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		return true;

	}

	public static void nknights(boolean[][] board, int row, int col, String asf, int kpsf) {

		if (kpsf == board.length) {
			System.out.println(asf);
			return;
		}

		for (int c = col; c < board[0].length; c++) {

			if (isitsafeknight(board, row, col) == true) {
			board[row][c] = true;
			nknights(board, row, c + 1, asf + "{" + row + "-" + c + "}", kpsf + 1);
			board[row][c] = false;

		}
		}
		for (int r = row + 1; r < board.length; r++) {

			if (isitsafeknight(board, row, col) == true) {
			for (int c = 0; c < board[0].length; c++) {
				board[r][c] = true;
				nknights(board, r, c + 1, asf + "{" + r + "-" + c + "}", kpsf + 1);
				board[r][c] = false;
			}
		}}
	}

	public static boolean isitsafeknight(boolean[][] board, int row, int col) {
		int r = row - 1;
		int c1 = col - 2;
		int c2 = col + 2;
		if (r >= 0 && c1 >= 0) {
			if (board[r][c1] == true) {
				return false;

			}
		}
		r = row - 1;
		if (r >= 0 && c2 < board[0].length) {

			if (board[r][c2] == true) {
				return false;
			}

		}
		r = row - 2;
		c1 = col - 1;
		c2 = col + 1;
		if (r >= 0 && c1 >= 0) {

			if (board[r][c1] == true) {
				return false;
			}
		}

		r = row - 2;
		if (r >= 0 && c2 < board[0].length) {
			if (board[r][c2] == true) {
				return false;
			}
		}

		return true;

	}

	public static boolean sudukoSolver(int[][] board, int row, int col) {

		if (row == board.length) {

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + " ");
				}

				System.out.println();
			}
			System.out.println();
			return true;
		}

		if (col == board[0].length) {
			return sudukoSolver(board, row + 1, 0);
		}

		if (board[row][col] != 0) {
			return sudukoSolver(board, row, col + 1);
		}

		for (int num = 1; num <= 9; num++) {

			if (isItSafe(board, row, col, num)) {
				board[row][col] = num;
				boolean res = sudukoSolver(board, row, col + 1);

				if (res) {
					return true;
				}

				board[row][col] = 0;
			}

		}

		return false;
	}

	public static boolean isItSafe(int[][] board, int row, int col, int num) {

		return isItSafeRow(board, row, num) && isItSafeCol(board, col, num) && isItSafeGrid(board, row, col, num);
	}

	public static boolean isItSafeRow(int[][] board, int row, int num) {

		for (int col = 0; col < board[0].length; col++) {

			if (board[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCol(int[][] board, int col, int num) {

		for (int row = 0; row < board.length; row++) {

			if (board[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeGrid(int[][] board, int row, int col, int num) {

		int rsp = row - (row % 3);
		int csp = col - (col % 3);

		for (int r = rsp; r < rsp + 3; r++) {
			for (int c = csp; c < csp + 3; c++) {

				if (board[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}

}