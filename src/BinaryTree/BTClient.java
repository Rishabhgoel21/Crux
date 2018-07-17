package BinaryTree;

/**
 * @author Rishabh
 * 
 * @date 27-Jun-2018
 */

public class BTClient {

	public static void main(String[] args) {

		// "10 true 20 true 30 false false false false"
		String str = "10 true 20 true 30 false false true 40 true 50 false false false true 80 true 60 false false true 70 false false";
		// String str1 = "10 true 20 true 30 false false true 40 true 50 false false
		// false true 80 true 60 false false true 70 false false";

		// int[] pre = {10,20,40,50,60,80,30,70};
		// int[] post = {40,80,60,50,20,70,30,10};
		// int[] in = {40,20,80,60,50,10,30,70};
		// int[] pre = { 100, 50, 20, 10, 25, 60, 200, 150, 120, 160, 250, 270, 300 };
		// int[] in = { 10, 20, 25, 50, 60, 100, 120, 150, 160, 200, 250, 270, 300 };
		// BinaryTree bt = new BinaryTree(pre, in);
		BinaryTree bt = new BinaryTree(str);
		// BinaryTree bto = new BinaryTree(str1);

		// bt.display();
		// bt.largestBST();
		// System.out.println(bt.size());
		// System.out.println(bt.max());
		// System.out.println(bt.height());
		// System.out.println(bt.finditem(50));
		// System.out.println(bt.diameter2());
		// System.out.println(bt.treebalanced());
		// bt.preorder();
		// bt.display();
		// bt.levelorderlwrec();
		// bt.levelorderzz();
		// System.out.println(bt.identicalTrees(bto));
		// bt.buildFromLevelorder();
		// bt.printallleafnodes();
		// bt.display();
		// bt.leftview();
		// bt.rightview();
		// bt.bottomView();
		// bt.printLevelOrder();
//		System.out.println(bt.findLCA(20, 70));
		bt.root2leaf(60);
	}

}
