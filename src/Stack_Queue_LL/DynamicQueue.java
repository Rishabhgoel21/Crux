package Stack_Queue_LL;
/**
 * @author Rishabh
 */
public class DynamicQueue extends Queue{

	@Override
	public void enqueue(int item) throws Exception {
		
		if (this.size() == this.data.length) {
			
			int[] oa = this.data;
			int[] na = new int[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				int idx = (this.front + i) % this.data.length;
				na[i] = oa[idx];
			}
			this.data = na;			//points to new array
			this.front = 0 ;
		}

		super.enqueue(item);
	}
}
