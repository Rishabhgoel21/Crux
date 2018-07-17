package Generic;

/**
 * @author Rishabh
 */
public class LinkedListgeneric<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public T getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	// o(1)
	public T getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;

	}

	// o(n)
	public T getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;

	}

	// o(n)
	public Node getNodeAt(int idx) throws Exception {

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp;

	}

	// O(1)
	public void addFirst(T item) {

		// 1.New Node
		Node nn = new Node();
		nn.data = item;
		nn.next = head;

		// 2.Attach
		if (size > 0) {
			this.head = nn;
		}
		// 3.Summary Display
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		}
		this.size++;

	}

	// O(1)
	public void addLast(T item) {

		// 1. New Node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// 2. Attach
		if (size > 0) {
			this.tail.next = nn;
		}
		// 3. Summary Display
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	// O(n)
	public void addAt(T item, int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size - 1) {
			addLast(item);
		} else {

			Node nn = new Node();
			nn.data = item;

			Node nm1 = getNodeAt(idx - 1); // node n minus 1
			Node np1 = getNodeAt(idx);
			nm1.next = nn;
			nn.next = np1; // or nn.next = nm1.next

			this.size++;
		}
	}

	// O(n)
	public T removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		Node ln = this.tail;
		Node sm2 = getNodeAt(this.size - 2);
		sm2.next = null;
		this.tail = sm2;

		this.size--;

		return ln.data;
	}

	// O(1)
	public T removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		Node fn = this.head;
		Node np1 = getNodeAt(1);
		this.head = np1;

		this.size--;

		return fn.data;
	}

	// O(n)
	public void removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			removeFirst();
		} else if (idx == this.size - 1) {
			removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1); // node n minus 1
			Node np1 = getNodeAt(idx + 1);
			nm1.next = np1;

			this.size--;
		}
	}

	public int size() {
		return this.size;
	}

	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}