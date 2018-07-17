package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Rishabh
 * 
 * @date 27-Jun-2018
 */

public class BinaryTree {

	public static int max_level = 0;
	Scanner scn;

	private class Node {

		int data;
		Node left;
		Node right;

	}

	private Node root;

	public BinaryTree(String str) {
		scn = new Scanner(str);
		this.root = takeinput(null, false);
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = Construct1(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	// construct tree using pre order and in order
	private Node Construct1(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (nn.data == in[i]) {
				si = i;
			}
		}
		int nel = si - ilo; // no. of elements

		nn.left = Construct1(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = Construct1(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;

	}

	// construct tree using post order and in order
	private Node Construct2(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node nn = new Node();
		nn.data = post[phi];

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (nn.data == in[i]) {
				si = i;
				break;
			}
		}
		int nel = si - ilo; // no. of elements

		nn.left = Construct2(post, plo, plo + nel - 1, in, ilo, si - 1);
		nn.right = Construct2(post, plo + nel, phi - 1, in, si + 1, ihi);

		return nn;

	}

	// parent left/right child
	private Node takeinput(Node parent, boolean ilc) {

		// give prompt to user
		if (parent == null) {
			System.out.println("Enter the data for root Node ?");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child : ");
			} else {
				System.out.println("Enter the data for right child : ");
			}
		}

		int item = scn.nextInt(); // item input
		Node nn = new Node(); // make a new Node
		nn.data = item;

		System.out.println(nn.data + "has left child ?");
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			nn.left = takeinput(nn, true);
		}

		System.out.println(nn.data + "has right child ?");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			nn.right = takeinput(nn, false);
		}

