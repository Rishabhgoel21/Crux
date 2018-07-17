package HashMap;

import java.util.ArrayList;

/**
 * @author Rishabh
 * 
 * @date 03-Jul-2018
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();
		heap.add(10);
		heap.add(200);
		heap.add(60);
		heap.add(230);
		heap.add(50);
		heap.add(90);
		heap.add(111);
		heap.add(222);
		heap.add(66);
		heap.add(35);
		heap.add(5);
		heap.add(9);

		// System.out.println(heap.getmax());
		// System.out.println(heap.getmin());

		 int size = heap.size();
		 for (int i = 0; i < size; i++) {
		 System.out.println(heap.remove());
		 }
	}
 }
