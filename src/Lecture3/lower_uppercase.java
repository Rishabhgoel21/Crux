package Lecture3;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class lower_uppercase {

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		
		char ch = scn.nextLine().charAt(0);
		
		if(ch>='a'&& ch<='z')
		{
			System.out.println("Lowercase");
		}
		else if(ch>='A' && ch<='Z')
		{
			System.out.println("Uppercase");
		}
		else
		{
			System.out.println("Invalid");
		}
		
		
	}

}
