package Stack_Queue_LL;
/**
 * @author Rishabh
 */
public class QueueclientQues {

	public static void main(String[] args) throws Exception {
		
		Queue q = new Queue();
		q.enqueue(10);
//		q.display();
		q.enqueue(20);
//		q.display();
		q.enqueue(30);
//		q.display();
		q.dequeue();
//		q.display();
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		
//		actualreverse(q);
		displayreverse(q,0);
		q.display();
	}
	
	
	public static void actualreverse(Queue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();

		actualreverse(q);

		q.enqueue(temp);
	}
	
	public static void displayreverse(Queue q, int count) throws Exception {
		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);
		displayreverse(q,count+1);
		System.out.println(temp);
	}


}
