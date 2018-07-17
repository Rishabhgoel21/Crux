package Arrays;
/**
 * @author Rishabh
 */
public class copy__compare_arrays {

	public static void main(String[] args) {
		int[] x = {23,24,25};
		
		//method to copy a array
		
		int[] y = x.clone();
		
		/*//if you do like
		int[] y=x; then this is refernce means if u change any
		value in y it will also change in x*/
		
		
		//COMPARE ARRAYS
		
		
		for (int k = 0; k < chck.length; k++) {

            if (chck[k] != arr1[k]) {
               
                System.out.println("false");		//print false as any value mismatch the array
                break;
                
            } else {
            
                System.out.println("true");
                break;
                
            }}
	
	}

}
