package Stack_Queue_LL;
/**
 * @author Rishabh
 */
public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {

			int[] oa = this.data;
			int[] na = new int[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				na[i] = oa[i];
			}
			this.data = na;			//points to new array
		}

		super.push(item);
	}

}
