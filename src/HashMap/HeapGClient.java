package HashMap;

import java.util.ArrayList;

/**
 * @author Rishabh
 * 
 * @date 04-Jul-2018
 */

public class HeapGClient {
	public static void main(String[] args) {

		HeapGeneric<Integer> heapg = new HeapGeneric<>();

		heapg.add(100);
		heapg.add(11);
		heapg.add(250);
		heapg.add(1111);
		heapg.add(450);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			list.add(heapg.remove());
		}

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(20);
		list1.add(30);
		list1.add(41);
		list1.add(55);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(55);
		list2.add(76);
		list2.add(83);
		list2.add(95);
		list2.add(111);

		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(8);
		list3.add(23);
		list3.add(111);
		list3.add(244);
		list3.add(555);

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		// System.out.println(lists);
		// ArrayList<Integer> ans = klargestelement(list, 3);
		ArrayList<Integer> ans = mergeksortedlist(lists);
		System.out.println(ans);

	}

	public static class pair implements Comparable<pair> {

		int idx;
		int data;
		int listno;

		@Override
		public int compareTo(pair o) {

			return o.data - this.data;
		}

	}

	public static ArrayList<Integer> mergeksortedlist(ArrayList<ArrayList<Integer>> list) {

		HeapGeneric<pair> heap = new HeapGeneric<>();

		for (int i = 0; i < list.size(); i++) {
			pair np = new pair();
			np.data = list.get(i).get(0);
			np.idx = 0;
			np.listno = i;
			heap.add(np);
		}
		ArrayList<Integer> ans = new ArrayList<>();

		while (!heap.isempty()) {
			pair rp = heap.remove();
			ans.add(rp.data);
			rp.idx++;

			if (rp.idx < list.get(rp.listno).size()) {
				rp.data = list.get(rp.listno).get(rp.idx);
				heap.add(rp);
			}

		}

		return ans;

	}

	public static ArrayList<Integer> klargestelement(ArrayList<Integer> list, int k) {

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {
			int tp = list.get(i);

			if (tp > heap.getmin()) {
				heap.remove();
				heap.add(tp);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			ans.add(heap.remove());
		}

		return ans;
	}
}