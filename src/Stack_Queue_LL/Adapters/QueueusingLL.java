package Stack_Queue_LL.Adapters;

import Stack_Queue_LL.LinkedList;

/**
 * @author Rishabh
 * 
 * @date 23-Jun-2018
*/

public class QueueusingLL {
	LinkedList list = new LinkedList();

	public void enqueue(int item) throws Exception {

		try {
			list.addLast(item);				//O(1)
		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}
	}

	public int dequeue() throws Exception {

		try {
			return list.removeFirst();			//O(1)
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}

	}

	public int getFront() throws Exception {

		try {
			return list.getFirst();				//O(1)
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}

	}

	public void display() throws Exception {

		list.display();
	}

}
