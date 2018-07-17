package Stack_Queue_LL;
/**
 * @author Rishabh
 */
public class DynamicQueueclient {

	public static void main(String[] args) throws Exception {

		DynamicQueue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.dequeue();
		q.enqueue(60);
		q.display();
		q.enqueue(40);
		q.enqueue(50);
		
		q.display();
		
		q.enqueue(80);
		q.enqueue(60);
		q.display();
	}

}
