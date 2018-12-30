package CodeChef.Smackdown;

import java.util.*;
import java.lang.*;
import java.io.*;

class QUALPREL
{
    static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception
	{
		try{
		int t = scn.nextInt();
		int cases = 1;
		while (cases <= t) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] array = takeinput(n);
			Arrays.sort(array);
			rvereseArray(array, 0, n-1);

			System.out.println(qualifiedTeams(array, k));
			cases++;
		}
		} catch (Exception e) {
			return;
		}
	
	}
	
	public static void rvereseArray(int arr[], int start, int end) 
    { 
        int temp; 
        if (start >= end) 
            return; 
        temp = arr[start]; 
        arr[start] = arr[end]; 
        arr[end] = temp; 
        rvereseArray(arr, start+1, end-1); 
    } 

	private static int qualifiedTeams(int[] arr, int k) {

		int n = arr[k - 1];
		int count = 0;

		for (int i = k; i < n; i++) {
			if (n == arr[i]) {
				count++;
			} else {
				break;
			}
		}
		return count + k;
	}

	public static int[] takeinput(int n) {

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;
	}

}
