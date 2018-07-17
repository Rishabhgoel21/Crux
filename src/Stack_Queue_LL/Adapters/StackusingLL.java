package Stack_Queue_LL.Adapters;

import Stack_Queue_LL.LinkedList;

/**
 * @author Rishabh
 * 
 * @date 23-Jun-2018
*/

public class StackusingLL {

	LinkedList list = new LinkedList();

	public void push(int item) throws Exception {

		try {
			list.addFirst(item);			//O(1)
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}
	}

	public int pop() throws Exception {

		try {
			return list.removeFirst();			//O(1)
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public int top() throws Exception {

		try {
			return list.getFirst();			//O(1)
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public void display() throws Exception {

		list.display();
	}

}
