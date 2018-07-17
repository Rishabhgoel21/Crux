package Stack_Queue_LL;

import java.util.Scanner;

/**
 * @author Rishabh
 * 
 * @date 27-Jun-2018
 */

public class circularLL {

	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);

		LinkedList l = new LinkedList();

		for (int i = 0; i < 100000; i++) {

			int s = scn.nextInt();

			if (s == -1) {

				break;

			}

			l.addLast(s);

		}

		l.duplicate();

		l.display();

		// System.out.println(l.removelast());

	}

	public static class LinkedList {

		private static class Node {

			int data;

			Node next;

		}

		private Node head;

		private Node tail;

		private int size;

		public int getFirst() throws Exception {

			if (this.size == 0) {

				throw new Exception("List is Empty");

			}

			return head.data;

		}

		public int getLast() throws Exception {

			if (this.size == 0) {

				throw new Exception("List is Empty");

			}

			return tail.data;

		}

		public int getAt(int idx) throws Exception {

			if (size == 0) {

				throw new Exception("List is empty");

			}

			if (idx >= this.size) {

				throw new Exception("Invalid Index");

			}

			Node temp = new Node();

			temp = head;

			for (int i = 1; i <= idx; i++) {

				temp = temp.next;

			}

			return temp.data;

		}

		public void addLast(int item) {

			// new node

			Node nn = new Node();

			nn.data = item;

			nn.next = null;

			// attach

			if (this.size > 0) {

				tail.next = nn;

			}

			// updation

			if (this.size == 0) {

				head = nn;

				tail = nn;

				this.size++;

			} else {

				tail = nn;

				this.size++;

			}

		}

		public void display() {

			Node temp = head;

			while (temp != null) {

				System.out.print(temp.data + " ");

				temp = temp.next;

			}

		}

		public void remove(int idx) {

			Node temp = head;

			for (int i = 1; i <= idx - 1; i++) {

				temp = temp.next;

			}

			temp = temp.next.next;

			size--;

		}

		public void addFirst(int item) {

			Node nn = new Node();

			nn.data = item;

			nn.next = head;

			if (size == 0) {

				head = nn;

				tail = nn;

				size++;

			} else {

				head = nn;

				size++;

			}

		}

		private Node getnodeAt(int idx) throws Exception {

			if (size == 0) {

				throw new Exception("List is empty");

			}

			if (idx >= this.size) {

				throw new Exception("Invalid Index");

			}

			Node temp = new Node();

			temp = head;

			for (int i = 1; i <= idx; i++) {

				temp = temp.next;

			}

			return temp;

		}

		public void addat(int idx, int item) throws Exception {

			if (idx < 0 || idx > size) {

				throw new Exception("Invalid index");

			}

			if (idx == 0) {

				addFirst(item);

			}

			if (idx == size) {

				addLast(item);

			} else {

				Node nn = new Node();

				nn.data = item;

				nn.next = null;

				Node nm1 = getnodeAt(idx - 1);

				Node n = nm1.next;

				nm1.next = nn;

				nn.next = n;

				size++;

			}

		}

		public int removelast() throws Exception {

			if (size == 0) {

				throw new Exception("list is empty");

			}

			if (size == 1) {

				int val = head.data;

				head = null;

				tail = null;

				size--;

				return val;

			}

			int val = tail.data;

			Node nm = getnodeAt(size - 2);

			nm.next = null;

			tail = nm;

			size--;

			return val;

		}

		public int removefisrst() throws Exception {

			if (size == 0) {

				throw new Exception("list is empty");

			}

			if (size == 1) {

				int val = head.data;

				head = null;

				tail = null;

				size--;

				return val;

			}

			int val = head.data;

			Node temp = head.next;

			head.next = null;

			head = temp;

			size--;

			return val;

		}

		public int removeat(int idx) throws Exception {

			if (idx < 0 || idx >= size) {

				throw new Exception("Invalid index");

			}

			if (idx == 0) {

				return removefisrst();

			}

			if (idx == size - 1) {

				return removelast();

			} else {

				Node nm1 = getnodeAt(idx - 1);

				Node n = nm1.next;

				Node np1 = n.next;

				nm1.next = np1;

				n.next = null;

				size++;

				return n.data;

			}

		}

		public void duplicate() throws Exception {

			Node temp = head;

			int count1 = 0;

			while (temp != null) {

				Node point = temp.next;

				int count = 1;

				while (point != null) {

					if (point.data == temp.data) {

						point = point.next;

						this.removeat(count + count1);

					} else {

						point = point.next;

						count++;

					}

				}

				count1++;

				temp = temp.next;

			}

		}

	}

}