		return nn;
	}

	public void display() {

		System.out.println("-------------");
		display(this.root);
		System.out.println("-------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		int ans = Math.max(node.data, Math.max(lm, rm));

		return ans;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left); // left diameter
		int rd = diameter(node.right); // right diameter
		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));

	}

	private class Pair {
		int diameter;
		int height;
	}

	public int diameter2() {
		return diameter2(this.root).diameter; // returns diameter
	}

	private Pair diameter2(Node node) {

		if (node == null) {
			Pair bp = new Pair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}
		Pair lp = diameter2(node.left);
		Pair rp = diameter2(node.right);
		Pair sp = new Pair();
		sp.height = Math.max(lp.height, rp.height) + 1;

		int spd = lp.height + rp.height + 2;
		sp.diameter = Math.max(spd, Math.max(lp.diameter, rp.diameter));

		return sp;

	}

	private class Bpair {
		int height;
		boolean isbalanced;
	}

	public boolean treebalanced() {
		return treebalanced(this.root).isbalanced;
	}

	private Bpair treebalanced(Node node) {

		if (node == null) {
			Bpair bp = new Bpair();
			bp.height = -1;
			bp.isbalanced = true;
			return bp;
		}
		Bpair lp = treebalanced(node.left);
		Bpair rp = treebalanced(node.right);
		Bpair sp = new Bpair();
		sp.height = Math.max(lp.height, rp.height) + 1;
		int isbalanced = lp.height - rp.height;

		if (lp.isbalanced && rp.isbalanced && isbalanced >= -1 && isbalanced <= 1) {
			sp.isbalanced = true;
		} else {
			sp.isbalanced = false;
		}
		return sp;

	}

	public void preorder() {
		preorder(this.root);
	}

	// Recursively
	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);

		preorder(node.left);
		preorder(node.right);
	}

	private class OrderPair {
		Node node;
		boolean selfDone;
		boolean leftDone;
		boolean rightDone;
	}

	// Iteratively
	public void preorderI() {

		LinkedList<OrderPair> stack = new LinkedList<>();
		OrderPair sp = new OrderPair();
		sp.node = this.root;
		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			OrderPair tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}

			if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else if (tp.leftDone == false) {
				OrderPair np = new OrderPair();
				np.node = tp.node.left;
				tp.leftDone = true;
				stack.addFirst(np);
			} else if (tp.rightDone == false) {
				OrderPair np = new OrderPair();
				np.node = tp.node.right;
				tp.rightDone = true;
				stack.addFirst(np);
			} else {
				stack.removeFirst();
			}
		}
	}

	public class BSTpair {
		Node largestBSTnode;
		int size;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isBST = true;
	}

	public void largestBST() {
		BSTpair pair = largestBST(this.root);
		System.out.println(pair.largestBSTnode.data);
		System.out.println(pair.size);
	}

	private BSTpair largestBST(Node node) {
		if (node == null) {
			BSTpair bp = new BSTpair();
			return bp;
		}
		// left, right and self pair
		BSTpair lp = largestBST(node.left);
		BSTpair rp = largestBST(node.right);

		BSTpair sp = new BSTpair();

		sp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min = Math.max(node.data, Math.max(lp.min, rp.min));

		if (lp.isBST && sp.isBST && node.data > lp.max && node.data < rp.min) {
			sp.largestBSTnode = node;
			sp.isBST = true;
			sp.size = lp.size + rp.size + 1;
		} else {
			sp.isBST = false;
			if (lp.size > rp.size) {
				sp.largestBSTnode = lp.largestBSTnode;
				sp.size = lp.size;
			} else {
				sp.largestBSTnode = rp.largestBSTnode;
				sp.size = rp.size;
			}
		}
		return sp;
	}

	public int sumOfNodes() {
		return this.sumOfNodes(this.root);
	}

	private int sumOfNodes(Node node) {
		if (node == null) {
			return 0;
		} else {
			return (node.data + sumOfNodes(node.left) + sumOfNodes(node.right));
		}
	}

	public void removeLeaves() {
		display(this.removeLeaves(null, this.root));
	}

	private Node removeLeaves(Node parent, Node node) {
		if (node == null) {
			return null;
		}

		if (node.left == null && node.right == null) {
			return null;
		}

		node.left = removeLeaves(node, node.left);
		node.right = removeLeaves(node, node.right);

		return node;
	}

	private void printAtlevel(Node node, int level, int height) {
		if (node == null) {
			return;
		}

		if (level == height) {
			System.out.print(node.data + " ");
			return;
		}
		printAtlevel(node.left, level + 1, height);
		printAtlevel(node.right, level + 1, height);

	}

	public void levelorderlwrec() {
		for (int i = 0; i <= this.ht(); i++) {
			printAtlevel(this.root, 0, i);
			System.out.println();
		}
	}

	public void levelorderzz() {
		levelorderzz(this.root);
	}

	private void levelorderzz(Node node) {

		if (node == null) {
			return;
		}

		LinkedList<Node> currentLevel = new LinkedList<>();
		LinkedList<Node> nextLevel = new LinkedList<>();

		currentLevel.addFirst(node);
		boolean leftToRight = true;

		while (!currentLevel.isEmpty()) {

			Node nn = currentLevel.pop();

			System.out.print(nn.data + " ");

			// checking level wise like left to right for odd levels
			if (leftToRight) {
				if (nn.left != null) {
					nextLevel.push(nn.left);
				}

				if (nn.right != null) {
					nextLevel.push(nn.right);
				}
			}
			// right to left otherwise
			else {
				if (nn.right != null) {
					nextLevel.push(nn.right);
				}

				if (nn.left != null) {
					nextLevel.push(nn.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				LinkedList<Node> temp = new LinkedList<>();
				temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}

	public boolean identicalTrees(BinaryTree other) {
		return identicalTrees(this.root, other.root);
	}

	private boolean identicalTrees(Node node, Node other) {

		if (node == null && other == null) {
			return true;
		}

		if (node != null && other != null) {
			// to compare data also
			// return (node.data == other.data && identicalTrees(node.left, other.left) &&
			// identicalTrees(node.right, other.right));
			return (identicalTrees(node.left, other.left) && identicalTrees(node.right, other.right));
		}

		return false;
	}

	public void buildFromLevelorder() {

		Scanner scn = new Scanner(System.in);

		// LL as Queue
		LinkedList<Node> list = new LinkedList<>();

		int x = scn.nextInt();

		Node nn = new Node();

		nn.data = x;

		this.root = nn; // creating root node

		list.addLast(nn);

		while (!list.isEmpty()) {

			// removing root node
			Node rn = list.removeFirst();

			if (rn != null) {

				// creating left child node
				int temp1 = scn.nextInt();
				if (temp1 != -1) {

					Node ln = new Node();

					ln.data = temp1;

					rn.left = ln;

					list.addLast(ln);
				}

				// creating right child node
				int temp2 = scn.nextInt();

				if (temp2 != -1) {

					Node ln = new Node();

					ln.data = temp2;

					rn.right = ln;

					list.addLast(ln);
				}
			}
		}
	}

	public void printallleafnodes() {
		printallleafnodes(this.root);
	}

	private void printallleafnodes(Node node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}

		printallleafnodes(node.left);
		printallleafnodes(node.right);

	}

	public void leftview() {
		leftview(this.root, 1);
	}

	private void leftview(Node node, int level) {

		if (node == null) {
			return;
		}

		if (max_level < level) {
			System.out.print(node.data + " ");
			max_level = level;
		}

		// Recursive call for left and right subtrees
		leftview(node.left, level + 1);
		leftview(node.right, level + 1);

	}

	public void rightview() {
		rightview(this.root, 1);
	}

	private void rightview(Node node, int level) {

		if (node == null) {
			return;
		}

		if (max_level < level) {
			System.out.print(node.data + " ");
			max_level = level;
		}

		// Recursive call for left and right subtrees
		rightview(node.right, level + 1);
		rightview(node.left, level + 1);
	}

	private TreeMap<Integer, Node> map = new TreeMap<>(); // for Top bottom view

	public void topView() {

		topView(this.root, 0);

		while (map.size() != 0) {

			int key = map.firstKey();

			System.out.print(map.get(key).data + " ");

			map.remove(key);
		}
	}

	private void topView(Node node, int hd) {

		if (node == null) {
			return;
		}

		if (!map.containsKey(hd)) {
			map.put(hd, node);
		}

		topView(node.left, hd - 1);
		topView(node.right, hd + 1);
	}

	// not done bottom view
	public void bottomView() {

		bottomView(this.root, 0);

		while (map.size() != 0) {

			int key = map.firstKey();

			System.out.print(map.get(key).data + " ");

			map.remove(key);
		}
	}

	private void bottomView(Node node, int hd) {

		if (node == null) {
			return;
		}

		if (!map.containsKey(hd)) {
			map.put(hd, node);
		}

		bottomView(node.left, hd - 1);
		bottomView(node.right, hd + 1);
	}

	// array list of levels
	public void printLevelOrder() {
		printLevelOrder(this.root);
	}

	private void printLevelOrder(Node root) {

		if (root == null) {
			return;
		}

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<Node>();

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		// Enqueue Root and initialize height
		q.add(root);

		while (true) {

			// nodeCount(queue size)indicates number of nodes at current level.
			int nodeCount = q.size();
			if (nodeCount == 0) {
				break;
			}

			ArrayList<Integer> list = new ArrayList<>();

			// Dequeue all nodes of current level in list and
			// Enqueue all nodes of next level
			while (nodeCount > 0) {
				Node node = q.peek();
				list.add(node.data);
				q.remove();

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);

				nodeCount--;
			}
			ans.add(list);
		}
		System.out.println(ans);
	}

	public void sibling() {
		sibling(this.root);
	}

	private void sibling(Node node) {
		if (node == null) {
			return;
		}

		// when both child are present
		if (node.left != null && node.right != null) {
			sibling(node.left);
			sibling(node.right);
		}

		// If left child is NULL and right is not null
		else if (node.right != null) {
			System.out.print(node.right.data + " ");
			sibling(node.right);
		}

		// If right child is NULL and left is not null
		else if (node.left != null) {
			System.out.print(node.left.data + " ");
			sibling(node.left);
		}
	}

	// Lowest common Ancestor
	public int findLCA(int n1, int n2) {
		return findLCA(root, n1, n2).data;
	}

	private Node findLCA(Node node, int n1, int n2) {

		if (node == null)
			return null;

		if (node.data == n1 || node.data == n2)
			return node;

		Node left_lca = findLCA(node.left, n1, n2);
		Node right_lca = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	// print all root to leaf path with sum equal to given number
	public void root2leaf(int n) {
		Stack<Integer> s = new Stack<>();
		root2leaf(this.root, n, 0, s);
	}

	private void root2leaf(Node node, int sum, int sumsofar, Stack<Integer> path) {

		if (node == null) {
			return;
		}

		sumsofar += node.data;

		path.add(node.data);

		if (sumsofar == sum) {
			for (int i = 0; i < path.size(); i++)
				System.out.print(path.get(i) + " ");
		}

		// if left child exists
		if (node.left != null) {
			root2leaf(node.left, sum, sumsofar, path);
		}
		// if right child exists
		if (node.left != null) {
			root2leaf(node.right, sum, sumsofar, path);
		}

		// Remove last element from path and move back to parent
		path.pop();
	}
}