package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Rishabh
 * 
 * @date 01-Jul-2018
 */

public class HashMapOps {

	public static void main(String[] args) {

		// maxFreqChar("aaabbddddsssssssssss");
		int[] arr1 = { 10, 20, 30, 40, 50, 60 };
		int[] arr2 = { 20, 40, 90 };
		intesrsection(arr1, arr2);
//		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		// largestconsecutive(arr);

	}

	public static void maxFreqChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (map.containsKey(ch)) {
				int of = map.get(ch);			//old frequency
				int nf = of + 1;				//new frequency
				map.put(ch, nf);
			} else {
				map.put(ch, 1);
			}
		}

		ArrayList<Character> list = new ArrayList<>(map.keySet());

		int maxfreq = 0;
		char maxchar = ' ';

		for (Character ch : list) {

			int pfreq = map.get(ch);
			if (pfreq > maxfreq) {
				maxfreq = pfreq;
				maxchar = ch;
			}
		}

		System.out.println(maxfreq);
		System.out.println(maxchar);

	}

	public static void intesrsection(int[] arr1, int[] arr2) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {

			int val = arr1[i];

			if (map.containsKey(val)) {
				int of = map.get(val);
				int nf = of + 1;
				map.put(val, nf);
			} else {
				map.put(val, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr2.length; i++) {

			int val = arr2[i];

			if (map.containsKey(val) && map.get(val) > 0) {

				list.add(val);
				map.put(val, map.get(val) - 1);
			}

		}

		System.out.println(list);
	}

	public static void largestconsecutive(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}
		}

		int maxcount = 0;
		int starting = 0;

		for (int key : map.keySet()) {
			int count = 0;

			if (map.get(key)) {

				while (map.containsKey(key + count)) {
					count++;
				}
			}

			if (count > maxcount) {
				maxcount = count;
				starting = key;
			}

		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = starting; i < starting + maxcount; i++) {
			ans.add(i);
		}

		System.out.println(ans);
	}
}
