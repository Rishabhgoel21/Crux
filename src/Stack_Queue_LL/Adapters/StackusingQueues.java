package Stack_Queue_LL.Adapters;

import Stack_Queue_LL.DynamicQueue;

/**
 * @author Rishabh
 */
public class StackusingQueues {

	DynamicQueue queue = new DynamicQueue();

	//push efficient o(1)
	public void push(int item) throws Exception {

		try {
			queue.enqueue(item);

		} catch (Exception e) {
			throw new Exception("Stack is Full");
		}
	}

	//o(n)
	public void pop(int item) throws Exception {

		DynamicQueue hlpr = new DynamicQueue();
		try {
			while (queue.size != 1) {
				int temp = queue.dequeue();
				hlpr.enqueue(temp);
			}

		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}

		int rv = queue.dequeue();
		System.out.println(rv);
		queue = hlpr;
	}

	//o(n)
	public void top(int item) throws Exception {

		DynamicQueue hlpr = new DynamicQueue();
		try {
			while (queue.size != 1) {
				int temp = queue.dequeue();
				hlpr.enqueue(temp);
			}

		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}

		int rv = queue.dequeue();
		System.out.println(rv);
		hlpr.enqueue(rv);
		queue = hlpr;
	}

	public void display() throws Exception {
		displayreverse(0);
	}

	private void displayreverse(int count) throws Exception {
		if (count == queue.size()) {
			return;
		}

		int temp = queue.dequeue();
		queue.enqueue(temp);
		displayreverse(count + 1);
		System.out.println(temp);
	}
}
