package GenericTree;
/**
 * @author Rishabh
 * 
 * @date 24-Jun-2018
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree(String str) {
		scn = new Scanner(str);
		this.root = takeinput(null, -1);
	}

	private Node takeinput(Node parent, int ith) {

		// give prompt to user
		if (parent == null) {
			System.out.println("Enter the data for root Node ?");
		} else {
			System.out.println("Enter the data for " + ith + " of " + parent.data + " ?");
		}

		int item = scn.nextInt(); // item input
		Node nn = new Node(); // make a new Node
		nn.data = item;

		System.out.println("Enter the no. of children for " + nn.data);

		int noc = scn.nextInt(); // no. of children for parent

		for (int i = 0; i < noc; i++) {
			nn.children.add(takeinput(nn, i));

		}

		return nn;
	}

	public void display() {

		display(this.root);
	}

	private void display(Node node) {

		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		System.out.println(str);

		// recursive call
		for (Node child : node.children) {
			display(child);
		}

	}

	public void size() {

		System.out.println(size(this.root));
	}

	private int size(Node node) {

		int count = 0;
		for (Node child : node.children) {
			count += size(child);
		}

		return count + 1;

	}

	public int max() {

		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public void finditem(int item) {
		System.out.println(finditem(this.root, item));
	}

	private boolean finditem(Node node, int item) {

		if (node.data == item) {
			return true;
		}
		for (Node child : node.children) {
			boolean cf = finditem(child, item);
			if (cf) {
				return true;
			}
		}
		return false;
	}

	// tree branches
	public int height() {

		return height(this.root);
	}

	private int height(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = height(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public void mirror() {

		mirror(this.root);
	}

	private void mirror(Node node) {

		// recursive call
		for (Node child : node.children) {
			mirror(child);
		}

		// self work
		int left = 0;
		int right = node.children.size() - 1;

		while (left < right) {
			Node ln = node.children.get(left);
			Node rn = node.children.get(right);

			// swap
			node.children.set(right, ln);
			node.children.set(left, rn);

			left++;
			right--;
		}
	}

	private void mirrorAlternative(Node node) {

		// smaller problem
		for (Node child : node.children) {
			mirrorAlternative(child);
		}

		// self work
		ArrayList<Node> list = new ArrayList<>();

		for (int i = node.children.size() - 1; i >= 0; i--) {
			list.add(node.children.get(i));
		}

		node.children = list;

	}

	public void preorder() {
		preorder(this.root);

	}

	private void preorder(Node node) {
		// printing parent first and then child
		System.out.println(node.data);

		// recursive call
		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		// recursive call
		for (Node child : node.children) {
			postorder(child);
		}
		// printing child first and then parent
		System.out.println(node.data);

	}

	public void traversal() {
		traversal(this.root);
	}

	private void traversal(Node node) {

		System.out.println("hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {
			System.out.println("going towards " + node.children.get(i).data);
			traversal(node.children.get(i));
			System.out.println("coming from " + node.children.get(i).data);
		}

		System.out.println("bye " + node.data);

	}

	// recursively O(n*h)
	public void levelorderrec() {
		for (int i = 0; i <= this.height(); i++) {
			printAtlevel(this.root, 0, i);
			System.out.println();
		}
	}

	private void printAtlevel(Node node, int level, int height) {
		if (level == height) {
			System.out.print(node.data + " ");
			return;
		}
		for (Node child : node.children) {
			printAtlevel(child, level + 1, height);

		}
	}

	// iteratively O(n)
	public void levelorderiter() {

		// using Queue (LL as Queue)
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}
	}

	// recursively O(n*h)
	public void levelorderlwrec() {
		for (int i = 0; i <= this.height(); i++) {
			printAtlevel(this.root, 0, i);
			System.out.println();
		}
	}

	// level order line wise
	public void levelorderlw() {
		// using two Queue primary helper (LL as Queue)
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = helper;
				helper = new LinkedList<>();
			}
		}
	}

	// level order zig zag
	public void levelorderzz() {
		// using Queue and stack (LL as Queue)
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		int count = 0;
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				count++;
			}
		}
	}

	public void levelorderzz1() {

		int count = 0;
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> s = new LinkedList<>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}
			if (queue.isEmpty()) {
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
				count++;
			}

		}
	}

	public class HeapMover {
		int ht = 0;
		int size = 0; // no. of nodes
		boolean find = false;
		int max = Integer.MIN_VALUE;
		//// predecessor and Successor in pre order
		Node pred = null;
		Node succ = null;
		Node jl = null; // just larger

	}

	public void multisolver(int item) {
		HeapMover mover = new HeapMover();

		multisolver(mover, this.root, 0, item);

		System.out.println("Max : " + mover.max);
		System.out.println("Find : " + mover.find);
		System.out.println("Size : " + mover.size);
		System.out.println("Height : " + mover.ht);
		if (mover.find == true) {
			System.out.println("Predecessor : " + (mover.pred == null ? "Null" : mover.pred.data));
			System.out.println("Successor : " + (mover.succ == null ? "Null" : mover.succ.data));
		} else {

			System.out.println("Predecessor : Null");
			System.out.println("Successor : Null");

		}
		System.out.println("Just Larger : " + mover.jl.data);
	}

	private void multisolver(HeapMover mover, Node node, int level, int item) {

		mover.size++;

		if (mover.ht < level) {
			mover.ht = level;
		}

		// just larger
		if (node.data > item) {
			if (mover.jl == null || node.data < mover.jl.data) {
				mover.jl = node;
			}
		}
		// successor (order matters)
		if (mover.find == true && mover.succ == null) {
			mover.succ = node;
		}

		// find
		if (node.data == item) {
			mover.find = true;
		}

		// predecessor (order matters)
		if (mover.find == false) {
			mover.pred = node;
		}

		// max
		if (mover.max < node.data) {
			mover.max = node.data;
		}

		// recursive call
		for (Node child : node.children) {
			multisolver(mover, child, level + 1, item);
		}
	}

	public void isMirror(GenericTree other) {
		System.out.println(isMirror(this.root, other.root));
	}

	private boolean isMirror(Node tnode, Node onode) { // this node and other node
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {

			Node tn = tnode.children.get(i);
			Node on = onode.children.get(tnode.children.size() - 1 - i);

			boolean rr = isMirror(tn, on);

			if (rr == false) {
				return false;
			}

		}
		return true;
	}

	public int sumOfNodes() {
		return this.sumOfNodes(this.root, 0);
	}

	private int sumOfNodes(Node node, int sum) {
		sum = node.data;

		for (Node child : node.children) {
			sum += sumOfNodes(child, sum);
		}
		return sum;
	}

	public int justLargest(int n) {
		return justLargest(this.root, n);
	}

	private int justLargest(Node node, int n) {

		if (node == null) {
			return 0;
		}

		int justlargest = Integer.MAX_VALUE;

		for (Node child : node.children) {
			int cans = justLargest(child, n);

			// finded the max among all
			if (cans > n && cans < justlargest) {
				justlargest = cans;
			}
		}

		// returned the number that is just larger
		if (node.data > n && node.data < justlargest) {
			return node.data;
		}
		return justlargest;

	}

	public int countleafnodes() {
		return countleafnodes(this.root);
	}

	private int countleafnodes(Node node) {
		int count = 0;
		if (node == null) {
			return 0;
		}

		if (node.children.size() == 0) {
			return 1;
		}

		for (Node child : node.children) {
			count += countleafnodes(child);
		}

		return count;
	}

	public int secondLargest() {
		return secondLargest(this.root);
	}

	private int secondLargest(Node node) {

		int max = this.max();
		int max2 = node.data;

		for (Node child : node.children) {
			int cans = secondLargest(child);

			if (cans > max2 && cans < max) {
				max2 = cans;
			}
		}
		return max2;
	}

	// structurally similar
	public boolean identicalTrees(GenericTree other) {
		return identicalTrees(this.root, other.root);
	}

	private boolean identicalTrees(Node node, Node other) {

		if (node.children.size() != other.children.size()) {
			return false;
		}

		if (node.data != other.data) {
			return false;
		}

		boolean br = true;
		int i = 0;

		while (i < node.children.size()) {
			boolean b = identicalTrees(node.children.get(i), other.children.get(i));

			if (b == false) {
				br = b;
			}

			i++;
		}
		return br;
	}

	public void depthvalue() {
		for (int i = 0; i <= this.height(); i++) {
			depthvalue(this.root, 0, i);
		}
	}

	private void depthvalue(Node node, int level, int height) {
		if (level == height) {
			node.data = height;
			return;
		}
		for (Node child : node.children) {
			depthvalue(child, level + 1, height);

		}
	}

}