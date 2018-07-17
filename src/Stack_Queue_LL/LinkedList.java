package Stack_Queue_LL;

/**
 * @author Rishabh
 */
public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	// o(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;

	}

	// o(n)
	public int getAt(int idx) throws Exception {

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
	public void addFirst(int item) {

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
	public void addLast(int item) {

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
	public void addAt(int item, int idx) throws Exception {

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
	public int removeLast() throws Exception {

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
	public int removeFirst() throws Exception {

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

	public int Mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;

	}

	public Node midnode() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public int kfromlast(int k) {
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void Kreverse(int k) throws Exception {
		LinkedList prev = null;
		LinkedList curr = null;
		while (this.size != 0) {
			curr = new LinkedList();
			for (int i = 1; i <= k; i++) {

				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size = prev.size + curr.size;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	// Reverse Data iteratively
	public void RDI() throws Exception {
		int left = 0;
		int right = this.size - 1;

		while (left < right) {
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}
	}

	// Reverse pointer iteratively
	public void RPI() {
		Node curr = this.head;
		Node prev = null;
		Node forward = null;

		while (curr.next != null) {

			forward = curr.next;
			curr.next = prev;
			prev = curr;

			curr = forward;
		}

		this.tail = this.head;
		this.tail.next = null;
		this.head = curr;
		this.head.next = prev;

	}

	// Reverse pointer recursively
	public void RPR() {
		Node prev = this.head;
		Node curr = this.head.next;

		RPRH(prev, curr);

		// swap head and tail
		this.head = this.tail;
		this.tail = prev;
		this.tail.next = null;

	}

	public void RPRH(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		RPRH(curr, curr.next);
		curr.next = prev;
	}

	private class Mover {
		Node left;
	}

	// Reverse Data Recursively
	public void RDR() {
		Mover mover = new Mover();

		mover.left = this.head;
		RDRH(mover, this.head, 0);
	}

	public void RDRH(Mover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		RDRH(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;

	}

	public void fold() {

		Mover mover = new Mover();
		mover.left = this.head;
		Fold(mover, this.head, 0);
	}

	private void Fold(Mover mover, Node right, int count) {
		if (right == null) {
			return;
		}

		Fold(mover, right.next, count + 1);

		if (count > size / 2) {
			Node temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;

			mover.left = temp;
		}

		if (count == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public LinkedList mergetwoLL(LinkedList other) {

		Node temp1 = this.head;
		Node temp2 = other.head;

		LinkedList merged = new LinkedList();

		while (temp1 != null && temp2 != null) {

			if (temp1.data > temp2.data) {
				merged.addLast(temp2.data);
				temp2 = temp2.next;
			} else {
				merged.addLast(temp1.data);
				temp1 = temp1.next;
			}
		}

		if (temp1 == null) {
			while (temp2 != null) {
				merged.addLast(temp2.data);
				temp2 = temp2.next;
			}
		}

		if (temp2 == null) {
			while (temp1 != null) {
				merged.addLast(temp1.data);
				temp1 = temp1.next;
			}
		}

		return merged;
	}

	public void mergesort() {
		if (this.size == 1) {
			return;
		}
		Node mid = midnode();
		Node midn = mid.next;

		// break Linked list in two
		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();
		sh.head = midn;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2;

		fh.mergesort();
		sh.mergesort();

		LinkedList merged = fh.mergetwoLL(sh);

		this.head = merged.head;
		this.tail = merged.tail;
		this.size = merged.size;
	}

	public void swaptwoelements(int n1, int n2) {

		Node temp1 = this.head;

		for (int i = 0; i < this.size; i++) {
			if (temp1.data == n1) {
				break;
			}
			temp1 = temp1.next;
		}

		Node temp2 = this.head;

		for (int i = 0; i < this.size; i++) {
			if (temp2.data == n2) {
				break;
			}
			temp2 = temp2.next;
		}

		int temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;

	}

	public boolean isPalindrome() throws Exception {
		boolean a = true;
		Node temp1 = this.head;
		Node temp2 = this.tail;

		for (int i = 1; i <= this.size / 2; i++) {
			if (temp1.data != temp2.data) {
				// a = false;
				return false;
			}

			temp1 = temp1.next;
			temp2 = getNodeAt(this.size - i - 1);

		}
		return a;
	}

	public void oddevendisp() {

		LinkedList temp = new LinkedList();
		Node temp1 = this.head;
		Node temp2 = this.head;
		for (int i = 0; i < this.size; i++) {
			if (temp1.data % 2 != 0) {
				temp.addLast(temp1.data);
			}
			temp1 = temp1.next;
		}
		for (int i = 0; i < this.size; i++) {
			if (temp2.data % 2 == 0) {
				temp.addLast(temp2.data);
			}
			temp2 = temp2.next;
		}

		this.head = temp.head;
		this.tail = temp.tail;
		this.size = temp.size;
	}

	// from sorted LL
	public void removeDuplicates() {
		Node current = this.head;

		// if the list is empty
		if (head == null) {
			return;
		}

		// Traverse list
		while (current.next != null) {

			// Compare
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}

	public void createDummyList() {

		Node n1 = new Node();
		n1.data = 10;
		Node n2 = new Node();
		n2.data = 20;
		Node n3 = new Node();
		n3.data = 30;
		Node n4 = new Node();
		n4.data = 40;
		Node n5 = new Node();
		n5.data = 50;
		Node n6 = new Node();
		n6.data = 60;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n4;

		this.head = n1;
		// this.tail = n6;
		this.size = 6;
	}

	public void cycleremoval() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		// if loop is present than only
		if (slow == fast) {
			Node startLL = this.head;
			Node LoopLL = slow;

			while (startLL.next != LoopLL.next) {
				startLL = startLL.next;
				LoopLL = LoopLL.next;
			}
			LoopLL.next = null;
			this.tail = LoopLL;
		}
	}
}
