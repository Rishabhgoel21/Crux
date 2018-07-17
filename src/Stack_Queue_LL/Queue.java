package Stack_Queue_LL;
/**
 * @author Rishabh
 * 
*/
public class Queue {

	protected int[] data;
	protected int front;
	public int size;

	public Queue() {
		this.front = 0;
		this.size = 0;
		this.data = new int[5];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {

		return this.size() == 0;

	}

	public void enqueue(int item) throws Exception {
		if (this.data.length == this.size) {
			throw new Exception("Queue is Full");
		}
		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.data[this.front];
		
		this.size--;
		this.front = (this.front + 1) % this.data.length;

		return rv;
	}

	public int front() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.data[front];
		return rv;
	}

	public void display() {

		for (int i = 0; i < size; i++) {
			int idx = (this.front + i) % this.data.length;
			System.out.print(this.data[idx] + " ");

		}
		System.out.println(".");
		System.out.println();
	}
}
