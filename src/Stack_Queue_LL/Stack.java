package Stack_Queue_LL;

/**
 * @author Rishabh
 */
public class Stack {

	protected int[] data;
	protected int tos;

	public Stack() {
		this.data = new int[5];
		this.tos = -1;
	}

	public Stack(int cap) {
		this.data = new int[cap];
		this.tos = -1;
	}

	public int size() {
		int size = this.tos + 1;
		return size;
	}

	public boolean isEmpty() {

		return this.size() == 0;

	}

	public void push(int item) throws Exception {
		if (this.data.length == this.tos) {
			throw new Exception("Stack is Full");
		}
		this.tos++;
		this.data[tos] = item;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.data[this.tos];
		this.tos--;

		return rv;
	}

	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		int rv = this.data[tos];
		return rv;
	}

	public void display() {

		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + " ");

		}

	}

	public static boolean balancedParenthensies(String str) throws Exception {
		Stack s = new Stack();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				s.push(c);
			} else if (c == ']') {
				if (s.isEmpty() || s.pop() != '[') {
					return false;
				}
			} else if (c == ')') {
				if (s.isEmpty() || s.pop() != '(') {
					return false;
				}
			} else if (c == '}') {
				if (s.isEmpty() || s.pop() != '{') {
					return false;
				}
			}

		}
		return s.isEmpty();
	}

}