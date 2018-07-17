package Recursion;
/**
 * @author Rishabh
 */
public class recursion_demo {

	public static void main(String[] args) {

		// PDISkips(7);
		// int b = 10;
		// int c = 80;
		// int a = (b) + (b++) + (c);
		//
		// System.out.println(b);
		// System.out.println(a);

		// System.out.println(factorial(5));
		// System.out.println(power(2, 5));
		// System.out.println(fibonacci(5));
		int[] array = { 0, 20, 40, 60, 20, 50, 90 };
		// System.out.println(finditem(array, 0, 40));
		// System.out.println(finditemfromend(array, 0, 20));

//		System.out.println(maxval(array, 0));
		int[] ans = findallitem(array, 0, 20,0);
		for(int val : ans)
		{
			System.out.print(val+", ");
		}
	}

	public static void PD(int n) {

		if (n == 0) {
			return;
		}

		// self work
		System.out.println(n);

		// assumption
		PD(n - 1);
	}

	public static void PI(int n) {

		if (n == 0) {
			return;
		}

		PI(n - 1);

		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}
		System.out.println(n);

		PDI(n - 1);

		System.out.println(n);

	}

	public static void PDISkips(int n) {

		if (n == 0) {
			return;
		}
		if (n % 2 != 0)
			System.out.println(n);

		PDISkips(n - 1);

		if (n % 2 == 0)
			System.out.println(n);

	}

	public static int factorial(int n) {

		// base case
		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1);
		int fn = n * fnm1;

		return fn;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);
		int pn = x * pnm1;

		return pn;

	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);

		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;
	}

	public static void displayarr(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		System.out.print(arr[vidx] + " ");
		displayarr(arr, vidx + 1);
	}

	public static int maxval(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int max = maxval(arr, vidx + 1);
		if (arr[vidx] > max) {
			return arr[vidx];
		}
		return max;
	}

	public static int finditem(int[] arr, int vidx, int item) {
		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == item) {
			return vidx;

		}
		int fn = finditem(arr, vidx + 1, item);
		return fn;

	}

	public static int finditemfromend(int[] arr, int vidx, int item) {
		if (vidx == arr.length) {
			return -1;
		}
		int index = finditemfromend(arr, vidx + 1, item);

		if (arr[vidx] == item && index == -1) {
			return vidx;
		}

		return index;
	}

	public static int[] findallitem(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] br = new int[count];			//br = base result..vidx=virtual index
			return br;
		}

		if (arr[vidx] == item) {
			
			int[] rr = findallitem(arr, vidx + 1, item,count+1);
			rr[count] = vidx;
			return rr;

		}
		else
		{
			int[] rr = findallitem(arr, vidx + 1, item,count);			//rr=recursion result
			return rr;
		}
	}

}
