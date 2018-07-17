package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Logarithm {

	public static void main(String[] args) {


		 Scanner sc = new Scanner(System.in);
	     double x = sc.nextInt();
	     double n = sc.nextInt();
	     int ans = logg(x,n);
	     System.out.println((int)ans);

	    }
	    public static int logg(double x,double n){
	        
	     double ans =(Math.log10(x)/Math.log10(n));			//bcoz here we will get ans in double format
	     return((int)ans);
	}
	

}