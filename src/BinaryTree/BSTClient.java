package BinaryTree;

/**
 * @author Rishabh
 * 
 * @date 30-Jun-2018
 */

public class BSTClient {

	public static void main(String[] args) {
		int[] in = { 3, 5, 7, 10, 15, 20, 25 };
		BST bst = new BST(in);

		// bst.display();
		// System.out.println(bst.max());
		// System.out.println(bst.ht());
		// System.out.println(bst.find(15));
		// System.out.println(bst.size());
		// bst.printinRange(6, 30);
		// bst.printDec();
		// bst.replacewithSumofLarger();
		// bst.display();
		// bst.add(90);
		// bst.remove(15);
		bst.display();
//		bst.kdistfromroot(2);
		bst.kdistfromnode(25, 2);
	}

}
