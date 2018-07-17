package Lecture1;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class sumofoddevenplaces {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);

		int n=scn.nextInt();

		int sodd=0;
		int seven=0;

		while(n!=0){
		    
		    sodd = sodd + (n%10) ;
		    
		    n = n / 10;
		    seven = seven + (n%10);
		    
		    n = n / 10;
		}
		System.out.println(sodd);
		System.out.println(seven);
		    
		
	}

}
