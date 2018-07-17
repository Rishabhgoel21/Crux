package BinaryTree;

/**
 * @author Rishabh
 * 
 * @date 30-Jun-2018
 */

// Binary Search Tree
public class BST {

	private class Node {

		int data;
		Node left;
		Node right;

		public Node() {
		}

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private Node root;

	public BST(int[] in) {
		this.root = Construct(in, 0, in.length - 1);
	}

	// construct Binary tree(BST) using in order
	private Node Construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}

		int mid = (ilo + ihi) / 2;
		Node nn = new Node();
		nn.data = in[mid];

		nn.left = Construct(in, ilo, mid - 1);
		nn.right = Construct(in, mid + 1, ihi);

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

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data > item) {
			return find(node.left, item);
		} else if (node.data < item) {
			return find(node.right, item);
		} else {
			return true;
		}
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

	// print numbers between lower and upper limit
	public void printinRange(int ll, int ul) {
		printinRange(this.root, ll, ul);
	}

	private void printinRange(Node node, int ll, int ul) {
		if (node == null) {
			return;
		}

		if (node.data < ll) {
			printinRange(node.right, ll, ul);
		} else if (node.data > ul) {
			printinRange(node.left, ll, ul);
		} else {
			printinRange(node.left, ll, ul);
			System.out.println(node.data);
			printinRange(node.right, ll, ul);
		}
	}

	public void printDec() {
		printDec(this.root);
	}

	private void printDec(Node node) {
		if (node == null) {
			return;
		}

		printDec(node.right);
		System.out.println(node.data);
		printDec(node.left);
	}

	public class Mover {
		int sum = 0;
	}

	public void replacewithSumofLarger() {
		Mover mover = new Mover();
		replacewithSumofLarger(mover, this.root);
	}

	private void replacewithSumofLarger(Mover mover, Node node) {
		if (node == null) {
			return;
		}

		replacewithSumofLarger(mover, node.right);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replacewithSumofLarger(mover, node.left);
	}

	public void remove(int item) {

		if (this.root.left != null && this.root.right == null) {
			this.root = this.root.left;
		} else if (this.root.left == null && this.root.right != null) {
			this.root = this.root.right;
		} else if (this.root.left == null && this.root.right == null) {
			return;
		} else {
			remove(this.root, null, item);
		}
	}

	private void remove(Node node, Node parent, int item) {

		if (item < node.data) {
			remove(node.left, node, item);
		} else if (item > node.data) {
			remove(node.right, node, item);
		} else {

			// 1st case
			if (node.left == null && node.right == null) {
				if (node.data < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			// 2nd Case
			else if (node.left != null && node.right == null) {
				if (node.data < parent.data) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}
			// 3rd Case
			else if (node.left == null && node.right != null) {
				if (node.data < parent.data) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}
			// 4th Case when both are not null
			else {
				// either take max form left or min from right
				int temp = max(node.left);
				remove(node.left, node, temp);
				node.data = temp;
			}
		}
	}

	public void add(int item) {

		add(this.root, item);
	}

	private void add(Node node, int item) {

		if (item <= node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		} else if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else
				add(node.right, item);

		}
	}

	public void duplicate() {
		this.duplicate(this.root);
	}

	private void duplicate(Node node) {
		if (node == null) {
			return;
		}

		duplicate(node.left);
		duplicate(node.right);

		Node oldleft = node.left;
		node.left = new Node(node.data);
		node.left.left = oldleft;

	}

	// Print all nodes at distance k from root
	public void kdistfromroot(int k) {
		kdistfromroot(this.root, k);
	}

	private void kdistfromroot(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data + " ");
			return;
		} else {
			kdistfromroot(node.left, k - 1);
			kdistfromroot(node.right, k - 1);
		}
	}

	// Print all nodes at distance k from given Node
	public void kdistfromnode(int target, int k) {
		kdistfromnode(this.root, target, k);
	}

	private int kdistfromnode(Node node, int target, int k) {

		if (node == null) {
			return -1;
		}

		if (node.data == target) {
			kdistfromroot(node, k);
			return 0;
		}

		// Recur for left subtree
		int dl = kdistfromnode(node.left, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {

			// If root is at distance k from target, print root
			// Node that dl is Distance of root's left child from
			// target
			if (dl + 1 == k) {
				System.out.print(node.data + " ");
			}

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				kdistfromroot(node.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		int dr = kdistfromnode(node.right, target, k);

		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.data + " ");
			} else
				kdistfromroot(node.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}
}