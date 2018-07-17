package HashMap;

import java.util.HashMap;

/**
 * @author Rishabh
 * 
 * @date 04-Jul-2018
 */

public class HuffmanCoding {

	HashMap<Character, String> encoder = new HashMap<>();
	HashMap<String, Character> decoder = new HashMap<>();

	private class Node implements Comparable<Node> {

		char ch;
		int freq;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return o.freq - this.freq;
		}

		public Node(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

	public HuffmanCoding(String str) {

		// 1. Create a fmap
		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (fmap.containsKey(ch)) {
				int of = fmap.get(ch);
				int nf = of + 1;
				fmap.put(ch, nf);
			} else {
				fmap.put(ch, 1);
			}
		}

		// 2. make nodes and put in heap
		HeapGeneric<Node> heap = new HeapGeneric<>();

		for (char key : fmap.keySet()) {
			Node nn = new Node(key, fmap.get(key));
			heap.add(nn);
		}

		// 3.take out two nodes and merge them and put them back in heap
		while (heap.size() != 1) {
			Node one = heap.remove();
			Node two = heap.remove();

			Node merged = new Node('*', 0);
			merged.freq = one.freq + two.freq;

			merged.left = one;
			merged.right = two;
			heap.add(merged);
		}

		Node lp = heap.remove();
		fillencoderdecoder(lp, "");
		System.out.println(encoder);
		System.out.println(decoder);
	}

	private void fillencoderdecoder(Node node, String ans) {

		if (node.left == null && node.right == null) {

			encoder.put(node.ch, ans);
			decoder.put(ans, node.ch);
			return;
		}

		fillencoderdecoder(node.left, ans + "0");
		fillencoderdecoder(node.right, ans + "1");

	}

	public String encode(String str) {

		String ans = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			ans += encoder.get(ch);
		}
		return ans;
	}

	public String decode(String str) {

		String ans = "";
		String key = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			key += ch;
			if (decoder.containsKey(key)) {
				ans += decoder.get(key);
				key = "";
			}
		}
		return ans;
	}
}
