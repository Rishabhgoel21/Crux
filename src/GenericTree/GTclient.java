package GenericTree;

/**
 * @author Rishabh
 * 
 * @date 24-Jun-2018
 */

public class GTclient {

	public static void main(String[] args) {

		String str = "10 3 20 2 50 0 60 0 30 1 70 2 100 1 120 0 110 0 40 2 80 0 90 0";
		GenericTree gt = new GenericTree(str);
		String ostr = "10 2 20 2 50 0 60 0 30 1 70 2 100 1 120 0 110 0";
		
		GenericTree gto = new GenericTree(ostr);
		// String str1 = "10 3 20 2 50 0 60 0 30 1 70 2 100 1 120 0 110 0 40 2 80 0 90
		// 0";
		// GenericTree other = new GenericTree(str1);
//		gt.depthvalue();
		 gt.display();
		// gt.size();
		// gt.max();
		// gt.finditem(60);
		// gt.height();
		// gt.mirror();
		// gt.display();
		// gt.preorder();
		// gt.postorder();
		// gt.levelorderrec();
		// System.out.println();
		// gt.levelorderiter();
		// gt.levelorderlwrec();
		// gt.levelorderlw();
		// gt.levelorderzz();
		// gt.multisolver(50);
		// gt.multisolver(30);
		// gt.isMirror(other);
		// System.out.println(gt.nextLargest(100));
//		System.out.println(gt.secondLargest());
		System.out.println(gt.identicalTrees(gto));
	}

}
