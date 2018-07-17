package Stack_Queue_LL;

/**
 * @author Rishabh
 */
public class StackclientQues {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(10);
		s.display();
		s.push(20);
		s.display();
		s.push(30);
		s.push(40);
		s.push(50);
		// s.push(60);
		s.display();
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.top());
		s.display();
		System.out.println();
		reversedisp(s);
		s.display();
		Stack hlpr = new Stack();
		actualreverse(s, hlpr);
		System.out.println();

		s.display();

	}

	public static void reversedisp(Stack s) throws Exception {
		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();

		reversedisp(s);

		System.out.println(temp);
		s.push(temp);
	}

	public static void actualreverse(Stack s, Stack hlpr) throws Exception {
		if (s.isEmpty()) {
			if (hlpr.isEmpty()) {
				return;
			}
			int temph = hlpr.pop();
			actualreverse(s, hlpr);
			s.push(temph);

			return;
		}
		hlpr.push(s.pop());
		actualreverse(s, hlpr);
	}

	public static void NextGreaterElement(int arr[]) throws Exception {
		int n = arr.length;

		int i = 0;
		Stack s = new Stack();
		int element, next;

		// push
		s.push(arr[0]);

		for (i = 1; i < n; i++) {
			next = arr[i];

			// if stack is not empty, then pop
			if (s.isEmpty() == false) {

				element = s.pop();

				// COMPARE
				while (element < next) {
					System.out.println(element + "," + next);
					if (s.isEmpty() == true) {
						break;
					}
					element = s.pop();
				}

				// If element is greater than next, then push the element back
				if (element > next) {
					s.push(element);
				}

			}
			// push next to stack so that we can find next greater for it
			s.push(next);
		}

		// if no greater available, print -1 for them
		while (s.isEmpty() == false) {
			element = s.pop();
			next = -1;
			System.out.println(element + "," + next);
		}
	}


}