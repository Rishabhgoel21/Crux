package Stack_Queue_LL;
/**
 * @author Rishabh
 * 
 * @date 21-Jun-2018
*/

public class StockSpan {
	
	//span - the no. of days before the particular price which were lower than the given price

	public static void main(String[] args) throws Exception {

		int[] prices = { 2,3,1,8,6,2,5,10,7};
		int[] span = stockspan(prices);
		for(int val : span) {
			System.out.print(val + " ");
		}
		
		// ans- 1 2 1 4 1 1 2 8 1

	}
	
	public static int[] stockspan(int[] prices) throws Exception {
		DynamicStack stack  = new DynamicStack();
		
		int[] span = new int[prices.length];
		span[0] = 1;
		stack.push(0);
		for(int i = 1; i < prices.length ; i++) {
			
			while(!stack.isEmpty() && prices[stack.top()] < prices[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				span[i] = i +1;
			}else
			{
				span[i] = i - stack.top();
			}
			
			stack.push(i);
		}
		
		
		
		return span;
	}

}
