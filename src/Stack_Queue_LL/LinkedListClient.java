package Stack_Queue_LL;

import java.util.Scanner;

/**
 * @author Rishabh
 */
public class LinkedListClient {
static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(30);
//		list.display();
//		list.addFirst(80);
//		list.addLast(50);
//		list.display();
//		System.out.println(list.getAt(2));
//		System.out.println(list.getLast());
//		System.out.println(list.getFirst());
//		list.addAt(15, 2);
//		list.display();
//		list.removeLast();
//		list.removeFirst();
//		list.Kreverse(2);
//		list.removeAt(1);
//		list.display();
		list.addLast(45);
//		list.display();
//		System.out.println(list.Mid());
		list.addLast(50);
//		list.display();
//		System.out.println(list.Mid());
//		list.RDR();
//		list.fold();
//		list.display();
//		System.out.println(list.kfromlast(2));
//		System.out.println(list.getLast());
//		list.mergesort();
//		list.swaptwoelements(15, 80);
//		list.oddevendisp();
		list.display();
//		System.out.println(list.isPalindrome());
//		list.removeDuplicates();
		
		list.createDummyList();
		list.cycleremoval();
		list.display();
	}
}
